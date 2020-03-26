package jminusminus;

public class JThrowExpression extends JExpression {
    private JExpression primary;

    public JThrowExpression(int line, JExpression primary) {
        super(line);
        this.primary = primary;
    }

    @Override
    public JExpression analyze(Context context) {
        return null;
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
