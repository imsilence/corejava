package com.silence.ch06;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class TalkingClock {
    private int interval = 1000;
    private boolean beep = false;

    public TalkingClock(boolean aBeep) {
        this(1000, aBeep);
    }

    public TalkingClock(int aInterval, boolean aBeep) {
        interval = aInterval;
        beep = aBeep;
    }

    public class TimePrinter implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("the time is: " + new Date());
            if(beep) {
                Toolkit.getDefaultToolkit().beep();
            }
        }
    }

    public void start() {
        ActionListener listener = new TimePrinter();
        new Timer(interval, listener).start();  
    }

    public static void main(String[] args) {
        new TalkingClock(true).start();
        JOptionPane.showMessageDialog(null, "退出?");
    }
}