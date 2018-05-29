package game;

import java.awt.Graphics;

public class Rocketship extends GameObject {

	void update() {
		super.update();

	}

	int speed;

	void draw(Graphics g) {
        g.drawImage(GamePanel.rocketImg, x, y, width, height, null);
     
        
        
	}

	public Rocketship(int x, int y, int width, int height) {

		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		speed = 30;

	}

	public void Moveup() {
		y -= speed;
	}

	public void Movedown() {
		y += speed;
	}

	public void Moveleft() {
		x -= speed;
	}

	public void Moveright() {
		x += speed;
	}

}
