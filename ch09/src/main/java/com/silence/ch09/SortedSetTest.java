package com.silence.ch09;


import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetTest {

    public static void main(String[] args) {
        SortedSet<String> set = new TreeSet<String>();

        set.add("kk");
        set.add("silence");
        set.add("null");

        for(String string : set) {
            System.out.println(string);
        }
    }
}