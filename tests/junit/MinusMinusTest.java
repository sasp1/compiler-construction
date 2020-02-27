package junit;

import junit.framework.TestCase;
import pass.MinusMinus;

public class MinusMinusTest extends TestCase {
    private MinusMinus minusMinus;

    protected void setUp() throws Exception {
        super.setUp();
        minusMinus = new MinusMinus();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testPlusEqual() {
        assertEquals(1, minusMinus.minusMinus(2));
    }
}
