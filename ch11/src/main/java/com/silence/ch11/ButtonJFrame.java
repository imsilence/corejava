package com.silence.ch11;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ButtonJFrame extends JFrame {
    private JPanel buttonJPanel = null;
    
    private class ColorActionListener implements ActionListener {

        private Color color = null;
        
        public ColorActionListener(Color aColor) {
            color = aColor;
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            buttonJPanel.setBackground(color);
        }
        
    }
    
    public ButtonJFrame() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 200);
        JButton greenJButton = new JButton("Green");
        JButton redJButton = new JButton("red");
        JButton blueJButton = new JButton("blue");
        
        buttonJPanel = new JPanel();
        
        buttonJPanel.add(greenJButton);
        buttonJPanel.add(redJButton);
        buttonJPanel.add(blueJButton);
        
        add(buttonJPanel);
        
        greenJButton.addActionListener(new ColorActionListener(Color.GREEN));
        redJButton.addActionListener(new ColorActionListener(Color.RED));
        blueJButton.addActionListener(new ColorActionListener(Color.BLUE));
        
    }
    
    
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new ButtonJFrame().setVisible(true);
        });
    }
}
