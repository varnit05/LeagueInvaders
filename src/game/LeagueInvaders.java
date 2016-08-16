package game;

public class LeagueInvaders {
	public static final int WIDTH = 500;
	public static final int HEIGHT = 500;
	
	public static void main(String[] args) {
		new LeagueInvaders().start();
	}
	
	public void start(){
		new GameWindow(WIDTH, HEIGHT, "League Invaders");
	}
}
