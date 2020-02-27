package junit;

import junit.framework.TestCase;
import pass.NotEqual;

public class NotEqualTest extends TestCase {
	private NotEqual notEqual;

	protected void setUp() throws Exception {
		super.setUp();
		notEqual = new NotEqual();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testNotEqual() {
		assertTrue(notEqual.notEqual(2,3));
//		this.assertEquals(notEqual.divide(10, 20), 0);
//		this.assertEquals(notEqual.divide(10, 10), 1);
	}
}