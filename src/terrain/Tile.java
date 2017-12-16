package terrain;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;

import entities.Entity;
import main.GameWindow;
import main.KeyHandler;
import player.Player;

public class Tile {

	public static final double TILE_SIZE = 200; // 1600

	// public static final double TILE_SIZE = 100;

	private int x, y; // grid location

	private double absX, absY, H;

	public Tile(int x, int y) {
		this.x = x;
		this.y= y;
	}


	public void draw(GameWindow w, Graphics2D g, Player player) {
		// set surface color
		 g.setColor(new Color(40,26,78));
		
		 /*
		 * //TODO put in a loop 
		 * //TODO can this be cleaner? 
		 * 
		 * SUPER LAGGY BUT PUTS
		 * TEXTURE ON GROUND
		 * 
		 * g.translate(w.getCurrentWidth() / 2, w.getCurrentHeight() / 2);
		 * g.rotate(rotation); 
		 * g.translate(this.getAbsX() - player.getX(),this.getAbsY() - player.getY()); 
		 * g.rotate(-rotation); 
		 * g.translate(0,- H + k); 
		 * g.rotate(rotation);
		 * 
		 * g.drawImage(Biome.getBiome(boardX, boardY).getSurfaceTexture(), 0, 0,
		 * 1600, 1600, null); // magic number
		 * 
		 * g.rotate(-rotation); 
		 * g.translate(0, H - k); 
		 * g.rotate(rotation);
		 * g.translate(-this.getAbsX() + player.getX(), -this.getAbsY() +player.getY()); 
		 * g.rotate(-rotation); 
		 * g.translate(-w.getCurrentWidth()/ 2, -w.getCurrentHeight() / 2);
		 * 
		 */

	}
}
