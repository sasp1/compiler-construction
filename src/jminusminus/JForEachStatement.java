package jminusminus;

import java.util.ArrayList;

public class JForEachStatement extends JStatement {

    private final JVariableDeclarator init;
    private final JExpression iterable;
    private final JStatement body;
    JVariableDeclaration initializer;
    private JExpression hasNext;
    private JVariableDeclaration next;

    protected JForEachStatement(int line, JVariableDeclarator init, JExpression iterable, JStatement body) {
        super(line);
        this.init = init;
        this.iterable = iterable;
        this.body = body;
    }

    @Override
    public JAST analyze(Context context) {

        iterable.analyze(context);
        body.analyze(context);

        if (Type.ITERABLE.isJavaAssignableFrom(iterable.type())) {
            JMessageExpression method = new JMessageExpression(line, iterable, "iterator", new ArrayList<>());
            ArrayList<JVariableDeclarator> variables = new ArrayList<>();
            method.analyze(context);

            JVariable iterator = new JVariable(line, "@"); // Unique name since variable name @ is normally not allowed
            variables.add(new JVariableDeclarator(line, iterator.name(), method.type(), method));
            initializer = new JVariableDeclaration(line, null, variables);
            initializer.analyze(context);

            hasNext = new JMessageExpression(line, iterator,
                    "hasNext", new ArrayList<>());
            hasNext.analyze(context);

            init.setInitializer(new JMessageExpression(line, iterator, "next", new ArrayList<>()));
            ArrayList<JVariableDeclarator> vars = new ArrayList<>();
            vars.add(init);
            next = new JVariableDeclaration(line, null, vars);
            next.analyze(context);
        } else if (iterable.type().isArray()) {
//            TODO: Needs to be implemented for regular arrays

        } else {
            JAST.compilationUnit.reportSemanticError(line, "Variable must have have type iterable or array: \"%s\"", iterable.type().toString());
        }



        System.out.println(iterable.type().toString());
//        init.type().mustMatchExpected(line, iterable.type().componentType());

        return this;
    }

    @Override
    public void codegen(CLEmitter output) {
        // New variable I i = Expression.iterator(); with type iterable.iterator()
        String start = output.createLabel();
        String end = output.createLabel();

        initializer.codegen(output);
        output.addLabel(start);
        hasNext.codegen(output, end, false);
        next.codegen(output);
        body.codegen(output);
        output.addBranchInstruction(CLConstants.GOTO, start);
        output.addLabel(end);

//        initializer.codegen(output);
//        init.codegen(output);

//        output.addMemberAccessInstruction(INVOKEINTERFACE, iterable.type().componentType().jvmName(), "iterator", "()Z");
//        output.addMemberAccessInstruction(INVOKESTATIC, iterable.type().componentType().jvmName(), "iterator", "()V");


//        String endLabel = output.createLabel();
//        String topLabel = output.createLabel();
//
//        init.codegen(output);
//
//        output.addLabel(topLabel);
//        cond.codegen(output, endLabel, false); // maybe more?
//        statement.codegen(output);
//        update.codegen(output);
//        output.addBranchInstruction(GOTO, topLabel);
//        output.addLabel(endLabel);


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
        body.writeToStdOut(p);
        p.indentLeft();
        p.printf("</Body>\n");

        p.indentLeft();
        p.printf("</JForStatement>\n");
    }
}
