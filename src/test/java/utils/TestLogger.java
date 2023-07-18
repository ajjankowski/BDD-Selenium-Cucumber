package utils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

public class TestLogger {

    private static final java.util.logging.Logger logger = Logger.getLogger(TestLogger.class.getName());

    public static void info(String message) {
        logger.info(message);
    }


    public static void error(String message) {
        String error = "ERROR: " + message;
        logger.severe(error);
    }

    public static void error(String message, Exception e) {
        String error = "ERROR: " + message + exceptionToString(e);
        logger.severe(error);
    }

    private static String exceptionToString(Exception e) {
        StringWriter stringWriter = new StringWriter();
        e.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }
}
