package junit;

import junit.framework.TestCase;
import pass.ExceptionHandling;

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
        assertEquals(2, eh.alotOfVariablesTest(0, 3));
    }

    public void testReturningExceptionMsg(){
        String testMessage = "VI faar 12";
        assertEquals(testMessage, eh.returningExceptionMessage(testMessage));
    }

    public void testLocalContext(){
        assertEquals(2, eh.testLocalContext_adds2(0));
    }

    public void testTryCatchFinally(){
        assertEquals("123", eh.simpleTryCatch_returns123(""));
    }

    public void testTryCatchFinallyWithoutException(){
        assertEquals("13", eh.simpleTryCatchFinally_returns13(""));
    }
}
