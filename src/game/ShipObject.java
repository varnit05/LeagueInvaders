package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class ShipObject extends GameObject {
	private boolean canFire;
	
	ObjectManager objManager;
	
	ShipObject(int x, int y, int w, int h){
		super(x, y, w, h);
		
		speed = 5;
		canFire = true;
		
		colBox = new Rectangle(x - (width / 2), y - (height / 2), width, height);
	}
	
	public void draw(Graphics g){
		
		g.drawImage(GamePanel.rocket, x, y, width, height, null);
	}
	
	public void update(){
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
		
		colBox.setBounds(x - (width / 2), y - (height / 2), width, height);
		
		if(isColliding && collisionObject instanceof EnemyObject){
			isAlive = false;
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
			objManager.addObject(new BulletObject(x + (width / 2), y, 6, 15));
			canFire = false;
		}
		
		if(!InputManager.space_key){
			canFire = true;
		}
	}
}
