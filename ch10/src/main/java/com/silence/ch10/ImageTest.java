package com.silence.ch10;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;


public class ImageTest  extends JFrame {
    
    private class ImageComponent extends JComponent {
        private static final int DEFAULT_WIDTH = 500;
        private static final int DEFAULT_HEIGHT = 300;

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D)g;
            Image img = new ImageIcon("test.png").getImage();
            int width = img.getWidth(this);
            int height = img.getHeight(this);
            
            g2.drawImage(img, 0, 0, null);
            for(int i = 0; i * width <= getWidth(); ++i) {
                for(int j = 0; j * height <= getHeight(); ++j) {
                    g2.copyArea(0, 0, width, height, i * width, j * height);
                }
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        }
        
        
        
    }
    
    public ImageTest() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(new ImageComponent());
        pack();
    }
    
    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
        EventQueue.invokeLater(() -> {
            new ImageTest().setVisible(true);
        });
    }
}