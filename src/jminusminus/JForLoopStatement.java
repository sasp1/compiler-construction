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
        Context localContext = new LocalContext(context);
        if (init != null)
            init.analyze(localContext);


        if (cond != null) {
            cond.analyze(localContext);
            cond.type().mustMatchExpected(line, Type.BOOLEAN);
        }

        if (update != null)
            update.analyze(localContext);

        statement.analyze(localContext);
        return this;
    }

    @Override
    public void codegen(CLEmitter output) {
        String endLabel = output.createLabel();
        String topLabel = output.createLabel();

        if (init != null)
            init.codegen(output);

        output.addLabel(topLabel);

        if (cond != null)
            cond.codegen(output, endLabel, false); // maybe more?

        statement.codegen(output);

        if (update != null)
            update.codegen(output);

        output.addBranchInstruction(GOTO, topLabel);
        output.addLabel(endLabel);
    }

    @Override
    public void writeToStdOut(PrettyPrinter p) {

    }
}
