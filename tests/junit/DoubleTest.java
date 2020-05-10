package junit;

import junit.framework.TestCase;
import pass.DoublePass;

public class DoubleTest extends TestCase {
	private DoublePass doubleTest;

	protected void setUp() throws Exception {
		super.setUp();
		doubleTest = new DoublePass();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testDivide() {
		assertEquals(2.0, DoublePass.doubleTest(2.0));
//		assertEquals(DoublePass.doubleTest(15.0), 15.0);
//		assertEquals(DoublePass.doubleTest(3e2), 3e2);
//		assertEquals(DoublePass.doubleTest(4d), 4d);
//		assertEquals(DoublePass.doubleTest(.4), .4);
//		assertEquals(DoublePass.doubleTest(4d), 4.0);
//
//		assertEquals(DoublePass.doubleTest(1632.0331e122d), 1632.0331e122d);

//		assertEquals(DoublePass.doublePlus(4.0, 4.0), 8.0);
//		assertEquals(DoublePass.doubleSub(4.0, 4.0), 0.0);
//		assertEquals(DoublePass.doubleMult(4.0, 4.0), 16.0);
//		assertEquals(DoublePass.doubleDiv(4.0, 4.0), 1.0);
//		assertEquals(DoublePass.doubleRem(4.0, 4.0), 0.0);
//
//		assertEquals(DoublePass.doubleMinusAssignment(4.0), 1.0);
//		assertEquals(DoublePass.doubleAddAssignment(4.0), 7.0);
//		assertEquals(DoublePass.doubleMultAssignment(4.0), 12.0);
//		assertEquals(DoublePass.doubleDivAssignment(4.0), 2.0);
//		assertEquals(DoublePass.doubleModAssignment(4.0), 1.0);
	}
}