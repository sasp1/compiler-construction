package pass;

import java.lang.Exception;
import java.lang.System;
import java.lang.Throwable;

public class ExceptionHandling {

//    public void throwMethod(String msg) throws Exception{
//        throw new Exception(msg);
//    }
//
//    int i;
//    public ExceptionHandling() {
//        i = 2;
//    }
//
//
//    public int catchMethod() {
//        i = 0;
//
//        try {
//            i = 1;
//            i = 3;
//            throw new Exception("");
//        } catch (Exception e) {
//           i = 1;
//           i = 2;
//
//        }
//
//        return i;
//    }
//
////    public int throwsMethod(String msg) throws Exception {
////        throw new Exception(msg);
////        return 0;
////    }
//
//    public void testLocalContext(){
//        try {
//            int i = 3;
//        } catch (Exception e){
//            int i = 3;
//        }
//
//        try {
//            int i = 3;
//        } catch (Exception e ) {
//            int i = 3;
//        }
//    }
//
//    public String usesExceptionMessage_adds1(String str) {
//        try {
//            throw new Exception("1");
//        } catch (Exception e) {
//            str = e.getMessage();
////            str += e.getMessage();
//        }
//
//        return str;
//    }
//
////    public String checksThatEachCatchblockHasOwnLocalContext_adds12(String str) {
////        try {
////            throw new Exception("1");
////        } catch (Exception e) {
////            str += e.getMessage();
////        }
////
////        try {
////            throw new Exception("2");
////        } catch (Exception e) {
////            str += e.getMessage();
////        }
////        return str;
////    }

    public int finallyMethodReturns2(int i) {

        try {
            throw new Exception("");
//            i = -1;
        } catch (Exception e) {
            e.getMessage();
            i = -2;
        } finally {
            i = 2;
        }
        return i;
    }
}
