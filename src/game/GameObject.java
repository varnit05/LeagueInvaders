package game;

import java.awt.Graphics;

public class GameObject {
	int x;
	int y;
	int width;
	int height;

	public GameObject(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
	}



void Update( ) {
x =100+x;
y =25+y;
}
void Draw(Graphics g) {
	g.fillRect(x,y,  100, 100);
}
}