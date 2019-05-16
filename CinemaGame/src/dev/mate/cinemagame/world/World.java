package dev.mate.cinemagame.world;

import java.awt.Graphics;

import dev.mate.cinemagame.Handler;
import dev.mate.cinemagame.entities.CanvasShop;
import dev.mate.cinemagame.entities.CinemaBuilding;
import dev.mate.cinemagame.entities.EntityManager;
import dev.mate.cinemagame.entities.OthersShop;
import dev.mate.cinemagame.entities.ProjectorShop;
import dev.mate.cinemagame.entities.SeatShop;
import dev.mate.cinemagame.entities.SpaceShop;
import dev.mate.cinemagame.entities.creatures.Player;
import dev.mate.cinemagame.gfx.Assets;
import dev.mate.cinemagame.map.Map;
import dev.mate.cinemagame.states.State;
import dev.mate.cinemagame.ui.ClickListener;
import dev.mate.cinemagame.ui.UIImageButton;
import dev.mate.cinemagame.ui.UIManager;
import dev.mate.cinemagame.utils.Utils;

public class World {

	private int width, height;		
	private  int spawnX;
	private int spawnY;
	private int [][] pieces;
	private Handler handler;
	
	
	private EntityManager entityManager;
	
	
	private UIManager uiManager;

	public World(Handler handler, String path) {
		this.handler = handler;
		entityManager = new EntityManager(handler, new Player(handler, 300, 200));
		
		entityManager.addEntity(new SeatShop(handler, 200, 100));
		entityManager.addEntity(new CanvasShop(handler, 200+128+256, 100));
		entityManager.addEntity(new ProjectorShop(handler, 200+2*128+2*256, 100));
		entityManager.addEntity(new OthersShop(handler, 200, 700));
		entityManager.addEntity(new SpaceShop(handler, 200+50+384, 700));
		entityManager.addEntity(new CinemaBuilding(handler, 200+2*50+2*384, 700));
		

		
		loadWorld(path);
		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);
		
		
		
		
	}
	
	public void tick() {
		entityManager.tick();
	}
	
	public void render(Graphics g) {
		int xStart = (int)Math.max(0, handler.getCamera().getxOffset() / Map.TILEWIDTH);		//a l�that� grafika bal sz�le |	nem akarok negat�v �rt�ket kapni, ez�rt haszn�lom a Math.max-ot
		int xEnd = (int)Math.min(width, (handler.getCamera().getxOffset() +handler.getWidth()) / Map.TILEWIDTH + 1);		//a l�that� grafika jobb sz�le			
		int yStart = (int)Math.max(0, handler.getCamera().getyOffset() / Map.TILEHEIGHT);		//a l�that� grafika teteje
		int yEnd = (int)Math.min(height, (handler.getCamera().getyOffset() +handler.getHeight()) / Map.TILEHEIGHT + 1 );		//a l�that� grafika alja
		
		for(int y = yStart; y < yEnd ; y++) {
			for(int x = xStart; x < xEnd; x++) {
				getMap(x,y).render(g,(int) (x*Map.TILEWIDTH - handler.getCamera().getxOffset()),(int) (y*Map.TILEHEIGHT - handler.getCamera().getyOffset()));
			}
		}
		
	
		entityManager.render(g);
		
	}
	
	public Map getMap(int x, int y) {
		
									
		
		Map t = Map.tiles[pieces[x][y]];
		if(t == null) {
			return Map.floorTile;		
		}
		return t;
	}
	
	private void loadWorld(String path) {
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		
		pieces = new int[width][height];
		for(int y = 0; y < height ; y++) {
			for(int x = 0; x < width; x++) {
				pieces[x][y] = Utils.parseInt(tokens[(x+y*width)+4]); 
			}
		}
	}
	
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}
	
}
