package dev.mate.cinemagame.entities;

import java.awt.Graphics;

import dev.mate.cinemagame.Handler;
import dev.mate.cinemagame.gfx.Assets;
import dev.mate.cinemagame.map.Map;

public class ProjectorShop extends StaticObjects {
	
	public ProjectorShop(Handler handler, float x, float y){
		super(handler, x, y, Map.TILEWIDTH*2, Map.TILEHEIGHT*3);
			
		bound.x = 0;
		bound.y = 0;
		bound.width = 146;		
		bound.height = 364;
		
		actionArea.x = 0;
		actionArea.y = Map.TILEHEIGHT*3;
		actionArea.width = 156;
		actionArea.height = 100;
	}

	@Override
	public void tick() {
			
			
	}
	
	public void action() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.projectorShop, (int) (x - handler.getCamera().getxOffset()), (int) (y - handler.getCamera().getyOffset()), width, height, null);
		g.fillRect((int) (x+actionArea.x - handler.getCamera().getxOffset()),
				(int) (y + actionArea.y - handler.getCamera().getyOffset()),
				actionArea.width, actionArea.height);
			
	}
}
