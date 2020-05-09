package junit;

import junit.framework.TestCase;
import pass.RemAssign;

public class RemAssignTest extends TestCase {
    private RemAssign remAssign;

    protected void setUp() throws Exception {
        super.setUp();
        remAssign = new RemAssign();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testRemAssign() {
        assertEquals(2, remAssign.remAssign(20, 3));
		assertEquals(7, remAssign.remAssign(33, 13));
		assertEquals(0, remAssign.remAssign(10, 10));
    }

}

