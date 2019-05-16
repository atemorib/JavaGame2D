package dev.mate.cinemagame.entities;

import java.awt.Graphics;

import dev.mate.cinemagame.Handler;
import dev.mate.cinemagame.gfx.Assets;
import dev.mate.cinemagame.map.Map;

public abstract class Shop extends StaticObjects {
		

	public Shop(Handler handler, float x, float y) {				
		super(handler, x, y, Map.TILEWIDTH*4, Map.TILEHEIGHT*2);
		bound.x = 0;
		bound.y = 0;
		bound.width = 500;
		bound.height =236;	
		
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {

	}
	
}
