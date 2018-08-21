package com.silence.ch14;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BounceJFrame2 extends JFrame {


private BallComponent comp = null;
    private static final int STEPS = 2000;
    private static final int DELAY = 3;
    private ArrayList<Thread> ths = new ArrayList<Thread>();

    private class Ball {

        private static final int SIZE = 10;

        private double x;
        private double y;
        private double dx = 1;
        private double dy = 1;


        public Shape getShape() {
            return new Ellipse2D.Double(x, y, SIZE, SIZE);
        }

        public void move(Rectangle2D bounds) {
            x += dx;
            y += dy;
            if(x < bounds.getMinX()) {
                x = bounds.getMinX();
                dx = -dx;
            }
            if(x + SIZE >= bounds.getMaxX()) {
                x = bounds.getMaxX() - SIZE;
                dx = -dx;
            }
            if(y < bounds.getMinY()) {
                y = bounds.getMinY();
                dy = -dy;
            }
            if(y + SIZE >= bounds.getMaxY()) {
                y = bounds.getMaxY() - SIZE;
                dy = -dy;
            }
        }
    }

    private class BallComponent extends JPanel {
    private ArrayList<Ball> list = new ArrayList<Ball>();

    public void addBall(Ball ball) {
        list.add(ball);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for(Ball ball : list) {
            g2.fill(ball.getShape());
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(500, 400);
        }
    }

    public BounceJFrame2() {


        comp = new BallComponent();

        Container pane = getContentPane();
        pane.setLayout(new BorderLayout());

        JPanel buttonJpanel = new JPanel();
        buttonJpanel.add(makeButton("start", event -> {
            Ball ball = new Ball();
            comp.addBall(ball);
            Thread th = new Thread(() -> {
                for(int i = 0; i <= STEPS; ++i) {
                    if(Thread.currentThread().isInterrupted()) {
                        break;
                    }
                    ball.move(comp.getBounds());
                    comp.repaint();
                    try {
                        Thread.sleep(DELAY);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        e.printStackTrace();
                    }
                }
            });
            ths.add(th);
            th.start();
        }));

        buttonJpanel.add(makeButton("close", event -> {
            for(Thread th : ths) {
                th.interrupt();
            }
        }));


        pane.add(comp, BorderLayout.CENTER);
        pane.add(buttonJpanel, BorderLayout.SOUTH);
    }

    public JButton makeButton(String name, ActionListener listener) {
        JButton button = new JButton(name);
        button.addActionListener(listener);
        return button;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new BounceJFrame2();
            frame.pack();
            frame.setResizable(false);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}