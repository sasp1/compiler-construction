package pass;

import java.lang.Exception;
import java.lang.System;

public class ExceptionHandling {

    public static void main(String[] args) {
        ExceptionHandling eh = new ExceptionHandling();
        try {
            int x = 5/0;
        } catch (Exception e){
            System.out.println("caught");
        } finally {
            System.out.println("finally");
        }
    }

    public void throwMethod() throws Exception {
        throw new Exception("hej");
    }

    public int catchMethod() {
        int i = 0;

        try {
            i = i + 1;
        } catch (Exception e) {
            return -1;
        }
        finally {
            i = i + 1;
        }
        return i;
    }
}
