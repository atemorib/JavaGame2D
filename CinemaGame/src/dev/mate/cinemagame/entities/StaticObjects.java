package dev.mate.cinemagame.entities;

import dev.mate.cinemagame.Handler;

public abstract class StaticObjects extends Entity {
	
	public StaticObjects(Handler handler, float x, float y, int width, int height) {
		
		super(handler,x,y,width,height);

	}
	
	protected abstract void action();

}
