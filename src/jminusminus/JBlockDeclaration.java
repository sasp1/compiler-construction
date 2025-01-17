package jminusminus;
import java.util.ArrayList;

import static jminusminus.CLConstants.*;

class JBlockDeclaration extends JAST implements JMember {

    /**
     * Construct an AST node for a block declaration given the line
     * number, modifiers and the
     * constructor body.
     * 
     * @param line
     *            line in which the block declaration occurs in the source
     *            file.
     * @param mods
     *            modifiers.
     * @param body
     *            block body.
     */

    private ArrayList<String> mods;

    private JBlock body;

    protected boolean isStatic;

    public JBlockDeclaration(int line, ArrayList<String> mods, JBlock body){
        super(line);
        this.mods = mods;
        this.body = body;
        this.isStatic = mods.contains("static");
    }

    public void preAnalyze(Context context, CLEmitter partial) {

        if (mods.contains("private")) {
            JAST.compilationUnit.reportSemanticError(line(),
                    "Blocks cannot be declared private");
        } else if (mods.contains("public")) {
            JAST.compilationUnit.reportSemanticError(line(),
                    "Blocks cannot be declared public");
        } else if (mods.contains("protected")) {
            JAST.compilationUnit.reportSemanticError(line(),
                    "Blocks cannot be declared protected");
        } else if (mods.contains("abstract")) {
            JAST.compilationUnit.reportSemanticError(line(),
                    "Blocks cannot be declared abstract");
        }
    }

    /*
     * @param context
     *            context in which names are resolved.
     * @return the analyzed (and possibly rewritten) AST subtree.
     */

    public JAST analyze(Context context) {

        if (body != null) {
            body = body.analyze(context);
        }
        return this;
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
        p.printf("<JBlockDeclaration line=\"%d\"",
                line());
        p.indentRight();
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
