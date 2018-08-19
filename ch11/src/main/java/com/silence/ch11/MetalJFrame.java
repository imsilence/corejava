package com.silence.ch11;

import java.awt.Color;
import java.awt.EventQueue;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MetalJFrame extends JFrame {
    private JPanel buttonJPanel = null;

    private JButton makeButton(String name, String className) {
        JButton jbutton = new JButton(name);
        jbutton.addActionListener(e -> {
            try {
                UIManager.setLookAndFeel(className);
                SwingUtilities.updateComponentTreeUI(this);
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            } catch (InstantiationException e1) {
                e1.printStackTrace();
            } catch (IllegalAccessException e1) {
                e1.printStackTrace();
            } catch (UnsupportedLookAndFeelException e1) {
                e1.printStackTrace();
            }
        });
        return jbutton;
    }

    public MetalJFrame() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 200);

        buttonJPanel = new JPanel();

        UIManager.LookAndFeelInfo[] infos = UIManager.getInstalledLookAndFeels();
        System.out.println(Arrays.toString(infos));
        for(UIManager.LookAndFeelInfo info : infos) {
            buttonJPanel.add(makeButton(info.getName(), info.getClassName()));
        }
        add(buttonJPanel);
    }


    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new MetalJFrame().setVisible(true);
        });
    }
}
