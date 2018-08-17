package com.silence.ch07;

import java.util.logging.Level;
import java.util.logging.Logger;

public class AdvanceLoggerTest {
    private static final Logger logger = Logger.getLogger(AdvanceLoggerTest.class.getName());

    public void test() {
        logger.entering(getClass().getName(), "test");
        logger.exiting(getClass().getName(), "test", null);
    }

    public static void main(String[] args) {

        logger.severe("servere");
        logger.warning("warning");
        logger.info("info");
        logger.config("config");
        logger.fine("fine");
        logger.finer("finer");
        logger.finest("finest");

        new AdvanceLoggerTest().test();
    }
}