package jminusminus;

import static jminusminus.CLConstants.ASTORE;
import static jminusminus.CLConstants.ATHROW;

public class JThrowStatement extends JStatement {
    private JExpression primary;
    private int offset;

    public JThrowStatement(int line, JExpression primary) {
        super(line);
        this.primary = primary;
    }

    @Override
    public JStatement analyze(Context context) {

        offset = ((LocalContext) context).nextOffset();

        Type primaryType = primary.type().resolve(context);

        LocalVariableDefn defn = new LocalVariableDefn(primaryType,
                offset);
        defn.initialize();

        context.addEntry(primary.line(), "hej", defn);
        primary.analyze(context);



//        TODO: Check that exception is handled (either that method throws it or that it is try catch block
        Type.THROWABLE.isJavaAssignableFrom(primary.type());

        return this;
    }

    @Override
    public void codegen(CLEmitter output) {
        primary.codegen(output);
        output.addNoArgInstruction(ATHROW);
        output.addOneArgInstruction(ASTORE, offset);
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
