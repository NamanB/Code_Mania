package main;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheetLoader {
	// private static Image Entities;
	private static BufferedImage Entities;

	public static final int SPRITE_SIZE = 10;
	public static final int SPRITE_TILE_SIZE = 10;
	public static final int SPRITE_SHEET_SIZE = SPRITE_TILE_SIZE * SPRITE_SIZE;

	public static void load() {
		try {
			Entities = ImageIO.read(new File("./spritesheets/Entities.png"));
		} catch (IOException e1) {
			System.err.println("Failed to load Image");
			e1.printStackTrace();
		}

	}

	public static Image getTexture(int r, int c) { // row column
		return Entities.getSubimage(c * SPRITE_SIZE, r * SPRITE_SIZE, SPRITE_SIZE, SPRITE_SIZE);
	}

}
