package game;

import java.awt.Color;
import java.awt.Graphics;

public class EnemyObject extends GameObject {
	int ctr = 0;
	public EnemyObject(int x, int y, int w, int h) {
		super(x, y, w, h);
	}
	
	public void draw(Graphics g){
		g.setColor(Color.RED);
		g.fillRect(x, y, width, height);
		
		//g.setColor(Color.CYAN);
		//g.drawRect(colBox.x, colBox.y, colBox.width, colBox.height);
	}
	
	public void update(){
		x += (int)(15 * Math.sin(ctr));
		y += (int)(15 * Math.cos(ctr++));
		
		y += 5;
	
		if(isColliding && collisionObject instanceof BulletObject){
			isAlive = false;
		}
		
		colBox.setBounds(x, y, width, height);
	}
}
