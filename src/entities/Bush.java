package entities;

import java.awt.Graphics2D;

import entities.Entity;
import main.GameWindow;

public class Bush extends Entity {

	private static final int WIDTH = 40;
	private static final int HEIGHT = 40;

	public Bush(double X, double Y) {
		super(X, Y, new int[]{2}, new int[]{0});
		this.setHeight(WIDTH);
		this.setWidth(HEIGHT);
		this.type = "player";
		this.name = "JOE"; //TODO implement player name input
	}
	
	
	//TODO for multiple textures
//	public void draw(GameWindow w, Graphics2D g, Player player) {
//		g.drawImage(texture[0], (int) (x - player.getX()), (int) (y + player.getY()), width, height, null);
//	}
	
	
}
