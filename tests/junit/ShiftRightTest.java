package junit;

import junit.framework.TestCase;
import pass.ShiftRight;

public class ShiftRightTest extends TestCase {
	private ShiftRight shiftRight;

	protected void setUp() throws Exception {
		super.setUp();
		shiftRight = new ShiftRight();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testShiftLeft() {
		this.assertEquals(shiftRight.shiftRight(10, 5), 0);
		this.assertEquals(shiftRight.shiftRight(33, 2), 8);
		this.assertEquals(shiftRight.shiftRight(3, 1), 1);
	}
} 