package junit;

import junit.framework.TestCase;
import pass.ExceptionHandling;

public class ExceptionHandlingTest extends TestCase {

    private ExceptionHandling exceptionHandling;

    protected void setUp() throws Exception {
        exceptionHandling = new ExceptionHandling();

        super.setUp();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testThrow(){
        try {
            exceptionHandling.throwMethod();
            fail();
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

    }

}
