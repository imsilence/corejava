package com.silence.ch10;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.Dimension;

public class JFrameTest extends JFrame  {

    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    public JFrameTest() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        setSize(dimension.width / 2, dimension.height / 2);
        setIconImage(new ImageIcon("test.png").getImage());
        //setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setTitle("测试");
        setResizable(false);
    }
    
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
        	JFrameTest frame = new JFrameTest();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            frame.setLocation(100, 100);
            //frame.setLocationByPlatform(true);
            //frame.setUndecorated(true);
            frame.setVisible(true);
        });
    }
}