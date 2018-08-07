import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class HelloWorldApplet extends JApplet {
	
	private JTextField input;
	private JLabel label;

	public void init() {
		EventQueue.invokeLater(() -> {
			input = new JTextField("kk");
			label = new JLabel();
			JPanel panel = new JPanel();
			
			panel.setLayout(new GridLayout(1, 3));
			
			panel.add(new JLabel("请输入名字:"));
			panel.add(input);
			
			setLayout(new BorderLayout());
			add(panel, BorderLayout.NORTH);
			add(label, BorderLayout.CENTER);
		});
	}
	
	public void start() {
		new Thread(() -> {
			for(;;) {
				try {
					label.setText("Hi " + input.getText());
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
}
