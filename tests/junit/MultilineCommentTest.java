package junit;
import junit.framework.TestCase;
import pass.MultilineComment;

public class MultilineCommentTest extends TestCase {

    private MultilineComment mc;

    protected void setUp() throws Exception {
        super.setUp();
        mc = new MultilineComment();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testMultiline() {
        assertEquals(mc.multilineComment(10,20,0), 0);
    }
}