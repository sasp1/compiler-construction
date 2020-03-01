package junit;

import junit.framework.TestCase;
import pass.ShiftLeftAssign;

public class ShiftLeftAssignTest extends TestCase {
	private ShiftLeftAssign shiftLeftAssign;

	protected void setUp() throws Exception {
		super.setUp();
		shiftLeftAssign = new ShiftLeftAssign();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testShiftLeft() {
		this.assertEquals(shiftLeftAssign.shiftLeftAssign(33, 5), 1056);
		this.assertEquals(shiftLeftAssign.shiftLeftAssign(632, 2), 2528);
	}
}