package dev.mate.cinemagame.entities.creatures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import dev.mate.cinemagame.Handler;
import dev.mate.cinemagame.entities.Entity;
import dev.mate.cinemagame.gfx.Animation;
import dev.mate.cinemagame.gfx.Assets;

public class Player extends Creature {


	private Animation animationDown, animationUp, animationLeft, animationRight;
	
	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		bound.x = 25;
		bound.y = 50;
		bound.width = 50;
		bound.height =50;
	
		animationDown = new Animation(40,Assets.playerDown);
		animationLeft = new Animation(40,Assets.playerLeft);
		animationRight = new Animation(40,Assets.playerRight);
		animationUp = new Animation(40,Assets.playerUp);
		
	}

	@Override
	public void tick() {
		
		animationDown.tick();
		animationUp.tick();
		animationLeft.tick();
		animationRight.tick();
		
	
		getInput();
		move();
		handler.getCamera().centerEntity(this);


	}
	

	
	private void getInput() {
		xMove = 0;
		yMove = 0;
		
		if(handler.getKeyManager().up) {
			yMove = -speed;

		}
		if(handler.getKeyManager().down) {
			yMove = speed;
			
		}
		if(handler.getKeyManager().left) {
			xMove = -speed;

		}
		if(handler.getKeyManager().right) {
			xMove = speed;
		}

	}

	
	Rectangle playerBound = new Rectangle((int) (x + bound.x - handler.getCamera().getxOffset()),
			(int) (y + bound.y - handler.getCamera().getyOffset()),
			bound.width, bound.height);
	
	
	
	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int)(x - handler.getCamera().getxOffset()), (int)(y - handler.getCamera().getyOffset()),width, height, null);
		
		g.setColor(Color.red);
		g.fillRect((int) (x + bound.x - handler.getCamera().getxOffset()),
					(int) (y + bound.y - handler.getCamera().getyOffset()),
					bound.width, bound.height);
			
	}
	
	
	private BufferedImage getCurrentAnimationFrame() {
		if(xMove < 0) {
			return animationLeft.getCurrentFrame();
		}
		else if(xMove > 0) {
			return animationRight.getCurrentFrame();
		}
		else if(yMove < 0) {
			return animationUp.getCurrentFrame();
			
		}
		else if(yMove > 0) {
			return animationDown.getCurrentFrame();
		}
		else{
			return Assets.playerStill;	

		}
		
	}
	
	public Rectangle getPlayerBound() {
		return new Rectangle((int) (x + bound.x - handler.getCamera().getxOffset()),
				(int) (y + bound.y - handler.getCamera().getyOffset()),
				bound.width, bound.height);
	}


	
}
