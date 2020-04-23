package junit;

import junit.framework.TestCase;
import pass.MinusAssign;

public class MinusAssignTest extends TestCase {
    private MinusAssign minusAssign;

    protected void setUp() throws Exception {
        super.setUp();
        minusAssign = new MinusAssign();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testMinusAssign() {
        assertEquals(1, minusAssign.minusAssign(3, 2));
		assertEquals(-10,minusAssign.minusAssign(10, 20));
		assertEquals(0, minusAssign.minusAssign(10, 10));
    }

}

