package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	// @Override
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	Font tittleFont;
	int currentState = MENU_STATE;
	Rocketship rs = new Rocketship(250, 700, 70, 70);
	ObjectManager om = new ObjectManager(rs);
	   public static BufferedImage alienImg;

       public static BufferedImage rocketImg;

       public static BufferedImage bulletImg;

       public static BufferedImage spaceImg;

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
        try {

            alienImg = ImageIO.read(this.getClass().getResourceAsStream("alien.png"));

            rocketImg = ImageIO.read(this.getClass().getResourceAsStream("rocket.png"));

            bulletImg = ImageIO.read(this.getClass().getResourceAsStream("bullet.png"));

            spaceImg = ImageIO.read(this.getClass().getResourceAsStream("space.png"));

    } catch (IOException e) {

            // TODO Auto-generated catch block

            e.printStackTrace();

    }
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
				rs = new Rocketship(250,700,70,70);
				
				om = new ObjectManager(rs);
			}
			

		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			om.addProjectile(new Projectile(rs.x+29, rs.y, 10, 10));
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			rs.Moveup();

		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			rs.Movedown();

		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			rs.Moveright();

		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
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
		om.update();
		om.manageEnemies();
		om.checkColission();
		om.purgeObjects();
		if(!rs.isAlive){
			currentState = END_STATE;
			
		}

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
		g.drawImage(GamePanel.spaceImg, 0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT, null);
		om.draw(g);
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);

		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setColor(Color.BLACK);
		g.setFont(tittleFont);
		g.drawString("GAME OVER", 100, 200);
		g.setFont(new Font("Arial", Font.PLAIN, 20));
		g.drawString("You Killed " + om.getScore() + " enemies ", 140, 300);
		g.drawString("Press Enter to restart ", 140, 450);

	}

}
