package junit;

import junit.framework.TestCase;
import pass.PostIncrement;

public class PostIncrementTest extends TestCase {

    private PostIncrement pi;

    protected void setUp() throws Exception {
        pi = new PostIncrement();
        super.setUp();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testPostIncInExpression(){
         int x = pi.postIncInExpressionReturnsX(2);
         assertEquals(2, x);
    }

    public void testPostInc(){
         int x = pi.postIncInt(0);
         assertEquals(1, x);
    }

}
