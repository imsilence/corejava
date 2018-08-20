package com.silence.ch12;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class InputTest extends JFrame {
    
    public InputTest() {
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        Container pane = getContentPane();
        pane.setLayout(new BorderLayout(3, 2));
        
        JTextField name = new JTextField(20);
        JPasswordField password = new JPasswordField(20);
        password.setEchoChar('#');
        
        JTextArea remark = new JTextArea(5, 20);
        remark.setLineWrap(true);
        JScrollPane remarkPane = new JScrollPane(remark);
        
        JPanel inputJpanel = new JPanel();
        inputJpanel.setLayout(new FlowLayout());
        inputJpanel.add(new JLabel("名字:"));
        inputJpanel.add(name);
        inputJpanel.add(new JLabel("密码:"));
        inputJpanel.add(password);
        inputJpanel.add(new JLabel("备注:"));
        inputJpanel.add(remarkPane);
        
        pane.add(inputJpanel, BorderLayout.CENTER);
        
        JButton submit = new JButton("确认");
        submit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String nameString = name.getText().trim();
                char[] passwordArray = password.getPassword();
                String remarkString = remark.getText().trim();
                System.out.println("名字:" + nameString);
                System.out.println("密码:" + String.valueOf(passwordArray));
                System.out.println("备注:" + remarkString);
            }
            
        });
        pane.add(submit, BorderLayout.SOUTH);
        
    }
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new InputTest().setVisible(true);
        }); 
    }
}
