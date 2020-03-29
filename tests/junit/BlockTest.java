package junit;

import junit.framework.TestCase;
import pass.BlockPass;

public class BlockTest extends TestCase {
	
	private BlockPass blockTest;
	
	protected void setUp() throws Exception {
		super.setUp();
		blockTest = new BlockPass(1);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testBlock() {
		
		this.assertEquals(blockTest.returnNumber(), 2);
	}

}
