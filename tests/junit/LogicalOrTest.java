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

    public void testLogicalOr() {
    	this.assertEquals(true, logicalOr.logicalOr(true, true));
        this.assertEquals(false, logicalOr.logicalOr(false , false));
        this.assertEquals(true, logicalOr.logicalOr(true, false));
        this.assertEquals(true, logicalOr.logicalOr(false, true));
    }
}

