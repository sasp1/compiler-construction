package jminusminus;

import java.util.function.Function;

import static jminusminus.CLConstants.*;

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
        if (arg instanceof JVariable) {
            // A local variable; otherwise analyze() would
            // have replaced it with an explicit field selection.
            int offset = ((LocalVariableDefn) ((JVariable) arg).iDefn())
                    .offset();
            output.addIINCInstruction(offset, -1);
            if (!isStatementExpression) {
                // Loading its original rvalue
                arg.codegen(output);
            }
        } else {
            ((JLhs) arg).codegenLoadLhsLvalue(output);
            ((JLhs) arg).codegenLoadLhsRvalue(output);
            output.addNoArgInstruction(ICONST_1);
            output.addNoArgInstruction(ISUB);
            if (!isStatementExpression) {
                // Loading its original rvalue
                ((JLhs) arg).codegenDuplicateRvalue(output);
            }
            ((JLhs) arg).codegenStore(output);
        }
    }
}
