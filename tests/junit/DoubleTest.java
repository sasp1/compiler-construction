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
		this.assertEquals(doubleTest.doubleTest(0.0), 0.0);
		this.assertEquals(doubleTest.doubleTest(15.0), 15.0);
		this.assertEquals(doubleTest.doubleTest(3e2), 3e2);
		this.assertEquals(doubleTest.doubleTest(4d), 4d);
		this.assertEquals(doubleTest.doubleTest(.4), .4);
		this.assertEquals(doubleTest.doubleTest(4d), 4.0);
		
		this.assertEquals(doubleTest.doubleTest(1632.0331e122d), 1632.0331e122d);

		this.assertEquals(doubleTest.doublePlus(4.0, 4.0), 8.0);
		this.assertEquals(doubleTest.doubleSub(4.0, 4.0), 0.0);
		this.assertEquals(doubleTest.doubleMult(4.0, 4.0), 16.0);
		this.assertEquals(doubleTest.doubleDiv(4.0, 4.0), 1.0);
		this.assertEquals(doubleTest.doubleRem(4.0, 4.0), 0.0);
		
		this.assertEquals(doubleTest.doubleMinusAssignment(4.0), 1.0);
		this.assertEquals(doubleTest.doubleAddAssignment(4.0), 7.0);
		this.assertEquals(doubleTest.doubleMultAssignment(4.0), 12.0);
		this.assertEquals(doubleTest.doubleDivAssignment(4.0), 2.0);
		this.assertEquals(doubleTest.doubleModAssignment(4.0), 1.0);
	}
}