package game;

import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject {

	void Update() {

	}

	int speed;

	void draw(Graphics g) {
		g.setColor(Color.BLUE);

		g.fillRect(x, y, width, height);

	}

	public Rocketship(int x, int y, int width, int height) {

		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		speed = 20;
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

	public void update() {
		// TODO Auto-generated method stub

	}
}
