package jminusminus;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

import static jminusminus.CLConstants.GOTO;

public class JForEachStatement extends JStatement {

    private final JVariableDeclarator init;
    private final JExpression iterable;
    private final JStatement statement;

    protected JForEachStatement(int line, JVariableDeclarator init, JExpression iterable, JStatement statement) {
        super(line);
        this.init = init;
        this.iterable = iterable;
        this.statement = statement;
    }

    @Override
    public JAST analyze(Context context) {
        init.analyze(context);

        int offset = ((LocalContext) context).nextOffset();
        LocalVariableDefn defn = new LocalVariableDefn(init.type().resolve(
                context), offset);
        context.addEntry(line, init.name(), defn);

        IDefn previousDefn = context.lookup(init.name());
        if (previousDefn != null
                && previousDefn instanceof LocalVariableDefn) {
            JAST.compilationUnit.reportSemanticError(init.line(),
                    "The name " + init.name()
                            + " overshadows another local variable.");
        }


        iterable.analyze(context);
        statement.analyze(context);

        if (!Type.ITERABLE.isJavaAssignableFrom(iterable.type()) && !iterable.type().isArray()) {
            JAST.compilationUnit.reportSemanticError(line, "Variable must have have type iterable or array: \"%s\"", iterable.type().toString());
        }
        init.type().mustMatchExpected(line, iterable.type().componentType());
        return this;
    }

    @Override
    public void codegen(CLEmitter output) {
//        String topLabel = output.createLabel();
//        String endLabel = output.createLabel();
//
//        output.addLabel(topLabel);
//        init.codegen(output);
//        iterable.codegen(output, endLabel, false);
//        statement.codegen(output);
//
//        output.addBranchInstruction(GOTO, topLabel);
//
//        output.addLabel(endLabel);

//			TODO: I would assume it is something like this, but it keeps loading from the array and goes out of bounds:
//			 "foreach signature: (I)I) Expecting to find integer on stack". Need to find out how to stop it when the
//			 empty
    }

    @Override
    public void writeToStdOut(PrettyPrinter p) {
        p.printf("<JForStatement line = \"%d\">\n", line());
        p.indentRight();

        p.printf("<VariableDeclaration>\n");
        p.indentRight();
        init.writeToStdOut(p);
        p.printf("</VariableDeclaration>\n");

        p.printf("<Iterable>\n");
        p.indentRight();
        iterable.writeToStdOut(p);
        p.indentLeft();
        p.printf("</Iterable>\n");


        p.printf("<Body>\n");
        p.indentRight();
        statement.writeToStdOut(p);
        p.indentLeft();
        p.printf("</Body>\n");

        p.indentLeft();
        p.printf("</JForStatement>\n");
    }
}
