package dev.mate.cinemagame.entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import dev.mate.cinemagame.Handler;
import dev.mate.cinemagame.entities.creatures.Player;
import dev.mate.cinemagame.gfx.Assets;
import dev.mate.cinemagame.map.Map;

public class CanvasShop extends StaticObjects {

	public static final Rectangle actionArea = new Rectangle (0, Map.TILEWIDTH*3, Map.TILEWIDTH*2, 100);
	
	
	public CanvasShop(Handler handler, float x, float y){
		super(handler, x, y, Map.TILEWIDTH*2, Map.TILEHEIGHT*3);
		
		
		//HARDCODED STUFF
		bound.x = 0;
		bound.y = 0;
		bound.width = 246;		
		bound.height = 364;

		actionArea.x = 0;
		actionArea.y = Map.TILEHEIGHT*3;
		actionArea.width = Map.TILEWIDTH*2;
		actionArea.height = 100;
		
		System.out.println(actionArea.width);
		
	}
	
	

	@Override
	public void tick() {
		
			
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.canvasShop, (int) (x - handler.getCamera().getxOffset()), (int) (y - handler.getCamera().getyOffset()), width, height, null);
		g.fillRect((int) (x + bound.x - handler.getCamera().getxOffset()),
		(int) (y + bound.y - handler.getCamera().getyOffset()),
		bound.width, bound.height);
		g.fillRect((int) (x+actionArea.x - handler.getCamera().getxOffset()),
		(int) (y + actionArea.y - handler.getCamera().getyOffset()),
		actionArea.width, actionArea.height);		
		
	}

	@Override
	protected void action() {
	
		
	}

	
	
}
