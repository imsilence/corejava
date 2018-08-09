package com.silence.ch04.test01;

public class RunTest {
    public static void main(String[] args) {
        DefaultTest defaultTest = new DefaultTest();

        System.out.println(defaultTest.defaultVar);
        System.out.println(defaultTest.publicVar);


        PublicTest publicTest = new PublicTest();
        System.out.println(publicTest.defaultVar);
        System.out.println(publicTest.publicVar);

    }
}