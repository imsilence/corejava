package com.silence.ch09;


import java.util.HashMap;
import java.util.Scanner;


public class MapTest {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        try(Scanner in = new Scanner(System.in)) {
            while(in.hasNext()) {
                String word = in.next();
                if("quit".contains(word)) {
                    break;
                }
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        map.remove("abc");

        map.forEach((String k, Integer v) -> {
            System.out.println("key=" + k + ", value="  + v);
        });

    }
}