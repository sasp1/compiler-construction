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
		//		assertEquals(15, forStatement.forLoop(0));
		String[] arr = new String[]{"23"};
		assertEquals("1", forStatement.foreach("1", arr));
	}

}
