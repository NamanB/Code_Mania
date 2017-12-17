package player;

import entities.Entity;

public class Player extends Entity {
	
	private static final int WIDTH = 40;
	private static final int HEIGHT = 40;

	public Player(double X, double Y, int[] x2, int[] y2) {
		super(X, Y, x2, y2);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setDims() {
		this.setHeight(WIDTH);
		this.setWidth(HEIGHT);

	}

}
