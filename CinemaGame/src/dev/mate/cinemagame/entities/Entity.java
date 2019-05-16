package dev.mate.cinemagame.entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import dev.mate.cinemagame.Game;
import dev.mate.cinemagame.Handler;
import dev.mate.cinemagame.gfx.Assets;

public abstract class Entity {

	protected float x, y;
	protected int width, height;
	protected Handler handler;
	protected Rectangle bound;	
	protected Rectangle actionArea; 
	
	
	public Entity(Handler handler, float x, float y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.handler = handler;
		
	
		bound = new Rectangle(0, 0, width, height);
		actionArea = new Rectangle(0, 0, width, height);
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	

	
	
	
	
	public Rectangle collisionBounds(float xOffset, float yOffset) {
		return new Rectangle((int)(x + bound.x + xOffset), (int) (y + bound.y + yOffset), bound.width, bound.height);
	}
	
	public boolean checkEntityCollision(float xOffset , float yOffset) {
		for(Entity e: handler.getWorld().getEntityManager().getEntities()) {
			if(e.equals(this)) {
				continue;
			}
			if(e.collisionBounds(0, 0).intersects(collisionBounds(xOffset, yOffset))) {
				return true;
			}
			
		}
		return false;
	}
	
	

	
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}


	
}
