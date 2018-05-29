package game;

import java.awt.Graphics;

public class Alien extends GameObject {

	public Alien(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
 void update(){
     collisionBox.setBounds(x, y, width, height);
     super.update();
	y++;
}
void draw(Graphics g) {
	g.drawImage(GamePanel.alienImg, x, y, width, height, null);
}

}
