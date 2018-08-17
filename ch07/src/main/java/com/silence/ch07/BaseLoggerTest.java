package com.silence.ch07;

import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseLoggerTest {
    public static void main(String[] args) {
        Logger.getGlobal().info("Logger");
        Logger.getGlobal().setLevel(Level.OFF);
        Logger.getGlobal().info("Logger");
    }
}