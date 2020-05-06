package jminusminus;

import static jminusminus.CLConstants.GOTO;

public class JForLoopStatement extends JStatement {

    private JVariableDeclaration init;
    private JExpression cond;
    private JStatement update;
    private JStatement statement;

    public JForLoopStatement(int line, JVariableDeclaration init, JExpression cond, JStatement update, JStatement statement) {
        super(line);
        this.init = init;
        this.cond = cond;
        this.update = update;
        this.statement = statement;
    }
    @Override
    public JAST analyze(Context context) {
        init = (JVariableDeclaration) init.analyze(context);
        cond = cond.analyze(context);
        cond.type().mustMatchExpected(line, Type.BOOLEAN);
        update = (JStatement) update.analyze(context);
        statement = (JStatement) statement.analyze(context);
        return this;
    }

    @Override
    public void codegen(CLEmitter output) {
        String endLabel = output.createLabel();
        String topLabel = output.createLabel();

        init.codegen(output);
        output.addLabel(topLabel);
        cond.codegen(output, endLabel, false); // maybe more?
        statement.codegen(output);
        update.codegen(output);
        output.addBranchInstruction(GOTO, topLabel);
        output.addLabel(endLabel);
    }

    @Override
    public void writeToStdOut(PrettyPrinter p) {

    }
}
