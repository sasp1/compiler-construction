package junit;

import junit.framework.TestCase;
import pass.DivisionAssign;

public class DivisionAssignTest extends TestCase {
    private DivisionAssign divisionAssign;

    protected void setUp() throws Exception {
        super.setUp();
        divisionAssign = new DivisionAssign();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testDivisionAssign() {
        assertEquals(4, divisionAssign.divisionAssign(16, 4));
		assertEquals(3, divisionAssign.divisionAssign(33, 11));
		assertEquals(6,divisionAssign.divisionAssign(60, 10));
    }

}

