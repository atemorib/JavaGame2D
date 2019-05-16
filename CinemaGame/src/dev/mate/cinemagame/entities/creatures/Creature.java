package dev.mate.cinemagame.entities.creatures;

import dev.mate.cinemagame.Handler;
import dev.mate.cinemagame.entities.Entity;
import dev.mate.cinemagame.map.Map;

public abstract class Creature extends Entity {


	public static final float DEFAULT_SPEED = 2.0f;
	public static final int DEFAULT_CREATURE_WIDTH = 100,
							DEFAULT_CREATURE_HEIGHT = 100;
	

	protected float speed;
	protected float xMove, yMove;
	
	public Creature(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
	}
	
	public void move() {
		if(!checkEntityCollision(xMove, 0))
			moveX();
		if(!checkEntityCollision(0, yMove))
			moveY();
		
	}
	
	
	public void moveX() {
		if(xMove > 0) {			
			
			int tx = (int) (x + xMove + bound.x + bound.width) / Map.TILEWIDTH;
			if(collison(tx, (int) (y + bound.y) / Map.TILEHEIGHT) &&  collison (tx, (int) (y + bound.y + bound.height) / Map.TILEHEIGHT)) {
				x += xMove;
			}
			else {
				x = tx * Map.TILEWIDTH - bound.x - bound.width  -1;	
			}
			
		}
		else if(xMove < 0) {	//balra
			int tx = (int) (x + xMove + bound.x) / Map.TILEWIDTH;
			if(collison(tx, (int) (y + bound.y) / Map.TILEHEIGHT) &&  collison (tx, (int) (y + bound.y + bound.height) / Map.TILEHEIGHT)) {
				x += xMove;
			}
			else {
				x = tx * Map.TILEWIDTH + Map.TILEWIDTH - bound.x ;
			}
		}
	}
	public void moveY() {
		if(yMove < 0) {			//fel
			int ty = (int) (y + yMove + bound.y) / Map.TILEHEIGHT;
			
			if(collison((int)(x + bound.x) / Map.TILEWIDTH, ty) && collison((int)(x + bound.x + bound.width) / Map.TILEWIDTH, ty)) {
				y += yMove;
			}
			else {
				y = ty * Map.TILEHEIGHT + Map.TILEHEIGHT - bound.y;
			}
			
		}
		else if (yMove > 0) {	//le
			int ty = (int) (y + yMove + bound.y + bound.height) / Map.TILEHEIGHT;
			
			if(collison((int)(x + bound.x) / Map.TILEWIDTH, ty) && collison((int)(x + bound.x + bound.width) / Map.TILEWIDTH, ty)) {
				y += yMove;
			}
			else {
				y = ty * Map.TILEHEIGHT - bound.y - bound.height  -1;
			}
		}
	}
	
	protected boolean collison(int x, int y ) {
		return handler.getWorld().getMap(x, y).walkable();
	}


	
	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}


	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}
		
	
}
