package com.silence.ch10;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class FontTest extends JFrame {
    
    private static final int DEFAULT_WIDTH = 750;
    private static final int DEFAULT_HEIGHT = 300;
    
    private class FontComponent extends JComponent {

        @Override
        protected void paintComponent(Graphics g) {
            String msg = "abcdefghijklmnopqrstuvwxyz";
            Graphics2D g2 = (Graphics2D)g;
            Font font = new Font("SansSerif", Font.BOLD, 35);
            g2.setFont(font);
            
            FontRenderContext cxt = g2.getFontRenderContext();
            
            Rectangle2D bounds = font.getStringBounds(msg, cxt);
            
            double x = (getWidth() - bounds.getWidth()) / 2;
            double y = (getHeight() - bounds.getHeight()) / 2;
            double baseY = y - bounds.getY();
            System.out.println(bounds.getWidth());
            System.out.println(bounds.getHeight());
            System.out.println(bounds.getY());
            
            LineMetrics metrics = font.getLineMetrics(msg, cxt);
            System.out.println(metrics.getDescent());
            System.out.println(metrics.getLeading());
            
            g2.drawString(msg, (int)x, (int)baseY);
            g2.setPaint(Color.LIGHT_GRAY);
            g2.draw(new Line2D.Double(x, baseY, x + bounds.getWidth(), baseY));
            
            g2.draw(new Rectangle2D.Double(x, y, bounds.getWidth(), bounds.getHeight()));
        }
        
    }
    
    public FontTest() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(new FontComponent());
    }
    
    public static void main(String[] args) {
        String[] fontNames = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        for(String fontName : fontNames) {
            System.out.println(fontName);
        }
        EventQueue.invokeLater(() -> {
            new FontTest().setVisible(true);
        });
    }
}
