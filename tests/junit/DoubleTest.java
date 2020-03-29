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
	}
}