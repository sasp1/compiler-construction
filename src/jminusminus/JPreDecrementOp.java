package jminusminus;

import java.util.function.Function;

public class JPreDecrementOp extends JUnaryExpression {

    /**
     * Construct an AST node for a unary expression given its line number, the unary
     * operator, and the operand.
     *
     * @param line line in which the unary expression occurs in the source file.
     * @param arg
     */
    protected JPreDecrementOp(int line, JExpression arg) {
        super(line, "--pre", arg);
    }

    @Override
    public JExpression analyze(Context context) {
        if (!(arg instanceof JLhs)) {
            JAST.compilationUnit.reportSemanticError(line,
                    "Operand to ++expr must have an LValue.");
            type = Type.ANY;
        } else {
            arg = (JExpression) arg.analyze(context);
            arg.type().mustMatchExpected(line(), Type.INT);
            type = Type.INT;
        }
        return this;
    }

    @Override
    public void codegen(CLEmitter output) {

    }
}
