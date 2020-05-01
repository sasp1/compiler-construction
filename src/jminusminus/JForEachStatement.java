package jminusminus;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

import static jminusminus.CLConstants.*;

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

//        System.out.println("SEBA-2");
        int offset = ((LocalContext) context).nextOffset();
        LocalVariableDefn defn = new LocalVariableDefn(init.type().resolve(context), offset);
        defn.initialize();
        context.addEntry(line, init.name(), defn);

        System.out.println("type: "+init.type());

        init.analyze(context);

//        System.out.println("reaching ehre?");
        iterable.analyze(context);
//        System.out.println("reaching ehre?");
        statement.analyze(context);

        if (!Type.ITERABLE.isJavaAssignableFrom(iterable.type()) && !iterable.type().isArray()) {
            JAST.compilationUnit.reportSemanticError(line, "Variable must have have type iterable or array: \"%s\"", iterable.type().toString());
        }
//        init.type().mustMatchExpected(line, iterable.type().componentType());
        return this;
    }

    @Override
    public void codegen(CLEmitter output) {
        String topLabel = output.createLabel();
        String endLabel = output.createLabel();

        init.codegen(output);
        output.addNoArgInstruction(ALOAD_1);
        output.addNoArgInstruction(ASTORE_2);
        output.addNoArgInstruction(ALOAD_2);

        output.addNoArgInstruction(ARRAYLENGTH);
        output.addNoArgInstruction(ISTORE_3); // store array length on place 3 [3]
        output.addNoArgInstruction(ICONST_0); // load iterator to 0
        output.addOneArgInstruction(ISTORE, 4); // store it at place 5 0 => [4]

        output.addLabel(topLabel); // add label, because you don't want to go back to the above

        // condition
        output.addOneArgInstruction(ILOAD, 4); // loads iterator (index)
        output.addNoArgInstruction(ILOAD_3); // load array length
        output.addBranchInstruction(IF_ICMPGE, endLabel);

        iterable.codegen(output);

        output.addOneArgInstruction(ILOAD, 4); // 1 => stack 1

//        System.out.println("SEBA0");
        if (init.type() == Type.INT) {
//            System.out.println("SEBA1");
            output.addNoArgInstruction(IALOAD);
        } else if (init.type() == Type.CHAR) {
//            System.out.println("SEBA3");
//            output.addNoArgInstruction(I);
        } else {
//            System.out.println("SEBA2");
            output.addNoArgInstruction(AALOAD);
        }
//        System.out.println("WHAT");

        output.addOneArgInstruction(ISTORE, 2);
        statement.codegen(output);

        output.addIINCInstruction(4,1);
        output.addBranchInstruction(GOTO, topLabel);
//
//
        output.addLabel(endLabel);

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
