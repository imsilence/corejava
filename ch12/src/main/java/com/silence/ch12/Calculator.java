package com.silence.ch12;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Calculator extends JFrame {
    
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;
    
    private JLabel display = null;
    private boolean start = true;
    private double result = 0;
    private String lastCommand = "=";
    
    
    public Calculator() {
        
        display = new JLabel("0");
        display.setEnabled(false);
        
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        
        Container pane = getContentPane();
        
        pane.setLayout(new BorderLayout());
        
        pane.add(display, BorderLayout.NORTH);
        
        
        JPanel inputJpanel = new JPanel();

        pane.add(inputJpanel, BorderLayout.CENTER);
        
        inputJpanel.setLayout(new GridLayout(4, 4));
        
        ActionListener numberInput = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String input = e.getActionCommand();
                String text = display.getText();
                if(start) {
                    text = "";
                    start = false;
                }
                
                display.setText(text + input);
            }
        };
        ActionListener controlInput = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String input = e.getActionCommand();
                if(start) {
                    if(input.equals("-")) {
                        display.setText(input);
                        start = false;
                    } else {
                        lastCommand = input;
                    }
                } else {
                    double number = Double.parseDouble(display.getText());
                    switch(lastCommand) {
                        case "+":
                            result += number;
                            break;
                        case "-":
                            result -= number;
                            break;
                        case "*":
                            result *= number;
                            break;
                        case "/":
                            result /= number;
                            break;
                        case "=":
                            result = number;
                            break;
                    }
                    display.setText("" + result);
                    start = true;
                    lastCommand = input;
                }
            }
        };

        inputJpanel.add(makeButton("7", numberInput));
        inputJpanel.add(makeButton("8", numberInput));
        inputJpanel.add(makeButton("9", numberInput));
        
        inputJpanel.add(makeButton("+", controlInput));
        
        inputJpanel.add(makeButton("4", numberInput));
        inputJpanel.add(makeButton("5", numberInput));
        inputJpanel.add(makeButton("6", numberInput));

        inputJpanel.add(makeButton("-", controlInput));
        
        inputJpanel.add(makeButton("1", numberInput));
        inputJpanel.add(makeButton("2", numberInput));
        inputJpanel.add(makeButton("3", numberInput));
        
        inputJpanel.add(makeButton("*", controlInput));
        
        inputJpanel.add(makeButton("0", numberInput));
        inputJpanel.add(makeButton(".", numberInput));

        inputJpanel.add(makeButton("=", controlInput));
        inputJpanel.add(makeButton("/", controlInput));
        
    }
    
    
    
    private JButton makeButton(String command, ActionListener listener) {
        JButton jbutton = new JButton(command);
        jbutton.addActionListener(listener);
        return jbutton;
    }



    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new Calculator().setVisible(true);
        });
    }
}
