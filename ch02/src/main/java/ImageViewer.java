
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class ImageViewer {
    public static void main(String[] args) {
        ImageViewerFrame frame = new ImageViewerFrame();
        frame.setTitle("ImageViewer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class ImageViewerFrame extends JFrame {

    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 400;

    public ImageViewerFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        JLabel label = new JLabel();
        add(label);

        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("."));
        
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        JMenu menu = new JMenu("File");
        menuBar.add(menu);
        
        JMenuItem open = new JMenuItem("Open");
        menu.add(open);
        
        open.addActionListener(e -> {
        	int result = chooser.showOpenDialog(null);
        	if(result == JFileChooser.APPROVE_OPTION) {
        		String path = chooser.getSelectedFile().getPath();
        		label.setIcon(new ImageIcon(path));
        	}
        });
        
        JMenuItem exit = new JMenuItem("Exit");
        menu.add(exit);
        
        exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
        	
        });;
        
        
    }
}