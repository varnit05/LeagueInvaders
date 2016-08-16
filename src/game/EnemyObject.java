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
	}
	
	public void update(){
		super.update();
		x += (int)(5 * Math.sin(ctr));
		y += (int)(5 * Math.cos(ctr++));
		
		y += 5;
	}

}
