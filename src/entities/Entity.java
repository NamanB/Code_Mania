package entities;

import java.awt.Image;

import main.SpriteSheetLoader;

public class Entity {
	protected double x, y;
	protected double velX, velY;
	protected transient Image[] texture;
	private int currentTexture;
	protected double width;
	protected int[] textureX, textureY;
	protected int speed;
	
	
	protected boolean canMove;
	protected boolean canAttack;
	protected boolean canDie;
	protected boolean visible;
	protected boolean collides;
	
	
	public Entity(double x, double y, int[] xTexture, int[] yTexture) {
		this.x = x;
		this.y = y;
		textureX = xTexture;
		textureY = yTexture;
		texture = new Image[xTexture.length];
		updateTexture();
	}
	
	public void updateTexture() {
		for (int i = 0; i < textureX.length; i++) {
			texture[i] = SpriteSheetLoader.getTexture(textureX[i], textureY[i]);
		}
	}

}
