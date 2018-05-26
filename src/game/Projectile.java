package game;

import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends GameObject {
	int speed;

	public Projectile(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 10;
		// TODO Auto-generated constructor stub
	}

	void update() {
	     collisionBox.setBounds(x, y, width, height);
	        super.update();
		y--;
		if (y == 0) {
			isAlive = false;
		}
	}

	void draw(Graphics g) {
		g.setColor(Color.red);

		g.fillRect(x, y, width, height);
	}
}
