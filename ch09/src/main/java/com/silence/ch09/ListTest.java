package com.silence.ch09;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class ListTest {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("kk");
        arrayList.add("silence");

        System.out.println("=======");
        System.out.println(arrayList.get(0));
        System.out.println("=======");
        for(String s : arrayList) {
            System.out.println(s);
        }

        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        linkedList.add(5);
        linkedList.add(1);

        System.out.println("=======");
        System.out.println(linkedList);

        ListIterator<Integer> listIter = linkedList.listIterator();

        if(listIter.hasNext()) {
            listIter.next();
            listIter.remove();
        }


        listIter.add(2);
        listIter.add(3);


        while(listIter.hasPrevious()) {
            listIter.previous();
        }

        System.out.println("=======");
        listIter.forEachRemaining(e -> System.out.println(e));


        if(listIter.hasPrevious()) {
            listIter.previous();
            listIter.remove();
        }
        while(listIter.hasPrevious()) {
            listIter.previous();
        }
        System.out.println("=======");
        linkedList.forEach(e -> System.out.println(e));
    }
}