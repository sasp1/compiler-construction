package jminusminus;

public class JDivAssignOp extends JAssignment {


    /**
     * Construct an AST node for an assignment operation.
     *
     * @param line     line in which the assignment operation occurs in the source
     *                 file.
     * @param lhs      the lhs operand.
     * @param rhs
     */
    public JDivAssignOp(int line, JExpression lhs, JExpression rhs) {
        super(line, "/=", lhs, rhs);
    }

    @Override
    public JExpression analyze(Context context) {
        return null;
    }

    @Override
    public void codegen(CLEmitter output) {

    }
}
