package game;

import java.awt.Graphics;

public class GameObject {
	int x;
	int y;
	int width;
	int height;
   boolean isAlive() {
	return true;
}
	public GameObject(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
	}

	void Update() {

	}

	void Draw(Graphics g) {

	}
}
