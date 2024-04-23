package utils;

import java.util.logging.Logger;

public class TestLogger {

    public static final java.util.logging.Logger log = Logger.getLogger(TestLogger.class.getName());

    public static void info(String message) {
        log.info(message);
    }

    public static void error(String message) {
        String error = "ERROR: " + message;
        log.severe(error);
    }
}
