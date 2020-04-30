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

    public void testThrow() throws Exception {

        eh.throwMethod();

        assertEquals(2,eh.catchMethod());

    }

//    public void testTryCatch() {
//        try {
//            throwsIO(testMsg);
//        } catch (IOException e) {
//            assertEquals(testMsg, e.getMessage());
//        } catch (IllegalAccessError e){
//            fail();
//        }
//
//        int x = 0;
//
//        try{
//            try {
//                ++x;
//                throwsIO(testMsg);
//            } catch (IllegalAccessError e) {
//                fail();
//            } finally {
//                ++x;
//            }
//        } catch (IOException e){
//            ++x;
//            assertEquals(testMsg, e.getMessage());
//            assertEquals(3, x);
//        }
//
//        x = 0;
//        try{
//            try {
//                ++x;
//                throwsIllegal(testMsg);
//            } catch (IllegalAccessError e) {
//                ++x;
//                throwsIO(testMsg);
//                assertEquals(testMsg, e.getMessage());
//                assertEquals(2, x);
//            } finally {
//                ++x;
//            }
//        } catch (IOException e){
//            ++x;
//            assertEquals(testMsg, e.getMessage());
//            assertEquals(4, x);
//        }
//    }
//
//    public void throwsMethod(String testMsg) throws Exception{
//        throw new Exception(testMsg);
//    }
//
//    public void throwsIO(String testMsg) throws IOException{
//        throw new IOException(testMsg);
//    }
//
//    public void throwsIllegal(String testMsg) throws IllegalAccessError{
//        throw new IllegalAccessError(testMsg);
//    }

}
