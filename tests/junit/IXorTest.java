package junit;

import junit.framework.TestCase;
import pass.IXor;

public class IXorTest extends TestCase {
	private IXor iXor;

	protected void setUp() throws Exception {
		super.setUp();
		iXor = new IXor();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testIXor() {
		this.assertEquals(iXor.iXor(15, 10), 5);
		this.assertEquals(iXor.iXor(15, 5), 10);
	}
}