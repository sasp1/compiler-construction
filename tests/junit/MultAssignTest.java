package junit;

import junit.framework.TestCase;
import pass.MultAssign;

public class MultAssignTest extends TestCase {
    private MultAssign multAssign;

    protected void setUp() throws Exception {
        super.setUp();
        multAssign = new MultAssign();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testMultAssign() {
        assertEquals(6, multAssign.multAssign(2, 3));
        assertEquals(130, multAssign.multAssign(10, 13));
    }
}