package junit;

import junit.framework.TestCase;
import pass.UnaryPlus;

public class UnaryPlusTest extends TestCase {
	private UnaryPlus unaryPlus;
	
	protected void setUp() throws Exception {
		super.setUp();
		unaryPlus = new UnaryPlus();
	}
	
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testUnaryPlus() {
		int i = 10;
		char ch = 'Z';
		this.assertEquals(unaryPlus.unaryplus(+i), 10);
		this.assertEquals(unaryPlus.unaryplus(+ch), 90);
	}
}
