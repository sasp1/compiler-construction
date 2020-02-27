package junit;

import junit.framework.TestCase;
import pass.ShiftRightAssign;

public class ShiftRightAssignTest extends TestCase {
	private ShiftRightAssign shiftRightAssign;

	protected void setUp() throws Exception {
		super.setUp();
		shiftRightAssign = new ShiftRightAssign();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testShiftLeft() {
		this.assertEquals(shiftRightAssign.shiftRightAssign(33, 2), 8);
		this.assertEquals(shiftRightAssign.shiftRightAssign(123, 6), 1);
	}
}