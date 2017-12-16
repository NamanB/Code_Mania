package main;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Point;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameWindow extends JPanel {

	/*
	 * Don't Forget Graphics are done in GIMP
	 * 
	 */

	private static final long serialVersionUID = 1L;
	private static final double WIDTH = 800;
	private static final double HEIGHT = 800;
	// public static long SEED = (long) (Math.random() * 10);
	public static long SEED = 5;

	public Point mouse;

	public static double rotation = 0;

	public static int Tab = 0;

	public static KeyHandler keyHandler;

	// TODO
	/*
	 * add width to all entities make tiles render with graphics give rat actual
	 * texture
	 * 
	 */

	public static void main(String[] args) {

		JFrame frame = new JFrame("Grim");
		frame.getContentPane().add(new GameWindow(), BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize((int) WIDTH, (int) HEIGHT);
		frame.setVisible(true);

		keyHandler = new KeyHandler();
		frame.addKeyListener(keyHandler);

		long t = System.currentTimeMillis();
		long dt = 0;
		while (true) {
			dt = System.currentTimeMillis() - t;
			frame.repaint();
			if (dt > 20) {
				// update entities
				t = System.currentTimeMillis();
			}

		}
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		super.paintComponent(g2d);

		g2d.setColor(Color.white);
		g2d.fillRect(0, 0, (int) GameWindow.WIDTH, (int) GameWindow.HEIGHT);

		g2d.setColor(Color.red);

		if (Tab == 0) { // in game

			// only update, do spawn, and render when in game

			// update and render entities

			g2d.drawString(10 + "  " + 10, 10, 10);

			mouse = MouseInfo.getPointerInfo().getLocation();

			if (mouse != null) {
				rotation = mouse.getX() / 100d;
			} else {
				rotation = 0;
			}
			rotation = rotation % (Math.PI * 2);

			if (keyHandler.getKeyPressed(0)) {
				// player.move(rotation);
			}
			//player.inventory.renderHandBar(this, g2d);
		}
		if (keyHandler.getKeyPressed(4)) { // inventory
			Tab = 1;
			// player.inventory.render(this, g2d);
		} else {
			Tab = 0;
		}
	}

	public GameWindow() {

	}

	public double getCurrentWidth() {
		return (double) this.getSize().getWidth();
	}

	public double getCurrentHeight() {
		return (double) this.getSize().getHeight();
	}

}