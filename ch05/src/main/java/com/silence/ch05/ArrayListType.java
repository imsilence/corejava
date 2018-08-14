package com.silence.ch05;


import java.util.ArrayList;

public class ArrayListType {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();

        list.add(new Student("KK", "computer"));
        list.add(new Student("KK1", "computer"));
        list.add(new Student("KK2", "computer"));

        System.out.println(list.get(1));

        list.remove(1);

        for(Student s: list) {
            System.out.println(s);
        }

        ArrayList<Integer> numbers = new ArrayList<>();
        for(int i=0; i < 10; ++i) {
            numbers.add(i);
        }

        for(int n : numbers) {
            System.out.println(n);
        }
    }
}