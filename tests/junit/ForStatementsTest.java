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
//	public void testForEachCollection() {

//		assertEquals(15, forStatement.forLoop(0));
//		int n = forStatement.forEachCollection(0);
//		assertEquals(6, n);
//		assertEquals(0, forStatement.foreach(0));

//	}

	public void testForEachArray(){
		int n = forStatement.forEachArray(0);
		assertEquals(6, n);
	}
}
