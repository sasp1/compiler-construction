package jminusminus;

public class JPostIncrementOp extends JUnaryExpression {
    /**
     * Construct an AST node for a unary expression given its line number, the
     * unary operator, and the operand.
     *
     * @param line     line in which the unary expression occurs in the source file.
     * @param arg
     */
    protected JPostIncrementOp(int line, JExpression arg) {
        super(line, "post++", arg);
    }

    @Override
    public JExpression analyze(Context context) {
        if (!(arg instanceof JLhs)) {
            JAST.compilationUnit.reportSemanticError(line,
                    "Operand to ++expr must have an LValue.");
            type = Type.ANY;
        } 
        
        arg = (JExpression) arg.analyze(context);
        
        if (arg.type().matchesExpected(Type.INT)) {
            arg.type().mustMatchExpected(line(), Type.INT);
            type = Type.INT;
        } else {
            arg.type().mustMatchExpected(line(), Type.DOUBLE);
            type = Type.DOUBLE;
        }
        return this;
    }

    @Override
    public void codegen(CLEmitter output) {

    }
}
