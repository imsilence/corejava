package com.silence.ch09;

import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class HashSetTest {
    public static void main(String[] args) {
        Set<String> words = new HashSet<String>();

        try(Scanner in = new Scanner(System.in)) {
            while(in.hasNext()) {
                String word = in.next();
                if(word.contains("quit")) {
                    break;
                }
                words.add(word);
            }
        }

        Iterator<String> iter = words.iterator();
        System.out.println("word count: " + words.size());
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}