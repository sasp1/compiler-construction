package pass;

public class ExceptionHandling {
    public void throwMethod() throws Exception, java.lang.NullPointerException {
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
        } catch (Exception e) {
            hej = 2==3;
            return 1;
        }


        return 0;
    }
}
