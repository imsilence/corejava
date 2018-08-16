package com.silence.ch06;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class TimePrinter implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("the time is: " + new Date());
		Toolkit.getDefaultToolkit().beep();
	}

	public static void main(String[] args) {
		ActionListener printer = new TimePrinter();
		Timer timer = new Timer(10000, printer);
		timer.start();

		new Timer(5000, e -> {
			System.out.println("lambda, the time is: " + new Date());
		}).start();
		JOptionPane.showMessageDialog(null, "退出?");
	}

}
