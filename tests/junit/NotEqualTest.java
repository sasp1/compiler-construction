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

	public void testDivide() {
		this.assertEquals(notEqual.notEqual(10, 20), false);
		this.assertEquals(notEqual.notEqual(10, 10), true);
	}
}