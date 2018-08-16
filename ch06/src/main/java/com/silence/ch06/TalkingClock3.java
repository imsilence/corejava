package com.silence.ch06;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class TalkingClock3 {
    private int interval = 1000;

    public TalkingClock3() {
        this(1000);
    }

    public TalkingClock3(int aInterval) {
        interval = aInterval;
    }

    public void start(final boolean beep) {
        class TimePrinter implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("the time is: " + new Date());
                if(beep) {
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        }

        ActionListener listener = new TimePrinter();
        new Timer(interval, listener).start();
    }

    public static void main(String[] args) {
        new TalkingClock3().start(true);
        JOptionPane.showMessageDialog(null, "退出?");
    }
}