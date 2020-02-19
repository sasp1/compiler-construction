package junit;

import junit.framework.TestCase;
import pass.ShiftLeft;

public class ShiftLeftTest extends TestCase {
	private ShiftLeft shiftLeft;

	protected void setUp() throws Exception {
		super.setUp();
		shiftLeft = new ShiftLeft();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testDivide() {
		this.assertEquals(shifleft.shiftLeft(10, 5), 320);
		this.assertEquals(shifleft.shiftLeft(33, 2), 132);
		this.assertEquals(shifleft.shiftLeft(3, 1), 6);
	}
}