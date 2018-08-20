package com.silence.ch12;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FlowLayoutTest extends JFrame {
    
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;
    
    public FlowLayoutTest() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
 
        
        Container pane = getContentPane();
        pane.setLayout(new FlowLayout());
        for(int i = 0; i < 10; ++i) {
            pane.add(new JButton("" + i));
        }
    }
    
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new FlowLayoutTest().setVisible(true);
        });
    }
}