package entities;

import java.awt.Graphics2D;
import java.awt.Image;

import main.GameWindow;
import main.SpriteSheetLoader;
import player.Player;

public abstract class Entity {
	protected double x, y;
	protected double velX, velY;
	protected transient Image[] texture;
	private int currentTexture;
	protected int width;
	protected int height;
	protected int[] textureX, textureY;
	protected int speed;

	protected String type;
	protected String name;

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
		loadTexture();
	}

	public void loadTexture() {
		for (int i = 0; i < textureX.length; i++) {
			texture[i] = SpriteSheetLoader.getTexture(textureX[i], textureY[i]);
		}
	}

	public void tick(EntityHandler entityHandler) {
		// TODO Auto-generated method stub
	}

	public void draw(GameWindow w, Graphics2D g, Player player) {
		g.drawImage(texture[0], (int) (x - player.getX()), (int) (y + player.getY()), width, height, null);
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getVelX() {
		return velX;
	}

	public void setVelX(double velX) {
		this.velX = velX;
	}

	public double getVelY() {
		return velY;
	}

	public void setVelY(double velY) {
		this.velY = velY;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public Image[] getTexture() {
		return texture;
	}

	public int getCurrentTexture() {
		return currentTexture;
	}

	public int[] getTextureX() {
		return textureX;
	}

	public int[] getTextureY() {
		return textureY;
	}

	public boolean isCanMove() {
		return canMove;
	}

	public boolean isCanAttack() {
		return canAttack;
	}

	public boolean isCanDie() {
		return canDie;
	}

	public boolean isVisible() {
		return visible;
	}

	public boolean isCollides() {
		return collides;
	}

	public String getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
