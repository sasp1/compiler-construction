package junit;

import junit.framework.TestCase;
import pass.IOr;

public class IOrTest extends TestCase {
	private IOr iOr;

	protected void setUp() throws Exception {
		super.setUp();
		iOr = new IOr();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testIOr() {
		this.assertEquals(iOr.iOr(10, 8), 10);
		this.assertEquals(iOr.iOr(16, 5), 21);
	}
}