package terrain;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;

import entities.Entity;
import main.GameWindow;
import player.Player;

public class Tile {

	public static final int TILE_SIZE = 100; // 1600

	// public static final double TILE_SIZE = 100;
	
	private int x, y; // grid location
	
	public Tile(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void draw(GameWindow w, Graphics2D g, Player player) {
		// set surface color
		 g.setColor(new Color(40,26,78));
		
//		 g.drawImage(Biome.getBiome(boardX, boardY).getSurfaceTexture(), 0, 0,
//		 1600, 1600, null); // magic number
		 g.fillRect(x*TILE_SIZE, y*TILE_SIZE, TILE_SIZE, TILE_SIZE);
	}
}
