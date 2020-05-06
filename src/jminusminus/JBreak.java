package jminusminus;

public class JBreak extends JExpression {

    /**
     * Construct an AST node for an expression given its line number.
     *
     * @param line line in which the expression occurs in the source file.
     */
    protected JBreak(int line) {
        super(line);
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

    }
}
