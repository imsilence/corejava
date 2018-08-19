package com.silence.ch10;

import javax.swing.JFrame;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;


public class Graphics2DTest extends JFrame {

        private static class DrawJComponent extends JComponent {
            
            private static final int DEFAULT_WIDTH = 400;
            private static final int DEFAULT_HEIGHT = 400;

            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                double x = 100D;
                double y = 100D;
                double w = 200D;
                double h = 100D;

                
                Rectangle2D rect = new Rectangle2D.Double(x, y, w, h);
                g2.draw(rect);
                
                Ellipse2D ellipse = new Ellipse2D.Double();
                ellipse.setFrame(rect);
                g2.draw(ellipse);
                
                g2.draw(new Line2D.Double(x, y, x + w, y + h));
                g2.draw(new Line2D.Double(new Point2D.Double(x + w, y), new Point2D.Double(x, y + h)));
                
                Ellipse2D circle = new Ellipse2D.Double();
                double radius = Math.sqrt(Math.pow(rect.getWidth() / 2, 2) + Math.pow(rect.getHeight() / 2, 2));
                double cx = rect.getCenterX();
                double cy = rect.getCenterY();
                circle.setFrameFromCenter(cx, cy, cx + radius, cy + radius);
                g2.draw(circle);
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
            }
            
            

        }

    public Graphics2DTest() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(new DrawJComponent());
        pack();
    }


    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new Graphics2DTest().setVisible(true);
        });
    }
}