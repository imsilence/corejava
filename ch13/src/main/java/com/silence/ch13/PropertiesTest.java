package com.silence.ch13;

import java.io.InputStream;
import java.util.Properties;
import java.io.IOException;

public class PropertiesTest {
    public static void main( String[] args ) throws IOException {

        InputStream stream = Main.class.getResourceAsStream("/prog.properties");
        Properties props = new Properties();
        props.load(stream);
        System.out.println(props.getProperty("name", "main"));
        System.out.println(props.getProperty("user", "kk"));
        System.out.println(props.getProperty("date", "2018-08-20"));

        System.out.println(System.getProperty("user.home"));
    }
}
