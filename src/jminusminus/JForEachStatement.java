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
    private JVariable iterator;
    private JVariable incrementer;
    private JExpression incExpr;
    private JVariableDeclaration aPrime;

    protected JForEachStatement(int line, JVariableDeclarator init, JExpression list, JStatement body) {
        super(line);
        this.init = init;
        this.list = list;
        this.body = body;

    }

    @Override
    public JAST analyze(Context context) {

        list.analyze(context);

        if (Type.ITERABLE.isJavaAssignableFrom(list.type())){
            isCollection = true;
        } else if (!list.type().isArray()){
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

        } else  {
//            TODO: Needs to be implemented for regular arrays
//            JMessageExpression method = new JMessageExpression(line, list, "iterator", new ArrayList<>());

            // T[] a' = Expression
            ArrayList<JVariableDeclarator> aPrimeVars = new ArrayList<>();
            JVariable arrayVar = new JVariable(line, "@" + LocalDateTime.now());
            aPrimeVars.add(new JVariableDeclarator(line, arrayVar.name(), list.type(), list));
            aPrime = new JVariableDeclaration(line, null, aPrimeVars);
            aPrime.analyze(context);
//            arrayVar.type().resolve(context);

            // int i' = 0;
            ArrayList<JVariableDeclarator> iPrimeVars = new ArrayList<>();
            incrementer = new JVariable(line, "@" + LocalDateTime.now());
            iPrimeVars.add(new JVariableDeclarator(line, incrementer.name(), Type.INT, new JLiteralInt(line, "0")));
            JVariableDeclaration incrementerInit = new JVariableDeclaration(line, null, iPrimeVars);
            incrementerInit.analyze(context);

            // Type Identifier = a'[i'];
            ArrayList<JVariableDeclarator> identifierVars = new ArrayList<>();
            iterator = new JVariable(line, init.name());
            identifierVars.add(new JVariableDeclarator(line, iterator.name(), init.type(), new JArrayExpression(line, list, incrementer)));
            initializer = new JVariableDeclaration(line, null, identifierVars);
            initializer.analyze(context);

            // i++;
            incExpr = new JPostIncrementOp(line, incrementer);
            incExpr.analyze(context);

            // Condition
            // i' < a'.length
            JFieldSelection arrayLength = new JFieldSelection(line, list, "length");
            condition = new JLessThanOp(line, incrementer, arrayLength);
            condition.analyze(context);

//            JArrayExpression arrayAtIndex = new JArrayExpression(line, list, new JLiteralInt(line, ));
//            init.setInitializer();
//            JVariable incrementerVar = new JVariable(line, "@" + LocalDateTime.now());
//
//            identifierVars.add(new JVariableDeclarator(line, incrementerVar.name(), Type.INT, new JLiteralInt(line, "0")));
//            JVariableDeclaration incrementerInit = new JVariableDeclaration(line, null, identifierVars);
//            incrementerInit.analyze(context);

        }

        body.analyze(context);
//        init.type().mustMatchExpected(line, iterable.type().componentType());

        return this;
    }

    @Override
    public void codegen(CLEmitter output) {
        // New variable I i = Expression.iterator(); with type iterable.iterator()
        String start = output.createLabel();
        String end = output.createLabel();
//        initializer.codegen(output);
        aPrime.codegen(output);
        output.addLabel(start);

        condition.codegen(output, end, false);
        if (isCollection){
            next.codegen(output);
        } else {
            // Load array ref onto the stack
            list.codegen(output);
            // Load int i value onto the stack.
            incrementer.codegen(output);
            // aaload, to load value of array at index i to the stack
            output.addNoArgInstruction(CLConstants.AALOAD);
            // astore to store value from stack into identifier
            iterator.codegenStore(output);
        }

        body.codegen(output);
        if (!isCollection){
            // i++;
//            incExpr.codegen(output);
        }
        output.addBranchInstruction(CLConstants.GOTO, start);
        output.addLabel(end);


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
