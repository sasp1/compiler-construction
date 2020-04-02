package jminusminus;

public class JThrowExpression extends JExpression {
    private JExpression primary;

    public JThrowExpression(int line, JExpression primary) {
        super(line);
        this.primary = primary;
    }

    @Override
    public JExpression analyze(Context context) {
        primary.analyze(context);

//        TODO: Check that exception is handled (either that method throws it or that it is try catch block
        primary.type().mustInheritFromType(line(), Throwable.class, context);

        return this;
    }

    @Override
    public void codegen(CLEmitter output) {

    }

    @Override
    public void writeToStdOut(PrettyPrinter p) {
        p.printf("<JThrowExpression>\n");
        p.indentRight();
        primary.writeToStdOut(p);
        p.indentLeft();
        p.printf("</JThrowExpression>\n");
    }
}
