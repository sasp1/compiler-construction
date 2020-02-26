package junit;

import junit.framework.TestCase;
import pass.IUCom;

public class IUComTest extends TestCase {
	private IUCom iUCom;

	protected void setUp() throws Exception {
		super.setUp();
		iUCom = new IUCom();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testIUCom() {
		this.assertEquals(iUCom.iUCom(2), -3);
		this.assertEquals(iUCom.iUCom(10), -11);
	}
}