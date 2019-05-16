package dev.mate.cinemagame.map;

import dev.mate.cinemagame.gfx.Assets;

public class WallTile extends Map {
	
	public WallTile(int id) {
		super(Assets.wall, id);
	}
	
	@Override
	public boolean walkable() {
		return false;
	}

}
