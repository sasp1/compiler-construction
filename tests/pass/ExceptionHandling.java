package pass;

import java.io.IOException;

public class ExceptionHandling {
    public void throwMethod() throws {
        throw new Exception("hej");
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
