package dev.mate.cinemagame.gfx;

import dev.mate.cinemagame.Handler;
import dev.mate.cinemagame.entities.Entity;
import dev.mate.cinemagame.map.Map;

public class Camera {

	private Handler handler;
	private float xOffset, yOffset;
	
	public Camera(Handler game, float xOffset, float yOffset) {
		this.setxOffset(xOffset);
		this.setyOffset(yOffset);
		this.handler = game;
	}

	
	public void isBlankSpace() {
		if(xOffset < 0) {
			xOffset = 0;
		}
		else if(xOffset > handler.getWorld().getWidth() * Map.TILEWIDTH - handler.getWidth() ) {
			xOffset = handler.getWorld().getWidth() * Map.TILEWIDTH - handler.getWidth();
		}
		if(yOffset < 0) {
			yOffset = 0;
		}
		else if(yOffset > handler.getWorld().getHeight() * Map.TILEHEIGHT - handler.getHeight() ) {
			yOffset = handler.getWorld().getHeight() * Map.TILEHEIGHT - handler.getHeight();
		}
	}
	
	public void centerEntity(Entity e) {
		xOffset = e.getX() - handler.getWidth() / 2 + e.getWidth() / 2;	//hogy k�z�pen maradjon a player
		yOffset = e.getY() - handler.getHeight() / 2 + e.getHeight() / 2;
		isBlankSpace();
	}
	
	public void move(float xAmount, float yAmount) {
		xOffset += xAmount;
		yOffset += yAmount;
		isBlankSpace();
	}
	
	public float getyOffset() {
		return yOffset;
	}

	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}

	public float getxOffset() {
		return xOffset;
	}

	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}
	
}
