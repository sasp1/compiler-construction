package junit;

import junit.framework.TestCase;
import pass.ExceptionHandling;

import java.io.IOException;

public class ExceptionHandlingTest extends TestCase {

    String testMsg;

    private ExceptionHandling eh;

    protected void setUp() throws Exception {
        testMsg = "testMessage";
        eh = new ExceptionHandling();
        super.setUp();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testThrow() {
        try {
            eh.throwMethod(testMsg);
            fail();
        } catch (Exception e) {
            assertEquals(testMsg, e.getMessage());
        }
    }

    public void testTryCatch(){
        assertEquals(2, eh.catchMethod());
    }

    public void testThrows(){

        String eMsg = "";
        try {
            eh.throwsMethod("hej");
            fail();
        } catch (Exception e) {
            eMsg = e.getMessage();
        }
        assertEquals("hej", eMsg);
    }

    public void testFinally(){
        assertEquals(2, eh.finallyMethodReturns2(0));
    }
}
