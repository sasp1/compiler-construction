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

    public void testPlusEqual() {
        assertEquals(1, divisionAssign.divisionAssign(2, 3));
//		this.assertEquals(divisionAssign.divide(10, 20), 0);
//		this.assertEquals(divisionAssign.divide(10, 10), 1);
    }

}
