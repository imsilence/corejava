package com.silence.ch14;

import java.lang.Thread.State;

public class ThreadState {
    public static void main(String[] args) {
        Runnable r = () -> {
            System.out.println("00." + Thread.currentThread().getState());
            try {
                Thread.sleep(15 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("01." + Thread.currentThread().getState());
        };
        Thread th = new Thread(r);
        

        Thread sth = new Thread(() -> {
            State state = null;
            while(!th.getState().equals(State.TERMINATED)) {
                if(!th.getState().equals(state)) {
                    System.out.println("check:" + th.getState());
                    state = th.getState();
                }
            }
        });
        
        sth.start();
        
        System.out.println("0." + th.getState());
        th.start();
        
        System.out.println("1." + th.getState());
        try {
            th.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            sth.join(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("2." + th.getState());
    }
}