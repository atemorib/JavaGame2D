package dev.mate.cinemagame.map;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import dev.mate.cinemagame.Handler;

public class Map {


	
	public static Map[] tiles = new Map[256];
	public static Map floorTile = new FloorTile(0);
	public static Map crackedTile = new CrackedFloor(1);
	public static Map wallTile = new WallTile(2);
	
	

	public static final int TILEWIDTH = 128;
	public static final int TILEHEIGHT = 128;
	
	protected BufferedImage texture;
	protected final int id;
	
	public Map(BufferedImage texture, int id) {
		this.texture = texture;
		this.id = id;
		
		tiles[id] = this;
		
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
		

	}
	
	public boolean walkable() {
		return true;
	}
	
	public int getId() {
		return id;
	}
	
}
