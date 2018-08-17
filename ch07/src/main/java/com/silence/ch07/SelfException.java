package com.silence.ch07;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SelfException extends Exception {

    public SelfException() {}
    public SelfException(String msg) {
        super(msg);
    }

    public void throwException() throws SelfException {
        System.out.println("in");
        FileInputStream in = null;
        SelfException se = null;
        try {
            System.out.println("try");
            in = new FileInputStream(new File("g:/test"));
            System.out.println("try out");
        } catch (FileNotFoundException e) {
            System.out.println("catch");
            se = new SelfException();
            se.initCause(e);
            throw se;
        } finally {
            System.out.println("finally");
            if(in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    if(se == null) {
                        se = new SelfException();
                        se.initCause(e);
                        throw se;
                    }
                }
            }
        }
        System.out.println("out");
    }

    public void tryException() throws SelfException {
        System.out.println("in");
        try(FileInputStream fin = new FileInputStream("g:/test.text")) {
            System.out.println("try");
        } catch (FileNotFoundException e) {
            System.out.println("catch");
            SelfException se = new SelfException();
            se.initCause(e);
            throw se;
        } catch (IOException e) {
            System.out.println("catch");
            SelfException se = new SelfException();
            se.initCause(e);
            throw se;
        } finally {
            System.out.println("finally");
        }
    }

    public static void main(String[] args) {
        Map<Thread, StackTraceElement[]> map = Thread.getAllStackTraces();

        Set<Entry<Thread, StackTraceElement[]>> entrySet = map.entrySet();

        for(Entry<Thread, StackTraceElement[]> entry : entrySet) {
            System.out.println("=================================");
            Thread th = entry.getKey();
            StackTraceElement[] frames = entry.getValue();
            System.out.println(th.getName());
            for(StackTraceElement frame : frames) {
                System.out.println(frame);
            }
        }


        try {
            System.out.println("=================================");
            new SelfException().throwException();
        } catch (SelfException e) {
            System.out.println("=================================");
            e.printStackTrace();

            System.out.println("=================================");
            StackTraceElement[] frames = e.getStackTrace();
            for(StackTraceElement frame : frames) {
                System.out.println(frame);
            }

            Throwable se = e.getCause();
            StringWriter writer = new StringWriter();
            PrintWriter out = new PrintWriter(writer);
            se.printStackTrace(out);

            System.out.println("=================================");
            System.out.println(writer.toString());
        }

        System.out.println("=================================");
        try {
            new SelfException().tryException();
        } catch (SelfException e) {
            System.out.println("=================================");
            e.printStackTrace();
        }
    }
}