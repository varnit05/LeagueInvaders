package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener, MouseListener, MouseMotionListener{

	private static final long serialVersionUID = 1L;
	
	Timer timer;
	ObjectManager objManager;
	ShipObject s;
	
	public static BufferedImage rocket;
	public static BufferedImage bullet;
	public static BufferedImage alien;
	public static BufferedImage space;
	
	int menuState = 0;
	int instructionState = 1;
	int gameState = 2;
	int endState = 3;
	int currentState = menuState;
	
	static int score = 0;
	
	Font titleFont;
	Font optionsFont;
	
	public GamePanel(){
		try{
			rocket = ImageIO.read(this.getClass().getResourceAsStream("rocket.png"));
			bullet = ImageIO.read(this.getClass().getResourceAsStream("bullet.png"));
			alien = ImageIO.read(this.getClass().getResourceAsStream("alien.png"));
			space = ImageIO.read(this.getClass().getResourceAsStream("space.png"));
		}catch(Exception e){
			
		}
		
		objManager = new ObjectManager();
		s = new ShipObject(250, 700, 50, 50);
		s.setObjectManager(objManager);
		objManager.addObject(s);
		
		titleFont = new Font("Arial", Font.PLAIN, 48);
		optionsFont = new Font("Arial", Font.PLAIN, 24);
		
		timer = new Timer(1000 / 60, this);
		timer.start();
	}

	public static void updateScore(){
		score++;
	}
	
	public void paintComponent(Graphics g){
		if(currentState == menuState){
			g.setColor(Color.BLUE);
			g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
			g.setFont(titleFont);
			g.setColor(Color.YELLOW);
			g.drawString("LEAGUE INVADERS", 25, 200);
			g.setFont(optionsFont);
			g.drawString("Press ENTER to start", 125, 300);
			g.drawString("Press SPACE for intructions", 90, 400);
		}
		else if(currentState == gameState){
			g.drawImage(space, 0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT, null);
			objManager.draw(g);
		}else if(currentState == endState){
			g.setColor(Color.RED);
			g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
			g.setColor(Color.BLACK);
			g.setFont(titleFont);
			g.drawString("GAME OVER", 100, 100);
			g.setFont(optionsFont);
			g.drawString("You killed " + score + " aliens.", 150, 300);
			g.drawString("Press BACKSPACE to Restart", 90, 500);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(currentState == menuState){
			if(InputManager.space_key){
				JOptionPane.showMessageDialog(null, "Use arrow keys to move. Press SPACE to fire. Try not to die");
				InputManager.space_key = false;
			}else if(InputManager.enter_key){
				currentState = gameState;
			}
		}else if(currentState == gameState){
			objManager.update();
			if(!s.isAlive){
				currentState = endState;
			}
		}else if(currentState == endState){
			
		}
		
		repaint();
	}

	private void resetGame(){
		score = 0;
		objManager.reset();
		s = new ShipObject(250, 700, 50, 50);
		s.setObjectManager(objManager);
		objManager.addObject(s);
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {

	}

	@Override
	public void mouseMoved(MouseEvent e) {

	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_UP) { InputManager.up_key = true; }
		if(key == KeyEvent.VK_DOWN) { InputManager.down_key = true; }
		if(key == KeyEvent.VK_LEFT) { InputManager.left_key = true; }
		if(key == KeyEvent.VK_RIGHT) { InputManager.right_key = true; }
		if(key == KeyEvent.VK_SPACE) { InputManager.space_key = true; }
		if(key == KeyEvent.VK_ENTER) { InputManager.enter_key = true; }
		
		if(key == KeyEvent.VK_ESCAPE) { 
			timer.stop(); 
			System.exit(0);
		}
		
		if(currentState == endState && e.getKeyCode() == KeyEvent.VK_BACK_SPACE){
			resetGame();
			currentState = menuState;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_UP) { InputManager.up_key = false; }
		if(key == KeyEvent.VK_DOWN) { InputManager.down_key = false; }
		if(key == KeyEvent.VK_LEFT) { InputManager.left_key = false; }
		if(key == KeyEvent.VK_RIGHT) { InputManager.right_key = false; }
		if(key == KeyEvent.VK_SPACE) { InputManager.space_key = false; }
		if(key == KeyEvent.VK_ENTER) { InputManager.enter_key = false; }
	}
}
