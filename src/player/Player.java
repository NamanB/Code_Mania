package player;

import entities.Entity;

public class Player extends Entity {

	private static final int WIDTH = 40;
	private static final int HEIGHT = 40;

	public Player(double X, double Y, int[] x2, int[] y2) {
		super(X, Y, x2, y2);
		this.setHeight(WIDTH);
		this.setWidth(HEIGHT);
		this.type = "player";
		this.name = "JOE"; // TODO implement player name input
	}

}
