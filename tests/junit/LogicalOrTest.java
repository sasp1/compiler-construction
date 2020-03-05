package junit;

import junit.framework.TestCase;
import pass.LogicalOr;

public class LogicalOrTest extends TestCase {
    private LogicalOr logicalOr;

    protected void setUp() throws Exception {
        super.setUp();
        logicalOr = new LogicalOr();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testDivide() {
        assertTrue(logicalOr.logicalOr(true, false));
        assertFalse(logicalOr.logicalOr(false , false));
        assertTrue(logicalOr.logicalOr(false, true));
    }
}
