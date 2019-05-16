package dev.mate.cinemagame.states;

import java.awt.Graphics;

import dev.mate.cinemagame.Game;
import dev.mate.cinemagame.Handler;
import dev.mate.cinemagame.entities.Shop;
import dev.mate.cinemagame.entities.creatures.Player;
import dev.mate.cinemagame.map.Map;
import dev.mate.cinemagame.utils.Utils;
import dev.mate.cinemagame.world.World;

public class GameState extends State {

	private World world;
	

	public GameState(Handler handler) {
		super(handler);
		world = new World(handler, "resources/world/marketplace.txt");
		handler.setWorld(world);
		

		
	}
	
	@Override
	public void tick() {
		world.tick();
		
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
		
	}
}
