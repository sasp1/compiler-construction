package junit;


import junit.framework.TestCase;
import pass.PlusPlus;

public class PlusPlusTest extends TestCase {
    private PlusPlus plusPlus;

    protected void setUp() throws Exception {
        super.setUp();
        plusPlus = new PlusPlus();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testPlusEqual() {
        assertEquals(3, plusPlus.plusEqual(2));
//		this.assertEquals(plusPlus.divide(10, 20), 0);
//		this.assertEquals(plusPlus.divide(10, 10), 1);
    }

}
