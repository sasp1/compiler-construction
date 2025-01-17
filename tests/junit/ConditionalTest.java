package junit;

import junit.framework.TestCase;
import pass.Conditional;

public class ConditionalTest extends TestCase {
	private Conditional conditional;

	protected void setUp() throws Exception {
		super.setUp();
		conditional = new Conditional();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testConditional() {
		assertEquals(10, conditional.conditional(true, 10, 20));
		assertEquals(20, conditional.conditional(false, 10, 20));
	}

	public void testNestedConditional() {
		assertEquals(10, conditional.nestedConditional(true, true,10, 20));
		assertEquals(-1, conditional.nestedConditional(true, false,10, 20));
		assertEquals(20, conditional.nestedConditional(false, true,10, 20));
	}

	public void testNestedExtreme() {
		int returnVal = 2;
		assertEquals(returnVal, conditional.nestedConditionalExtreme(false,true,10,2));
	}

	public void testNestedConditionalString() {
		assertEquals("hey", conditional.nestedConditionalString(true, true,"hey", "ho"));
		assertEquals("ho", conditional.nestedConditionalString(false, true,"hey", "ho"));
		assertEquals("else else", conditional.nestedConditionalString(false, false,"hey", "ho"));
	}

	public void testExampleFromReport(){
		assertEquals(-2, conditional.conditionalExampleFromReport());
	}

	public void testAnother(){
		assertEquals(-1, conditional.anotherTest());
	}

	public void testIfCanReturnMethod(){
		assertEquals(1, conditional.checkIfMethodsCanBeUsed(true));
	}

}