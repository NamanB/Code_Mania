package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
	private Boolean[] keys;

	public KeyHandler() {
		super();
		keys = new Boolean[4];
		keys[0] = false; // move forward w
		keys[1] = false; // move left a
		keys[2] = false; // move back s
		keys[3] = false; // move right d
	}

	public boolean getKeyPressed(int i) {
		return keys[i];
	}

	@Override
	public void keyPressed(KeyEvent k) {
		if (k.getKeyCode() == KeyEvent.VK_W) {
			keys[0] = true;
		}
		if (k.getKeyCode() == KeyEvent.VK_A) {
			keys[1] = true;
		}
		if (k.getKeyCode() == KeyEvent.VK_S) {
			keys[2] = true;
		}
		if (k.getKeyCode() == KeyEvent.VK_D) {
			keys[3] = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent k) {
		if (k.getKeyCode() == KeyEvent.VK_W) {
			keys[0] = false;
		}
		if (k.getKeyCode() == KeyEvent.VK_A) {
			keys[1] = false;
		}
		if (k.getKeyCode() == KeyEvent.VK_S) {
			keys[2] = false;
		}
		if (k.getKeyCode() == KeyEvent.VK_D) {
			keys[3] = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent k) {

	}

	private class Key { // TODO give key codes and make streamlined
		private String name;
		private Boolean pressed;

		public Key(String name) {
			this.name = name;
			pressed = false;
		}

		public boolean isPressed() {
			return pressed;
		}

		public String getName() {
			return name;
		}

		public void toggle() {
			pressed = !pressed;
		}

		public void keySet(boolean t) {
			pressed = t;
		}

		public void setPressed() {
			pressed = true;
		}

		public void setNotPressed() {
			pressed = false;
		}
	}

}
