package game;

import java.awt.Graphics;
import java.awt.Rectangle;

public class GameObject {
	protected boolean isAlive;
	
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	protected int speed;
	protected boolean isColliding;
	
	protected Rectangle colBox; 
	
	protected GameObject collisionObject;

	public GameObject(int x, int y, int w, int h){
		isAlive = true;
		isColliding = false;
		
		this.x = x;
		this.y = y;
		this.width = w;
		this.height = h;
		
		speed = 0;

		colBox = new Rectangle(x, y, width, height);
	}
	
	public GameObject getCollisionObject() {
		return collisionObject;
	}

	public void setCollisionObject(GameObject collisionObject) {
		this.collisionObject = collisionObject;
	}
	
	public boolean isColliding() {
		return isColliding;
	}

	public void setColliding(boolean isColliding) {
		this.isColliding = isColliding;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public Rectangle getColBox() {
		return colBox;
	}

	public void setColBox(Rectangle colBox) {
		this.colBox = colBox;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void draw(Graphics g){
		g.fillRect(x, y, width, height);
	}
	
	public void update(){
		colBox.setBounds(x, y, width, height);
	}
}
