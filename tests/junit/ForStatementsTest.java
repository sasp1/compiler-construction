package junit;

import junit.framework.TestCase;
import pass.ForStatements;

public class ForStatementsTest extends TestCase {
	private ForStatements forStatement;
	
	protected void setUp() throws Exception {
		super.setUp();
		forStatement = new ForStatements();
	}
	
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testForStatement() {
		this.assertEquals(forStatement.forLoop(0), 10);
		this.assertEquals(forStatement.foreach(0), 10);
	}

}
