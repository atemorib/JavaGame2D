package dev.mate.cinemagame;


import dev.mate.cinemagame.gfx.Camera;
import dev.mate.cinemagame.input.Keymanager;
import dev.mate.cinemagame.input.Mouse;
import dev.mate.cinemagame.world.World;

public class Handler {

	private Game game;
	private World world;

	public Handler(Game game) {
		this.game = game;
	}
	
	
	
	
	
	public int getWidth() {
		return game.getWidth();
	}
	
	public int getHeight() {
		return game.getHeight();
	}
	
	public Keymanager getKeyManager() {
		return game.getKeyManager();
	}
	
	public Mouse getMouse() {
		return game.getMouse();
	}
	
	public Camera getCamera() {
		return game.getCamera();
	}
	
	
	
	public Game getGame() {
		return game;
	}
	public void setGame(Game game) {
		this.game = game;
	}
	public World getWorld() {
		return world;
	}
	public void setWorld(World world) {
		this.world = world;
	}
	

}
