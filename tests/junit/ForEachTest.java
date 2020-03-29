package junit;

import junit.framework.*;
import pass.ForEach;

public class ForEachTest extends TestCase {
	private ForEach foreach;
	
	protected void setUp() throws Exception {
		super.setUp();
		foreach = new ForEach();
	}
	
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testForEach() {
		this.assertEquals(foreach.foreach(0), 10);
	}
}
