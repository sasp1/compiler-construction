package jminusminus;

import java.util.ArrayList;

import static jminusminus.CLConstants.*;

class JBlockDeclaration extends JMethodDeclaration implements JMember {


    /** Does this constructor invoke this(...) or super(...)? */
    private boolean invokesConstructor;

    /** Defining class */
    JClassDeclaration definingClass;

    /**
     * Construct an AST node for a constructor declaration given the line
     * number, modifiers, constructor name, formal parameters, and the
     * constructor body.
     * 
     * @param line
     *            line in which the constructor declaration occurs in the source
     *            file.
     * @param mods
     *            modifiers.
     * @param name
     *            constructor name.
     * @param params
     *            the formal parameters.
     * @param body
     *            constructor body.
     */

    public JBlockDeclaration(int line, ArrayList<String> mods, JBlock body)
    {
        super(line, mods, "block " + ((int)(Math.random() * 10000000)), Type.ANY, new ArrayList<JFormalParameter>(), body, new ArrayList<>());
    }

    /**
     * Declare this block in the parent (class) context.
     * 
     * @param context
     *            the parent (class) context.
     * @param partial
     *            the code emitter (basically an abstraction for producing the
     *            partial class).
     */

    public void preAnalyze(Context context, CLEmitter partial) {
        super.preAnalyze(context, partial);
        if (isPrivate) {
            JAST.compilationUnit.reportSemanticError(line(),
                    "Blocks cannot be declared private");
        } else if (isPublic) {
            JAST.compilationUnit.reportSemanticError(line(),
                    "Blocks cannot be declared public");
        } else if (isProtected) {
            JAST.compilationUnit.reportSemanticError(line(),
                    "Blocks cannot be declared protected");
        } else if (isAbstract) {
            JAST.compilationUnit.reportSemanticError(line(),
                    "Blocks cannot be declared abstract");
        }
    }

    /**
     * Analysis for a block declaration is very much like that for a
     * method declaration.
     * 
     * @param context
     *            context in which names are resolved.
     * @return the analyzed (and possibly rewritten) AST subtree.
     */

    public JAST analyze(Context context) {
        // Record the defining class declaration.
        definingClass = (JClassDeclaration) context.classContext().definition();
        this.context = new MethodContext(context, isStatic, null);

        if (!isStatic) {
            // Offset 0 is used to address "this"
            this.context.nextOffset();
        }

        if (body != null) {
            body = body.analyze(this.context);
        }
        
        return this;

    }

    /**
     * Add this constructor declaration to the partial class.
     * 
     * @param context
     *            the parent (class) context.
     * @param partial
     *            the code emitter (basically an abstraction for producing the
     *            partial class).
     */

    public void partialCodegen(Context context, CLEmitter partial) {
        // Do we need this? Doesn't seem to affect anything
    }

    /**
     * Generate code for the constructor declaration.
     * 
     * @param output
     *            the code emitter (basically an abstraction for producing the
     *            .class file).
     */

    public void codegen(CLEmitter output) {
        body.codegen(output);
    }

    /**
     * @inheritDoc
     */

    public void writeToStdOut(PrettyPrinter p) {
        p.printf("<JBlockDeclaration line=\"%d\" " + "name=\"%s\">\n",
                line(), name);
        p.indentRight();
        if (context != null) {
            context.writeToStdOut(p);
        }
        if (mods != null) {
            p.println("<Modifiers>");
            p.indentRight();
            for (String mod : mods) {
                p.printf("<Modifier name=\"%s\"/>\n", mod);
            }
            p.indentLeft();
            p.println("</Modifiers>");
        }

        if (body != null) {
            p.println("<Body>");
            p.indentRight();
            body.writeToStdOut(p);
            p.indentLeft();
            p.println("</Body>");
        }
        p.indentLeft();
        p.println("</JBlockDeclaration>");
    }
	
}
