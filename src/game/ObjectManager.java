package game;

import java.awt.Graphics;
import java.util.ArrayList;

public class ObjectManager {
	public Rocketship rocket;
	ArrayList<Projectile> projectileList = new ArrayList<Projectile>();

	public ObjectManager(Rocketship rocket) {
		this.rocket = rocket;

	}

	public void update() {
		rocket.update();
		for (Projectile p : projectileList) {
			p.update();
		}

	}

	public void draw(Graphics g) {
		rocket.draw(g);
		for (Projectile p : projectileList) {
			p.draw(g);

		}
	}

	void addProjectile(Projectile e) {
		projectileList.add(e);
	}
}
