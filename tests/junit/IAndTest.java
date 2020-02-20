package junit;

import junit.framework.TestCase;
import pass.IAnd;

public class IAndTest extends TestCase {
	private IAnd iAnd;

	protected void setUp() throws Exception {
		super.setUp();
		iAnd = new IAnd();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testIAnd() {
		this.assertEquals(iAnd.iAnd(5, 4), 4);
		this.assertEquals(iAnd.iAnd(10, 8), 8);
	}
}