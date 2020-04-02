package pass;


import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;

import java.io.IOError;
import java.io.IOException;
import java.awt.BasicStroke;
import java.net.BindException;
import java.lang.Exception;

public class ThrowsDeclaration extends BasicStroke {


    public void throwDeclaration() throws Base64DecodingException, BindException{

        int i = 0;
        i = 2+2;
        try{
            throw new Exception("hej");
            int hej = 0;

        } catch (Exception b) {

        } finally {
            int Hey = 23;
        }

    }
}
