package jminusminus;

public class JForEachStatement extends JStatement {

    private final JExpression init;
    private final JExpression iterable;
    private final JStatement statement;

    protected JForEachStatement(int line, JExpression init, JExpression iterable, JStatement statement) {
        super(line);
        this.init = init;
        this.iterable = iterable;
        this.statement = statement;
    }

    @Override
    public JAST analyze(Context context) {
        init.analyze(context);
        iterable.analyze(context);
        statement.analyze(context);

        if (!Type.ITERABLE.isJavaAssignableFrom(iterable.type()) && !iterable.type().isArray()) {
            JAST.compilationUnit.reportSemanticError(line, "Variable must have have type iterable or array: \"%s\"", iterable.type().toString());
        }
        init.type().mustMatchExpected(line, iterable.type().componentType());
        return null;
    }

    @Override
    public void codegen(CLEmitter output) {

    }

    @Override
    public void writeToStdOut(PrettyPrinter p) {

    }
}
