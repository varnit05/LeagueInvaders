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

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener, MouseListener, MouseMotionListener{

	private static final long serialVersionUID = 1L;
	
	Timer timer;
	ObjectManager objManager;
	
	int menuState = 0;
	int instructionState = 1;
	int gameState = 2;
	int endState = 3;
	int currentState = menuState;
	
	Font titleFont;
	Font optionsFont;
	
	public GamePanel(){
		objManager = new ObjectManager();
		ShipObject s = new ShipObject(250, 700, 50, 50);
		s.setObjectManager(objManager);
		objManager.addObject(s);
		
		titleFont = new Font("Arial", Font.PLAIN, 48);
		optionsFont = new Font("Arial", Font.PLAIN, 24);
		
		timer = new Timer(1000 / 60, this);
		timer.start();
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
			objManager.draw(g);
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
		}
		if(currentState == gameState){
			objManager.update();
			repaint();
		}
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
