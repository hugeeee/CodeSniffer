package GUI;

import java.awt.*;
import javax.swing.*;

import GUI.MainScreen;
import Utils.Configurations;

public class SplashScreen extends JWindow {

	private int duration;

	public SplashScreen(int d) {
		duration = d;
		showSplash(); 

	}

	public void showSplash() {

		JPanel content = (JPanel)getContentPane();
		content.setBackground(Color.white);

		// Set the window's bounds, centering the window
		int width = 470;
		int height =353;
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (screen.width-width)/2;
		int y = (screen.height-height)/2;
		setBounds(x,y,width,height);

		// Build the splash screen
		JLabel label = new JLabel();
		label.setIcon(new ImageIcon(getClass().getResource("/GUI/elephant.jpg")));
		JLabel copyrt = new JLabel
		("Code Sniffer Pro - Special Edition: Version 1.0", JLabel.CENTER);
		copyrt.setFont(new Font("Sans-Serif", Font.BOLD, 18));
		content.add(label, BorderLayout.CENTER);
		content.add(copyrt, BorderLayout.SOUTH);
		// Display it
		setVisible(true);
		// Wait a little while, maybe while loading resources
		try { Thread.sleep(duration); } catch (Exception e) {}
		setVisible(false);

	}

	public static void main(String[] args) {
		new SplashScreen(3000);
		new Configurations();
		new MainScreen();
	}
}
