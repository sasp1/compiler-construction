package jminusminus;

import static jminusminus.CLConstants.*;

import java.util.ArrayList;
import java.util.Random;

public class JForEachStatement extends JStatement {
	
	/** variable declaration inside for statement */
	protected JVariableDeclaration init;
	
	/** condition inside for statement */
	protected JExpression cond;
	
	/** initialized variable to be incremented */
	protected JStatement update;
	
	/** content of the loop */
	protected JStatement statement;
	
	private JFormalParameter param;
	private JExpression expr;
	
	public JForEachStatement(int line, JFormalParameter vecl, JExpression expr, JStatement statement) {
		super(line);
		this.param = vecl;
		this.expr = expr;
		this.statement = statement;
		
		//Variables are set
		ArrayList<JVariableDeclarator> params = new ArrayList<>();
		String randIterVar = "i" + (new Random().nextInt(10000));
		JVariable idxVar = new JVariable(line, randIterVar);
		params.add(new JVariableDeclarator(line, idxVar.name(), Type.INT, new JLiteralInt(line, "0")));
		this.init = new JVariableDeclaration(line, null, params);
		
		ArrayList<JVariableDeclarator> blkParams = new ArrayList<>();
		JVariable arrVar = new JVariable(line, param.name());
		blkParams.add(new JVariableDeclarator(line, param.name(), param.type(), new JArrayExpression(line, expr, idxVar)));
		
		if (statement instanceof JBlock == false) {
			ArrayList<JStatement> statements = new ArrayList<>();
			statements.add(statement);
			this.statement = new JBlock(line, statements);
		}
		((JBlock) this.statement).statements().add(0, new JVariableDeclaration(line, null, blkParams));
		
		//condition is set
		this.cond = new JLessThanOp(line, idxVar, new JFieldSelection(line, expr, "length"));
		
		//update is set
		JExpression iterExpr = new JPostIncrementOp(line, idxVar);
		iterExpr.isStatementExpression = true;
		this.update = new JStatementExpression(line, iterExpr);
	}
	
	public JStatement analyze(Context context) {
		
		return this;
	}
	
	public void codegen(CLEmitter output) {

	}
	
	public void writeToStdOut(PrettyPrinter p) {
//		p.printf("<JForEachStatement line = \"%d\">\n", line());
//		p.indentRight();
//		
//		p.printf("<VariableDecl>\n");
//		p.indentRight();
//		param.writeToStdOut(p);
//		p.indentLeft();
//		p.printf("</VariableDecl>\n");
//		
//		p.printf("<Identifier name = \"%s\">\n", expr.toString());
//		p.indentLeft();
//		p.printf("</Identifer>\n");
//		
//		p.printf("<Statement>\n");
//		p.indentRight();
//		statement.writeToStdOut(p);
//		p.indentLeft();
//		p.printf("</Statement>\n");
//		
//		p.indentLeft();
//		p.printf("</JForEachStatement>\n");
		
	}

}
