package com.silence.ch09;

import java.util.PriorityQueue;

public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        queue.add(3);
        queue.add(5);
        queue.add(1);

        System.out.println(queue);

        while(!queue.isEmpty()) {
            System.out.println(queue.remove());
        }
    }
}