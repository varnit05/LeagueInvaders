package game;

import java.awt.Graphics;

public class ObjectManager {
 public Rocketship rocket;

public ObjectManager(Rocketship rocket){
	this.rocket = rocket;
	
}
public void update(){
	rocket.update();
}
public void draw(Graphics g){
	rocket.Draw(g);
	
}
}

