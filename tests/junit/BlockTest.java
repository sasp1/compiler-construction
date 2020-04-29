package junit;

import junit.framework.TestCase;
import pass.Block;

public class BlockTest extends TestCase {
	
	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testBlock() {
		assertEquals(8, Block.i);
		Block blockForI = new Block();
		assertEquals(13, blockForI.returnNumber());
		assertNotSame(8, Block.i);
		assertEquals(0, Block.j);
		Block blockForJ = new Block();
		assertEquals(0, Block.j);
		assertEquals(0, blockForJ.returnJ());
		blockForJ.incrementJ();
		assertEquals(1, blockForJ.returnJ());
		assertEquals(1, blockForJ.initializeJBlockInMethod());
		assertEquals(100,blockForJ.blockInMethod());
	}
}
