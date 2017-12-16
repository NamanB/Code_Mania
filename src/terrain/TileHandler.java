package terrain;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import main.GameWindow;
import player.Player;


public class TileHandler {

	public static final int GRID_SIZE = 50;

	// will be referred to as action border
	// area where all tiles are loaded
	public static final int LOAD_SIZE = 2;// 2

	private static ArrayList<Tile> tiles;

	public TileHandler() {
		tiles = new ArrayList<Tile>();
		
		for (int i = 0; i < GRID_SIZE; i++) {
			for (int j = 0; j < GRID_SIZE; j++) {
				tiles.add(new Tile(i,j));
			}
		}
	}

	@SuppressWarnings("unchecked")
	public void renderAll(GameWindow w, Graphics2D g, Player player) {
		for (int i = 0; i < tiles.size(); i++) {
			tiles.get(i).draw(w, g, player);
		}
	}
}