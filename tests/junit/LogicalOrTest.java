package junit;

import junit.framework.Assert;
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

    public void testLogicalOr() {
        assertTrue(logicalOr.logicalOr(true, true));
        assertFalse(logicalOr.logicalOr(false, false));
        assertTrue(logicalOr.logicalOr(true, false));
        assertTrue(logicalOr.logicalOr(false, true));
    }

    public void testSecondConditionIsNotReached(){
        assertEquals(2,  logicalOr.testOnlyFirstConditionReturns2());
    }
}

