package game;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener, MouseListener, MouseMotionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Timer timer;
	ObjectManager objManager;
	
	public GamePanel(){
		objManager = new ObjectManager();
		ShipObject s = new ShipObject(250, 400, 50, 50);
		s.setObjectManager(objManager);
		objManager.addObject(s);
		objManager.addObject(new EnemyObject(250, 0, 50, 50));
		
		timer = new Timer(1000 / 60, this);
		timer.start();
	}

	public void paintComponent(Graphics g){
		objManager.draw(g);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		objManager.update();
		repaint();
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
	}
}
