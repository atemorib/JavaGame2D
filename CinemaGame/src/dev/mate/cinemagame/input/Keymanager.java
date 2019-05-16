package dev.mate.cinemagame.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keymanager implements KeyListener {
	
	private boolean[] keys;
	public boolean up, down, left, right;
	public boolean interactUp, interactDown, interactLeft, interactRight;
	
	
	public Keymanager() {
		keys = new boolean[256];
	}
	
	public void tick() {
		up = keys[KeyEvent.VK_W];
		right = keys[KeyEvent.VK_D]; 
		down = keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_A]; 
		
		interactUp = keys[KeyEvent.VK_UP];
		interactRight = keys[KeyEvent.VK_RIGHT]; 
		interactDown = keys[KeyEvent.VK_DOWN];
		interactLeft = keys[KeyEvent.VK_LEFT]; 
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}
