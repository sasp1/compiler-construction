package junit;

import junit.framework.TestCase;
import pass.Cond;

public class CondTest extends TestCase {
	private Cond cond;

	protected void setUp() throws Exception {
		super.setUp();
		cond = new Cond();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testDivide() {
		this.assertEquals(cond.cond(true, 10, 20), 10);
		this.assertEquals(cond.cond(false, 10, 20), 20);
	}
}