package game;

import java.awt.Color;
import java.awt.Graphics;

public class BulletObject extends GameObject{
	int prevX;
	int prevY;
	
	public BulletObject(int x, int y, int w, int h) {
		super(x, y, w, h);
		prevX = x;
		prevY = y;
		speed = 10;
	}
	
	public void update(){
		y -= speed;
	
		if(y <= 0){ 
			isAlive = false;
		}
		
		if(isColliding && collisionObject instanceof EnemyObject){
			isAlive = false;
		}
		
		colBox.setBounds(x, y, width, height);
		prevX = x;
		prevY = y;
	}
	
	public void draw(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(x, y, width, height);
		
		//g.setColor(Color.RED);
		//g.drawRect(colBox.x, colBox.y, colBox.width, colBox.height);
	}
	
}
