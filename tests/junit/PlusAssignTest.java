package junit;
import junit.framework.TestCase;
import pass.PlusAssign;

public class PlusAssignTest extends TestCase {

    private PlusAssign plusAssign;
//
    protected void setUp() throws Exception {
        super.setUp();
        plusAssign = new PlusAssign();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testPlusEqual() {
        assertEquals(plusAssign.plusAssign(5, 10), 15);
    }
}