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
	
	protected Rectangle colBox;
	
	public GameObject(int x, int y, int w, int h){
		isAlive = true;
		
		this.x = x;
		this.y = y;
		this.width = w;
		this.height = h;
		
		speed = 0;
		colBox = new Rectangle(x, y, width, height);
	}
	
	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
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
