package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	// @Override
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	Font tittleFont;
	int currentState = MENU_STATE;
	Rocketship rs = new Rocketship(250, 700, 50, 50);

	public void paintComponent(Graphics g) {
		if (currentState == MENU_STATE) {
			drawMenuState(g);
		}

		if (currentState == GAME_STATE) {
			drawGameState(g);
		}

		if (currentState == END_STATE) {
			drawEndState(g);
		}

	}

	Timer timer;

	public GamePanel() {

		timer = new Timer(1000 / 60, this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (currentState == MENU_STATE) {
			updateMenuState();
		}

		if (currentState == GAME_STATE) {
			updateGameState();
		}

		if (currentState == END_STATE) {
			updateEndState();
		}
		repaint();
	}

	void StartGame() {
		timer.start();
		tittleFont = new Font("Arial", Font.PLAIN, 48);

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Fortnite");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			currentState++;
			if (currentState > END_STATE) {

				currentState = MENU_STATE;

			}

		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			rs.Moveup();
		
	}
		else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			rs.Movedown();
		
	}
		else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			rs.Moveright();
		
	}
		else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			rs.Moveleft();
		
	}

		System.out.println("With The");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Boyz");
	}


	void updateMenuState() {
	}

	void updateGameState() {
		rs.Update();
		
	}

	void updateEndState() {

	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);

		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setColor(Color.YELLOW);
		g.setFont(tittleFont);
		g.drawString("LEAGUE INVADERS", 35, 200);
		g.setFont(new Font("Arial", Font.PLAIN, 25));
		g.drawString("Press ENTER to start ", 120, 400);
		g.drawString("Press SPACE for instructions ", 75, 700);
	}

	void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);

		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		rs.Draw(g);
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);

		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setColor(Color.BLACK);
		g.setFont(tittleFont);
		g.drawString("GAME OVER", 100, 200);
		g.setFont(new Font("Arial", Font.PLAIN, 20));
		g.drawString("You Killed __ enemies ", 140, 300);
		g.drawString("Press Enter to restart ", 140, 450);

	}

}
