package junit;

import junit.framework.TestCase;
import pass.PreDecrement;

public class PreDecrementTest extends TestCase {

    private PreDecrement pd;

    protected void setUp() throws Exception {
        pd = new PreDecrement();
        super.setUp();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testPreDecInExpression(){
        int x = pd.preDecInExpressionReturnsX(2);
        assertEquals(1, x);
    }

    public void testPreDec(){
        int x = pd.preDecInt(1);
        assertEquals(0, x);
    }

}
