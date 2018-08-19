package com.silence.ch10;

import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Container;
import java.awt.Dimension;




public class JFrameTest2 extends JFrame {
	
	private static class ComponentTest extends JComponent {
		
	    @Override
	    protected void paintComponent(Graphics g) {
	        g.drawString("Hello World", 50, 50);
	    }

	    @Override
	    public Dimension getPreferredSize() {
	        return new Dimension(200, 100);
	    }
	}
	
    public JFrameTest2() {
        setResizable(false);

        Container contentPane = getContentPane();
        JComponent c = new ComponentTest();
        contentPane.add(c);
    }
    
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
        	JFrameTest2 frame = new JFrameTest2();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            frame.setLocation(100, 100);
            //frame.setLocationByPlatform(true);
            //frame.setUndecorated(true);
            frame.pack();
            frame.setVisible(true);
        });
    }
}