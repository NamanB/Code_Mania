package entities;

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

import main.GameWindow;
import player.Player;
import terrain.Tile;
import terrain.TileHandler;

public class EntityHandler {

	private ArrayList<Entity> entities;

	public EntityHandler() {
		entities = new ArrayList<Entity>();
	}

	public void tickAll(Player player) {
		for (Entity e : entities) {
			e.tick(this);
		}
	}

	public static double getAngle(Entity a, Entity b) {

		double dx = a.getX() - b.getX();
		double dy = a.getY() - b.getY();

		double angle = Math.atan(dy / dx);
		if (dx < 0)
			angle += Math.PI;
		return angle;
	}

	public void addEntity(Entity e) {
		entities.add(e);
	}

	public void addEntities(ArrayList<Entity> e) {
		if (e != null) {
			for (Entity a : e) {
				entities.add(a);
			}
		}
	}

	// same as addEntities() but also updates the texture of each one
	// only for when tiles are being reloaded
	public void addEntitiesFromSave(ArrayList<Entity> e) {

	}

	public void renderAll(GameWindow w, Graphics2D g, Player player) {
		for (int i = 0; i < entities.size(); i++) {
			Entity e = entities.get(i);
			if (isOnScreen(w, player, e)) {
				e.draw(w, g, player);
			}
		}
	}

	public boolean isOnScreen(GameWindow w, Player player, Entity e) {

		double dx = Math.abs(player.getX() - e.getX()) - e.getWidth();
		double dy = Math.abs(player.getY() - e.getY()) - e.getWidth();

		return (w.getWidth() / 2.0 > dx) && (w.getHeight() / 2.0 > dy);
	}

	public Entity getNearestEntity(Entity e) {
		Entity closest = null;
		for (int i = 0; i < entities.size(); i++) {
			if (closest == null && entities.get(i) != e) {
				closest = entities.get(i);
			} else if (entities.get(i) != e && dist(e, closest) > dist(e, entities.get(i))) {
				closest = entities.get(i);
			}
		}
		return closest;
	}

	public Entity getNearestEntity(Entity e, String name) {

		Entity closest = null;
		for (int i = 0; i < entities.size(); i++) {
			if (closest == null && entities.get(i) != e && entities.get(i).getName().equals(name)) {
				closest = entities.get(i);
			}
			if (closest != null && entities.get(i) != e && dist(e, closest) > dist(e, entities.get(i))
					&& entities.get(i).getName().equals(name)) {
				closest = entities.get(i);
			}
		}
		return closest;
	}

	private double dist(Entity e1, Entity e2) {
		double dx = (e1.getX() - e2.getX()) * (e1.getX() - e2.getX());
		double dy = (e1.getY() - e2.getY()) * (e1.getY() - e2.getY());
		return Math.sqrt(dx + dy);
	}

	public int getEntityCount() {
		return entities.size();
	}

	public void saveEntities(ArrayList<Entity> entitiesToSave) {
		try {
			FileOutputStream f = new FileOutputStream(new File("myObjects.txt"));
			ObjectOutputStream o = new ObjectOutputStream(f);

			// Write objects to file
			o.writeObject(entitiesToSave);

			o.close();
			f.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	public ArrayList<Entity> loadEntities(Tile t) {

		try {
			FileInputStream fi = new FileInputStream(new File("myObjects.txt"));
			ObjectInputStream oi = new ObjectInputStream(fi);

			ArrayList<Entity> entities = (ArrayList<Entity>) oi.readObject();

			oi.close();
			fi.close();
			return entities;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

}
