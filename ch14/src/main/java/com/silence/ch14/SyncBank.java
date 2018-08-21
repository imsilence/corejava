package com.silence.ch14;

import java.util.Arrays;

public class SyncBank {

    private final int[] accounts;

    public SyncBank(int n, int balance) {
        
        accounts = new int[n];
        Arrays.fill(accounts, balance);
    }

    public synchronized void transfer(int from, int to, int amount) throws InterruptedException {
        while(accounts[from] < amount) {
            System.out.println(Thread.currentThread() + ", not enough balance, from=" + from + ", to=" + to + ", amount=" + amount);
            wait();
        }
        accounts[from] -= amount;
        Thread.sleep(100);
        accounts[to] += amount;
        System.out.println(Thread.currentThread() + ", Total: " + getTotalBalance() + ", from=" + from + ", to=" + to + ", amount=" + amount);
        notifyAll();
    }

    public synchronized double getTotalBalance() {
        double sum = 0;
        for(double account : accounts) {
            sum += account;
        }
        return sum;
    }

    public int size() {
        return accounts.length;
    }

    public static void main(String[] args) {
        final int N_ACCOUNTS = 10;
        final int INIT_BALANCE = 1000;
        final int MAX_AMOUNT = 1000;
        final int DELAY = 10;
        SyncBank bank = new SyncBank(N_ACCOUNTS, INIT_BALANCE);
        for(int i = 0; i < N_ACCOUNTS; ++i) {
            int from = i;
            new Thread(() -> {
                while(true) {
                    int to = (int)(bank.size() * Math.random());
                    int amount = (int)(MAX_AMOUNT * Math.random());
                    try {
                        bank.transfer(from, to, amount);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                    try {
                        Thread.sleep((int) (DELAY * Math.random()));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }


}
