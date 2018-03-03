package se.voipbusiness.log4j;

import org.apache.log4j.Logger;

public class Test {

    static Logger logger = Logger.getLogger(Test.class);

    public static void main(String[] args) {

        String msg = "Hola Cabron";

        logger.info(msg);

        try {
            float a = 10/0;
        }
        catch (Exception e){
            logger.error(e.toString());
        }

    }
}


