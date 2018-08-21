package com.silence.ch12;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DebugGraphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.RepaintManager;
import javax.swing.border.Border;
import javax.swing.JComponent;

public class InputTest extends JFrame {

    public InputTest() {
        setSize(300, 400);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container pane = getContentPane();
        pane.setLayout(new BorderLayout(10, 2));

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


        JPanel hobbyJpanel = new JPanel();
        hobbyJpanel.setLayout(new FlowLayout());

        hobbyJpanel.add(new JCheckBox("足球"));
        hobbyJpanel.add(new JCheckBox("蓝球"));
        hobbyJpanel.add(new JCheckBox("乒乓球", true));
        hobbyJpanel.add(new JCheckBox("羽毛球"));

        Border hobbyBorder = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "爱好");
        hobbyJpanel.setBorder(hobbyBorder);
        inputJpanel.add(hobbyJpanel);

        JPanel sexJpanel = new JPanel();
        sexJpanel.setLayout(new FlowLayout());

        Border sexBorder = BorderFactory.createTitledBorder("性别");
        sexJpanel.setBorder(sexBorder);
        ButtonGroup sexGroup = new ButtonGroup();
        JRadioButton manRadio = new JRadioButton("男", true);
        sexGroup.add(manRadio);
        JRadioButton wemanRadio = new JRadioButton("女");
        sexGroup.add(wemanRadio);

        sexJpanel.add(manRadio);
        sexJpanel.add(wemanRadio);
        inputJpanel.add(sexJpanel);


        inputJpanel.add(new JLabel("班级:"));
        JComboBox<String> clazz = new JComboBox<String>();
        for(int i = 1; i < 10; ++i) {
            clazz.addItem("" + i);
        }
        inputJpanel.add(clazz);

        inputJpanel.add(new JLabel("年龄:"));
        JSlider age = new JSlider(10, 60, 20);
        age.setMajorTickSpacing(5);
        age.setPaintTicks(true);
        age.setPaintLabels(true);
        inputJpanel.add(age);

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


        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("操作");
        menu.add(new JMenuItem("Open", 'O'));
        menu.add(new JMenuItem("Exit", new ImageIcon("test.png")));
        menuBar.add(menu);


        JMenu menu2 = new JMenu("操作2");
        menu2.add(new JCheckBoxMenuItem("选择"));
        ButtonGroup ijButtonGroup = new ButtonGroup();
        JMenuItem iMenuItem = new JRadioButtonMenuItem("I");
        iMenuItem.setAccelerator(KeyStroke.getKeyStroke("ctrl I"));
        iMenuItem.addActionListener(e -> {
            System.out.println(e.getActionCommand());
        });
        JMenuItem jMenuItem = new JRadioButtonMenuItem("J");
        menu2.add(iMenuItem);
        menu2.add(jMenuItem);
        ijButtonGroup.add(iMenuItem);
        ijButtonGroup.add(jMenuItem);
        jMenuItem.setEnabled(false);
        menuBar.add(menu2);

        setJMenuBar(menuBar);


        JPopupMenu popup = new JPopupMenu();
        popup.add(new JMenuItem("Copy"));
        popup.add(new JMenuItem("Paste"));
        name.setComponentPopupMenu(popup);

        JToolBar toolBar = new JToolBar("Tool Bar");

        RepaintManager.currentManager(getRootPane()).setDoubleBufferingEnabled(false);
        ((JComponent) this.getContentPane()).setDebugGraphicsOptions(DebugGraphics.FLASH_OPTION);
    }


    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new InputTest().setVisible(true);
        });
    }
}
