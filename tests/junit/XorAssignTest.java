package junit;

import junit.framework.TestCase;
import pass.XorAssign;

public class XorAssignTest extends TestCase {
	private XorAssign xorAssign;

	protected void setUp() throws Exception {
		super.setUp();
		xorAssign = new XorAssign();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testShiftLeft() {
		this.assertEquals(xorAssign.xorAssign(45, 33), 12);
		this.assertEquals(xorAssign.xorAssign(66, 6), 68);
	}
} 