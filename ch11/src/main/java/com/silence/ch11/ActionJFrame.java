package com.silence.ch11;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class ActionJFrame extends JFrame {
    private JPanel buttonJPanel = null;
    
    private class ColorAction extends AbstractAction {
        
        public ColorAction(String name, Icon icon, Color color) {
            putValue(NAME, name);
            putValue(SMALL_ICON, icon);
            putValue(Action.SHORT_DESCRIPTION, "Set panel color to: " + name.toLowerCase());
            putValue("color", color);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Color color = (Color) getValue("color");
            buttonJPanel.setBackground(color);
        }
        
    }

    public ActionJFrame() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 200);

        buttonJPanel = new JPanel();

        ColorAction green = new ColorAction("Green", new ImageIcon("test.jpg"), Color.GREEN);
        ColorAction red = new ColorAction("Red", new ImageIcon("test.jpg"), Color.RED);
        ColorAction blue = new ColorAction("Blue", new ImageIcon("test.jpg"), Color.BLUE);
        
        buttonJPanel.add(new JButton(green));
        buttonJPanel.add(new JButton(red));
        buttonJPanel.add(new JButton(blue));
        
        InputMap inputMap = buttonJPanel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        inputMap.put(KeyStroke.getKeyStroke("ctrl G"), "panel.green");
        inputMap.put(KeyStroke.getKeyStroke("ctrl R"), "panel.red");
        inputMap.put(KeyStroke.getKeyStroke("ctrl B"), "panel.blue");

        ActionMap actionMap = buttonJPanel.getActionMap();
        
        actionMap.put("panel.green", green);
        actionMap.put("panel.red", red);
        actionMap.put("panel.blue", blue);
        
        add(buttonJPanel);
    }


    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new ActionJFrame().setVisible(true);
        });
    }
}
