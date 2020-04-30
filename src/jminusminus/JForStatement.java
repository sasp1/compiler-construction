package jminusminus;

import java.util.ArrayList;
import java.util.Random;

import static jminusminus.CLConstants.*;

public class JForStatement extends JStatement {

//	protected boolean isForEach;

	/** Initializing expression */
//	protected JVariableDeclaration init;
//
//	/** condition in for-statement */
//	protected JExpression cond;
//
//	/** update of initialized variable */
//	protected JStatement update;
//
//	/** content of for statement */
	protected JStatement statement;
//
//	//For each
	private JFormalParameter param;
	private JExpression expr;

	public JForStatement(int line, JStatement statement) {
		super(line);
		this.statement = statement;
	}
	
	public JStatement analyze(Context context) {
//		statement.analyze(context);
//		if(isForEach) {
//			param.analyze(context);
//			expr.analyze(context);
//			statement.analyze(context);
//
//			if (!Type.ITERABLE.isJavaAssignableFrom(expr.type()) && !expr.type().isArray()) {
//				JAST.compilationUnit.reportSemanticError(line, "Variable must have have type iterable or array: \"%s\"", expr.type().toString());
//			}
//
//			param.type().mustMatchExpected(line, expr.type().componentType());
//

		
		return this;
	}
	
	public void codegen(CLEmitter output) {
//
//			output.addLabel(topLabel);
//
//			init.codegen(output);
//			expr.codegen(output, endLabel, false);
//			statement.codegen(output);
//
//			output.addBranchInstruction(GOTO, topLabel);
//
//			output.addLabel(endLabel);
//
////			TODO: I would assume it is something like this, but it keeps loading from the array and goes out of bounds:
////			 "foreach signature: (I)I) Expecting to find integer on stack". Need to find out how to stop it when the
////			 empty
	}
	
	public void writeToStdOut(PrettyPrinter p) {
//		p.printf("<JForStatement line = \"%d\">\n", line());
//		p.indentRight();
//
//		if (inits != null) {
//			p.printf("<InitExpression>\n");
//			p.indentRight();
//			for (JStatement i : inits) {
//				i.writeToStdOut(p);
//			}
//			p.indentLeft();
//			p.printf("</InitExpression>\n");
//		}
//
//		if (cond != null) {
//			p.printf("<ConditionExpression>\n");
//			p.indentRight();
//			cond.writeToStdOut(p);
//			p.indentLeft();
//			p.printf("</ConditionExpression>\n");
//		}
//
//		if (updates != null) {
//			p.printf("<UpdateExpression>\n");
//			p.indentRight();
//			for (JStatement u : updates) {
//				u.writeToStdOut(p);
//			}
//			p.indentLeft();
//			p.printf("</UpdateExpression>\n");
//		}
//
//		p.printf("<Statement>\n");
//		p.indentRight();
//		statement.writeToStdOut(p);
//		p.indentLeft();
//		p.printf("</Statement>\n");
//
//		p.indentLeft();
//		p.printf("</JForStatement>\n");
	}
}



