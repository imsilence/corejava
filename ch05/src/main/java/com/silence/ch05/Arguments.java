package com.silence.ch05;

public class Arguments {

    public static double max(double... args) {
        double largest = Double.NEGATIVE_INFINITY;
        for(double d : args) {
            if(d > largest) {
                largest = d;
            }
        }
        return largest;
    }

    public static void main(String[] args) {
        System.out.println(Arguments.max(1, 2, 3));
        System.out.println(Arguments.max(1, 2, 3, 4));
        System.out.println(Arguments.max(1, 2, 3, 4, 5));
    }
}