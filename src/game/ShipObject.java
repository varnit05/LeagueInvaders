package game;

import java.awt.Color;
import java.awt.Graphics;

public class ShipObject extends GameObject {
	private boolean canFire;
	
	ObjectManager objManager;
	
	ShipObject(int x, int y, int w, int h){
		super(x, y, w, h);
		
		speed = 5;
		canFire = true;
	}
	
	public void draw(Graphics g){
		int[] xp = {x - (width / 2), x, x + (width / 2)};
		int[] yp = {y + (height / 2), y - (height / 2), y + (height / 2)};
		
		g.setColor(Color.BLUE);
		g.fillPolygon(xp, yp, 3);
		
		g.setColor(Color.CYAN);
		g.drawRect(colBox.x, colBox.y, colBox.width, colBox.height);
	}
	
	public void update(){
		super.update();
		handleInput();
		
		if(x <= 0) { 
			x = 0; 
		}
		else if(x >= LeagueInvaders.WIDTH){
			x = LeagueInvaders.WIDTH;
		}
		
		if(y <= 0){
			y = 0;
		}
		else if(y >= LeagueInvaders.HEIGHT){
			y = LeagueInvaders.HEIGHT;
		}	
	}
	
	public void setObjectManager(ObjectManager o){
		objManager = o;
	}
	
	private void handleInput(){
		if(InputManager.up_key){ y -= speed; }
		if(InputManager.down_key){ y += speed; }
		if(InputManager.left_key){ x -= speed; }
		if(InputManager.right_key){ x += speed; }
				
		if(InputManager.space_key && canFire){
			objManager.addObject(new BulletObject(x, y, 5, 15));
			canFire = false;
		}
		
		if(!InputManager.space_key){
			canFire = true;
		}
	}
}