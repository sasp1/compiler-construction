package junit;

import junit.framework.TestCase;
import pass.ShiftRightUnsign;

public class ShiftRightUnsignTest extends TestCase {
	private ShiftRightUnsign shiftRightUnsign;

	protected void setUp() throws Exception {
		super.setUp();
		shiftRightUnsign = new ShiftRightUnsign();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testShiftLeft() {
		this.assertEquals(shiftRightUnsign.shiftRightUnsign(33, 5), 1);
		this.assertEquals(shiftRightUnsign.shiftRightUnsign(632, 2), 158);
	}
}
