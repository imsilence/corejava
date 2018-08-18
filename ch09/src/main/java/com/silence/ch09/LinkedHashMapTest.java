package com.silence.ch09;

import java.util.Map;
import java.util.LinkedHashMap;


public class LinkedHashMapTest {
    public static void main(String[] args) {
        Map<String, Integer> map = new LinkedHashMap<String, Integer>(5, 0.75F, true);

        map.put("kk", 1);
        map.put("silence", 2);

        map.forEach((k, v) -> System.out.println("key=" + k + ", value=" + v));

        map.put("null", 3);
        map.put("kk", 4);

        map.forEach((k, v) -> System.out.println("key=" + k + ", value=" + v));

    }
}