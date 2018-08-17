package com.silence.ch07;

public class AssertTest {
    public void test(int count) {
        assert count > 0: count;
    }

    public static void main(String[] args) {
        new AssertTest().test(0);
    }

}