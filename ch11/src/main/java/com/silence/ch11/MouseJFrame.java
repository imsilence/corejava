package com.silence.ch11;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class MouseJFrame extends JFrame {
    
    private class MouseJComponent extends JComponent {
        
        private static final int SIDELENGTH = 30;
        private ArrayList<Rectangle2D> squares;
        private Rectangle2D current;
        
        public MouseJComponent() {
            squares = new ArrayList<Rectangle2D>();
            current = null;
            
            addMouseListener(new MouseAdapter() {

                @Override
                public void mouseClicked(MouseEvent e) {

                    current = find(e.getPoint());
                    
                    if(current != null && e.getClickCount() >= 2) {
                        remove(current);
                    }
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    current = find(e.getPoint());
                    if(current == null) {
                        add(e.getPoint());
                    }
                }
                
            });
            
            addMouseMotionListener(new MouseMotionListener() {

                @Override
                public void mouseDragged(MouseEvent e) {
                   if(current != null) {
                       current.setFrame(e.getX() - SIDELENGTH / 2, e.getY() - SIDELENGTH / 2, SIDELENGTH, SIDELENGTH);
                       repaint();
                   }
                }

                @Override
                public void mouseMoved(MouseEvent e) {
                    if(find(e.getPoint()) == null) {
                        setCursor(Cursor.getDefaultCursor());
                    } else {
                        setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
                    }
                }
                
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            for(Rectangle2D r : squares) {
                g2.draw(r);
            }
        }
        
        public Rectangle2D find(Point2D p) {
            for(Rectangle2D r : squares) {
                if(r.contains(p)) {
                    return r;
                }
            }
            return null;
        }

        public void add(Point2D p) {
            System.out.println("add");
            squares.add(new Rectangle2D.Double(p.getX() - SIDELENGTH / 2, p.getY() - SIDELENGTH / 2, SIDELENGTH, SIDELENGTH));
            System.out.println(squares.size());
            repaint();
        }
        
        public void remove(Rectangle2D s) {
            if(s == null) {
                return;
            }
            if(s == current) {
                current = null;
            }
            System.out.println("remove");
            System.out.println(squares.size());
            squares.remove(s);
            System.out.println(squares.size());
            repaint();
            
        }

        
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(500, 400);
        }
        
        
    }
    
    public MouseJFrame() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(new MouseJComponent());
        pack();

    }


    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new MouseJFrame().setVisible(true);
        });
    }
}
