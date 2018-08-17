package com.silence.ch07;

import java.util.logging.Level;
import java.util.logging.Logger;

public class I18NLoggerTest {
    private static final Logger logger = Logger.getLogger(AdvanceLoggerTest.class.getName(), AdvanceLoggerTest.class.getPackage().getName() + ".messages");

    public static void main(String[] args) {
        logger.severe("name");
        logger.warning("age");
        logger.log(Level.INFO, "desc","I18N");
        logger.log(Level.INFO, "desc", new String[] {"I18N"});
    }
}