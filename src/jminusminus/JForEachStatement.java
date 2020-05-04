package jminusminus;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class JForEachStatement extends JStatement {

    private final JVariableDeclarator init;
    private final JExpression list;
    private final JStatement body;
    JVariableDeclaration initializer;
    private JExpression condition;
    private JVariableDeclaration next;
    private boolean isCollection = false;
    private JExpression incExpr;
    private JVariableDeclaration aPrime;
    private JVariableDeclaration incrementerInit;
    private JVariableDeclaration arrayLength;

    protected JForEachStatement(int line, JVariableDeclarator init, JExpression list, JStatement body) {
        super(line);
        this.init = init;
        this.list = list;
        this.body = body;

    }

    @Override
    public JAST analyze(Context context) {

        list.analyze(context);

        if (Type.ITERABLE.isJavaAssignableFrom(list.type())) {
            isCollection = true;
        } else if (!list.type().isArray()) {
            JAST.compilationUnit.reportSemanticError(line, "Variable must have have type iterable or array: \"%s\"", list.type().toString());
        }

        if (isCollection) {
            JMessageExpression method = new JMessageExpression(line, list, "iterator", new ArrayList<>());
            ArrayList<JVariableDeclarator> variables = new ArrayList<>();
            method.analyze(context);
            JVariable iterator = new JVariable(line, "@" + LocalDateTime.now()); // Unique name since variable name @ is not allowed
            variables.add(new JVariableDeclarator(line, iterator.name(), method.type(), method));
            initializer = new JVariableDeclaration(line, null, variables);
            initializer.analyze(context);

            condition = new JMessageExpression(line, iterator,
                    "hasNext", new ArrayList<>());
            condition.analyze(context);

            init.setInitializer(new JMessageExpression(line, iterator, "next", new ArrayList<>()));
            ArrayList<JVariableDeclarator> vars = new ArrayList<>();
            vars.add(init);
            next = new JVariableDeclaration(line, null, vars);
            next.analyze(context);

        } else {

            // T[] a' = Expression - a': #3, Expression: #2
            ArrayList<JVariableDeclarator> aPrimeVars = new ArrayList<>();
            JVariable arrayVar = new JVariable(line, LocalDateTime.now().toString());
            aPrimeVars.add(new JVariableDeclarator(line, arrayVar.name(), list.type(), list));
            aPrime = new JVariableDeclaration(line, null, aPrimeVars);
            aPrime.analyze(context);
//            arrayVar.type().resolve(context);

            // int i' = 0; #4
            ArrayList<JVariableDeclarator> iPrimeVars = new ArrayList<>();
            JVariable incrementer = new JVariable(line, "@" + LocalDateTime.now());
            iPrimeVars.add(new JVariableDeclarator(line, incrementer.name(), Type.INT, new JLiteralInt(line, "0")));
            initializer = new JVariableDeclaration(line, null, iPrimeVars);
            initializer.analyze(context);

            // Type Identifier = a'[i'];
            ArrayList<JVariableDeclarator> identifierVars = new ArrayList<>();
            JVariable iterator = new JVariable(line, init.name());
            identifierVars.add(new JVariableDeclarator(line, iterator.name(), init.type(), new JArrayExpression(line, list, incrementer)));
            next = new JVariableDeclaration(line, null, identifierVars);
            next.analyze(context);

            // i++;
            incExpr = new JPreIncrementOp(line, incrementer);
            incExpr.isStatementExpression = true; // Because it has side effect
            incExpr.analyze(context);

            // Condition
            // i' < a'.length
            JFieldSelection arrayLengthExpr = new JFieldSelection(line, arrayVar, "length");

            condition = new JLessThanOp(line, incrementer, arrayLengthExpr);
            condition.analyze(context);
        }


        body.analyze(context);
//        init.type().mustMatchExpected(line, iterable.type().componentType());

        return this;
    }

    @Override
    public void codegen(CLEmitter output) {
        // New variable I i = Expression.iterator(); with type iterable.iterator()
        if (!isCollection)
            aPrime.codegen(output);

        String start = output.createLabel();
        String end = output.createLabel();

        initializer.codegen(output);
        output.addLabel(start);
        condition.codegen(output, end, false);
        next.codegen(output);
        body.codegen(output);

        if (!isCollection)
            incExpr.codegen(output);

        output.addBranchInstruction(CLConstants.GOTO, start);
        output.addLabel(end);

    }

    @Override
    public void writeToStdOut(PrettyPrinter p) {
        p.printf("<JForStatement line = \"%d\">\n", line());
        p.indentRight();

        p.printf("<VariableDeclaration>\n");
        p.indentRight();
        init.writeToStdOut(p);
        p.indentLeft();
        p.printf("</VariableDeclaration>\n");

        p.printf("<Iterable>\n");
        p.indentRight();
        list.writeToStdOut(p);
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
