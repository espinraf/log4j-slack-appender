package se.voipbusiness.log4j;

import org.apache.log4j.Logger;

public class Test {

    static Logger logger = Logger.getLogger(Test.class);

    public String stackTraceToString(Throwable e) {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement element : e.getStackTrace()) {
            sb.append(element.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        Test t = new Test();
        String msg = "Hola Cabron";

        logger.info(msg);

        try {
            float a = 10/0;
        }
        catch (Exception e){
            logger.error(e.getMessage() + " \n" +   t.stackTraceToString(e));
        }

    }
}


