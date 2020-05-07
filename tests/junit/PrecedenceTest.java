package junit;

import junit.framework.TestCase;
import pass.Precedence;

public class PrecedenceTest extends TestCase {

    private Precedence pc;

    protected void setUp() throws Exception {
        pc = new Precedence();
        super.setUp();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testPrecedence(){
        assertTrue(pc.withLANDAndLORPrecedence());
    }
}
