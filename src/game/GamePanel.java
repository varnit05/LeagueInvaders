package game;

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
	int currentState = MENU_STATE;

	public void paintComponent(Graphics g) {
		if (currentState==MENU_STATE) {
			drawMenuState(g);
		}
		
		if (currentState==GAME_STATE) {
			drawGameState(g);
		}
		
		if (currentState==END_STATE) {
			drawEndState(g);
		}
		g.fillRect(10, 10, 100, 100);
	}

	Timer timer;

	public GamePanel() {

		timer = new Timer(1000 / 60, this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (currentState==MENU_STATE) {
			updateMenuState();
		}
		
		if (currentState==GAME_STATE) {
			updateGameState();
		}
		
		if (currentState==END_STATE) {
			updateEndState();
		}
		repaint();
	}

	void StartGame() {
		timer.start();

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Fortnite");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.KEY_PRESSED == ENTER) {
			currentState.nextState();
		}
		}
		 
		else if (if(currentState > END_STATE){

                currentState = MENU_STATE;

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
		g.setColor(Color.RED);

		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
	}

	void updateEndState() {
		g.setColor(Color.BLACK);

		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);

		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);   
	}

	void drawGameState(Graphics g) {

	}

	void drawEndState(Graphics g ) {
		
	}
}
