package com.silence.ch11;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ButtonJFrame2 extends JFrame {
    private JPanel buttonJPanel = null;

    private JButton makeButton(String name, Color color) {
        JButton jbutton = new JButton(name);
        jbutton.addActionListener(e -> {
            System.out.println(e.getSource());
            System.out.println(e.getActionCommand());
            buttonJPanel.setBackground(color);
        });
        return jbutton;
    }

    public ButtonJFrame2() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 200);

        buttonJPanel = new JPanel();

        buttonJPanel.add(makeButton("Green", Color.GREEN));
        buttonJPanel.add(makeButton("Red", Color.RED));
        buttonJPanel.add(makeButton("Blue", Color.BLUE));

        add(buttonJPanel);
    }


    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new ButtonJFrame2().setVisible(true);
        });
    }
}
