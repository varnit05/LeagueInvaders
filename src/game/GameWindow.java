package game;

import java.awt.Dimension;

import javax.swing.JFrame;

public class GameWindow {

	private JFrame window;
	GamePanel panel;

	GameWindow(int w, int h, String t) {
		window = new JFrame(t);
		panel = new GamePanel();
		window.add(panel);
		window.addKeyListener(panel);
		window.addMouseListener(panel);
		window.addMouseMotionListener(panel);
		window.setPreferredSize(new Dimension(w, h));
		window.setResizable(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.pack();
		window.setVisible(true);
	}
}
