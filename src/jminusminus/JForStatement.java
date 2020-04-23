package jminusminus;

import java.util.ArrayList;
import java.util.Random;

public class JForStatement extends JStatement {
	
	protected boolean isForEach;
	
	/** Initializing expression */
	protected JVariableDeclaration init;
	
	/** condition in for-statement */
	protected JExpression cond; 
	
	/** update of initialized variable */
	protected JStatement update;
	
	/** content of for statement */
	protected JStatement statement;
	
	//For each
	private JFormalParameter param;
	private JExpression expr;
	
	public JForStatement(int line, JFormalParameter vecl, JExpression expr, JVariableDeclaration init, JExpression cond, JStatement update, 
			JStatement statement) {
		super(line);
		
		this.isForEach = cond == null ? true : false;
		
		this.init = init;
		this.cond = cond;
		this.update = update;
		this.statement = statement;
		
		this.param = vecl;
		this.expr = expr;
		
		
	}
	
	public JStatement analyze(Context context) {
		LocalContext locCon = new LocalContext(context);
		if(isForEach) {
			param.analyze(locCon);
			expr.analyze(locCon);
			
			if (!Type.ITERABLE.isJavaAssignableFrom(expr.type()) && !expr.type().isArray()) {
				JAST.compilationUnit.reportSemanticError(line, "Variable must have have type iterable or array: \"%s\"", expr.type().toString());
			}
			
			param.type().mustMatchExpected(line, expr.type().componentType());
		}
		
		init = (JVariableDeclaration) init.analyze(locCon);
		cond = (JExpression) cond.analyze(locCon);
		cond.type().mustMatchExpected(line, Type.BOOLEAN);
		update = (JStatement) update.analyze(locCon);
		statement = (JStatement) statement.analyze(locCon);
		
		return this;
	}
	
	public void codegen(CLEmitter output) {
		
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
