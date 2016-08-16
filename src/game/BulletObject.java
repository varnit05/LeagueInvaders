package game;

import java.awt.Color;
import java.awt.Graphics;

public class BulletObject extends GameObject{
	
	public BulletObject(int x, int y, int w, int h) {
		super(x, y, w, h);
		speed = 10;
	}
	
	public void update(){
		super.update();
		y -= speed;
		
		if(y <= 0){ 
			isAlive = false;
		}
	}
	
	public void draw(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(x, y, width, height);
	}
	
}
