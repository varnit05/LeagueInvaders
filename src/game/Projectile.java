package game;

import java.awt.Graphics;

public class Projectile extends GameObject {
	int speed;

	public Projectile(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 5;
		// TODO Auto-generated constructor stub
	}

	void update() {
	     collisionBox.setBounds(x, y, width, height);
	        super.update();
		y-=speed;
		if (y <= 0) {
			isAlive = false;
		} 
	}

	void draw(Graphics g) {
		g.drawImage(GamePanel.bulletImg, x, y, width, height, null);
	}
}
