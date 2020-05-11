package jminusminus;

import static jminusminus.CLConstants.ASTORE;
import static jminusminus.CLConstants.ATHROW;

public class JThrowStatement extends JStatement {
    private JExpression primary;

    public JThrowStatement(int line, JExpression primary) {
        super(line);
        this.primary = primary;
    }

    @Override
    public JStatement analyze(Context context) {
        primary.analyze(context);
        primary.type().isJavaAssignableFrom(Type.THROWABLE);
        return this;
    }

    @Override
    public void codegen(CLEmitter output) {
        primary.codegen(output);
        output.addNoArgInstruction(ATHROW);
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
