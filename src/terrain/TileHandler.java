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

import biomes.Biome;
import biomes.Desert;
import entities.Bush;
import entities.Entity;
import entities.EntityHandler;
import entities.Grass;
import entities.Player;
import entities.Tree;
import main.GameWindow;
import processing.core.PApplet;

public class TileHandler {

	public static final int GRID_SIZE = 50;

	// will be referred to as action border
	// area where all tiles are loaded
	public static final int LOAD_SIZE = 2;// 2

	private static ArrayList<Tile> tiles;

	public TileHandler(double seed) {
		tiles = new ArrayList<Tile>();

		seed = 100;
	}

	@SuppressWarnings("unchecked")
	public void renderAll(GameWindow w, Graphics2D g) {
		Collections.sort(tiles);
		for (int i = 0; i < tiles.size(); i++) {
			tiles.get(i).draw(w, g, rotation, player);
			e.renderEntitiesAt(w, g, tiles.get(i), getPlayerHeight(player), player, rotation);
		}
	}
