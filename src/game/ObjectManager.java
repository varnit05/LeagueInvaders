package game;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {

	long enemyTimer;
	int enemySpawnTime = 200;
	public Rocketship rocket;
	ArrayList<Projectile> projectileList = new ArrayList<Projectile>();
	int score = 0;
	int getScore () {
		return score;
		
	}

	ArrayList<Alien> AlienList = new ArrayList<Alien>();

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
			for (Alien a : AlienList) {
				a.draw(g);
			}

		}
	}

	void addProjectile(Projectile e) {
		projectileList.add(e);
	}

	void addAlien(Alien a) {
		AlienList.add(a);

	}

	public void manageEnemies() {
		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
			addAlien(new Alien(new Random().nextInt(LeagueInvaders.WIDTH), 0, 50, 50));

			enemyTimer = System.currentTimeMillis();
		}
	}

	void purgeObjects() {
		ArrayList<Alien> dead = new ArrayList<Alien>();
		for (Alien a : AlienList) {
			if (!a.isAlive) {
				dead.add(a);
			}

		}
		AlienList.removeAll(dead);
	}

	void checkColission() {

		for (Alien a : AlienList) {
			if (rocket.collisionBox.intersects(a.collisionBox)) {

				rocket.isAlive = false;

			}
			for (Projectile e : projectileList) {

				if (a.collisionBox.intersects(e.collisionBox)) {

					a.isAlive = false;
					score++;
				}
			}

		}
	}
}
