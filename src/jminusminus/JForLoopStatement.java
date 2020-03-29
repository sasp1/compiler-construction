package jminusminus;

import java.util.ArrayList;
import static jminusminus.CLConstants.*;

public class JForLoopStatement extends JStatement {
	
	/** variable declaration inside for statement */
	protected JVariableDeclaration init;
	
	/** condition inside for statement */
	protected JExpression cond;
	
	/** initialized variable to be incremented */
	protected JStatement update;
	
	/** content of the loop */
	protected JStatement statement;

	
	/**
	 * 
	 * @param line 
	 * 			  line number
	 * @param init 
	 * 			  initializing expression
	 * @param cond
	 * 			  condition expression to hold until loop terminates 
	 * @param update
	 * 			  expression to be updated
	 * @param statement 
	 * 			  main content of for statement
	 */
	public JForLoopStatement(int line, JVariableDeclaration init, JExpression cond, JStatement update, JStatement statement) {
		super(line);
		this.init = init;
		this.cond = cond;
		this.update = update;
		this.statement = statement;
	}
	
	/**
	 * Analysis covers the analysis of the test, type checking and analysis of the content of the statement
	 * 
	 * @param context: context in which names are resolved.
	 * 
	 * @return the analyzed (and perhaps rewritten) AST subtree
	 */
	
	public JStatement analyze(Context context) {		
		
		return this;
	}
	
	public void codegen(CLEmitter output) {
			
	}
	
	public void writeToStdOut(PrettyPrinter p) {
		// p.printf("<JForLoopStatement line = \"%d\">\n", line());
		// p.indentRight();
		
		// p.printf("<InitExpression>\n");
		// p.indentRight();
		// init.writeToStdOut(p);
		// p.indentLeft();
		// p.printf("</InitializerExpression>\n");
		
		// p.printf("<ConditionExpression>");
		// p.indentRight();
		// cond.writeToStdOut(p);
		// p.indentLeft();
		// p.printf("</ConditionExpression>\n");
		
		// p.printf("<UpdateExpression>\n");
		// p.indentRight();
		// update.writeToStdOut(p);
		// p.indentLeft();
		// p.printf("</UpdateExpression>\n");
		
		// p.printf("<Statement>\n");
		// p.indentRight();
		// statement.writeToStdOut(p);
		// p.indentLeft();
		// p.printf("</Statement>\n");
		
		// p.printf("</JForLoopStatement>\n");
		
	}

}
