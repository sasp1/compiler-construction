package pass;

import java.io.IOException;
import java.lang.Exception;

public class ExceptionHandling {
    public void throwMethod() throws Exception{
        throw new Exception("hej"); // Eneste fejl tilbage <<
    }

    public int catchMethod() {
        String hey;
        hey = new String("hej");

        int heey;
        heey = 3;
        boolean hej;

        try {
            int j = 0;
            int jk = 0;
        } catch (Exception e) {
            hej = 2==3;
            heey = 2;
            return 1;
        }
        finally {
            hej = false;
        }

        return 0;
    }
}
