package pass;

import java.lang.Exception;
import java.lang.System;
import java.lang.Throwable;

public class ExceptionHandling {

    public void throwMethod(String msg) throws Exception{
        throw new Exception(msg);
    }

    int i;
    public ExceptionHandling() {
        i = 2;
    }


    public int catchMethod() {
        i = 0;

        try {
            i = 1;
            i = 3;
            throw new Exception("");
        } catch (Exception e) {
           i = 1;
           i =2;

        }

        return i;
    }

    public int throwsMethod(String msg) throws Exception {
    	if (true) {
    		throw new Exception(msg);
    	}
        return 0;
    }

    public int testLocalContext_adds2(int i){
        try {
            i++;
        } catch (Exception e){

        }

        try {
            i++;
        } catch (Exception e) {

        }
        return i;
    }

    public int alotOfVariablesTest(int i, int m) {
        int k = 3;
        m = k + 4;

        try {
            throw new Exception("");
//            i = -1;
        } catch (Exception e) {
            int l = 4;
            e.getMessage();
            ++i;
        } finally {
            ++i;
        }
        return i;
    }

    public String returningExceptionMessage(String msg){
        try {
            throw new Exception(msg);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String simpleTryCatch_returns123(String msg){
        try {
            msg += "1";
            throw new Exception("hej");
        } catch (Exception e) {
            msg += "2";
        }finally {
            msg += "3";
        }

        return msg;
    }

    public String simpleTryCatchFinally_returns13(String msg){
        try {
            msg += "1";
        } catch (Exception e) {
            msg += "2";
        }finally {
            msg += "3";
        }

        return msg;
    }

}
