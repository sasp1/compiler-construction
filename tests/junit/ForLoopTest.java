package junit;

import junit.framework.*;
import pass.ForLoop;

public class ForLoopTest extends TestCase {
	private ForLoop forLoop;
	
	protected void setUp() throws Exception {
		super.setUp();
		forLoop = new ForLoop();
	}
	
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testForLoop() {
		this.assertEquals(forLoop.forLoop(0), 10);
	}
}
