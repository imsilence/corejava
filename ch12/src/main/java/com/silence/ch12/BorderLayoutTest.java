package com.silence.ch12;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BorderLayoutTest extends JFrame {
    
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;
    
    public BorderLayoutTest() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
 
        
        Container pane = getContentPane();
        pane.setLayout(new BorderLayout());
        pane.add(new JButton("中"), BorderLayout.CENTER);
        pane.add(new JButton("左"), BorderLayout.WEST);
        pane.add(new JButton("右"), BorderLayout.EAST);
        pane.add(new JButton("上"), BorderLayout.NORTH);
        JPanel southJpanel = new JPanel();
        pane.add(southJpanel, BorderLayout.SOUTH);
        southJpanel.add(new JButton("下"));
    }
    
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new BorderLayoutTest().setVisible(true);
        });
    }
}