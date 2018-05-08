package game;

import java.awt.Graphics;

public class ObjectManager {
 public static Rocketship rocket;

public ObjectManager(Rocketship rocket){
	rocket = new Rocketship(250, 700, 50, 50);
	
}
public void update(){
	rocket.update();
}
public void draw(Graphics g){
	rocket.Draw(g);
	
}
}

