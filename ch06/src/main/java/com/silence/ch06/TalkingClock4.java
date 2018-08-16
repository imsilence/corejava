package com.silence.ch06;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class TalkingClock4 {
    private int interval = 1000;
    private boolean beep = false;

    public TalkingClock4(boolean aBeep) {
        this(1000, aBeep);
    }

    public TalkingClock4(int aInterval, boolean aBeep) {
        interval = aInterval;
        beep = aBeep;
    }

    public void start() {
        new Timer(interval, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(getClass().getEnclosingClass().getName() + ", the time is: " + new Date());
                if(beep) {
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        }).start();
    }

    public static void main(String[] args) {
        new TalkingClock4(true).start();
        JOptionPane.showMessageDialog(null, "退出?");
    }
}