package junit;

import junit.framework.TestCase;
import pass.ForStatements;

import java.util.ArrayList;

public class ForStatementsTest extends TestCase {
	private ForStatements forStatement;
	
	protected void setUp() throws Exception {
		super.setUp();
		forStatement = new ForStatements();
	}
	
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	public void testForEachCollection() {
		ArrayList<String> numbers = new ArrayList<>();
		numbers.add("1");
		numbers.add("2");
		numbers.add("3");
		assertEquals("123", forStatement.forEachCollection("", numbers));
	}

	public void testForEachArray(){
		int n = forStatement.forEachArray(0, new int[] {1,2, 3});
		assertEquals(6, n);
	}

	public void testSumArray(){
		int n = forStatement.sumArray(0, new int[] {3, 14, 21});
		assertEquals(n, 3+14+21);
	}

	public void testStringBuilderArray(){
		String str = forStatement.stringBuilderArray("vi", new String[] {" ", "faar", " ", "tolv"} );
		assertEquals(str, "vi faar tolv");
	}
}
