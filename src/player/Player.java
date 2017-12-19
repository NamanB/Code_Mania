package player;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.HashMap;

import entities.Entity;
import main.GameWindow;

public class Player extends Entity {

	private static final int WIDTH = 40;
	private static final int HEIGHT = 40;

	public Player(double X, double Y) {
		super(X, Y, new int[] { 0 }, new int[] { 0 });
		this.setHeight(WIDTH);
		this.setWidth(HEIGHT);
		this.speed = .01;
		this.type = "player";
		this.name = "JOE"; // TODO implement player name input

	}
	
	public void runCommand(String name){
		if(name.equals("moveUp")){
			this.changeY(-this.speed);
		}
		if(name.equals("moveDown")){
			this.changeY(this.speed);
		}
		if(name.equals("moveRight")){
			this.changeX(this.speed);
		}
		if(name.equals("moveLeft")){
			this.changeX(-this.speed);
		}
	}
	

	// TODO for multiple textures
	public void draw(GameWindow w, Graphics2D g, Player player) {
		g.drawImage(texture[0], w.getWidth() / 2, w.getHeight() / 2, width, height, null);
	}

}
