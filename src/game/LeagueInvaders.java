package game;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class LeagueInvaders extends JPanel implements ActionListener, KeyListener {
	public JFrame frame;
	public static final int WIDTH = 500;
	public static final int HEIGHT = 800;
	GamePanel panel;

	public static void main(String[] args) {

		LeagueInvaders league = new LeagueInvaders();
		league.setup();

	}

	public LeagueInvaders() {
		frame = new JFrame();
		panel = new GamePanel();
		frame.addKeyListener(panel);
	}

	void setup() {

		frame.add(panel);
		frame.setSize(500, 800);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.getContentPane().setPreferredSize(new Dimension(WIDTH, HEIGHT));
		panel.StartGame();
		// frame.addKeyListener(this);

		frame.pack();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
