package dev.mate.cinemagame.states;

import java.awt.Graphics;

import dev.mate.cinemagame.Handler;
import dev.mate.cinemagame.gfx.Assets;
import dev.mate.cinemagame.ui.ClickListener;
import dev.mate.cinemagame.ui.UIImageButton;
import dev.mate.cinemagame.ui.UIManager;

public class MenuState extends State {

	private UIManager uiManager;
	
	public MenuState(Handler handler) {
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouse().setUIManager(uiManager);
		
		uiManager.addObject(new UIImageButton(handler.getGame().getWidth()/2-Assets.MENU_BUTTON_WIDTH/2, handler.getGame().getHeight()/2-Assets.MENU_BUTTON_HEIGHT/2, 
				Assets.MENU_BUTTON_WIDTH, Assets.MENU_BUTTON_HEIGHT, Assets.startButton, new ClickListener() {

			@Override
			public void onClick() {
				handler.getMouse().setUIManager(null);		
				State.setState(handler.getGame().gameState);
				
			}}));
	}
	
	
	@Override
	public void tick() {
		uiManager.tick();		
	}

	@Override
	public void render(Graphics g) {
		uiManager.render(g);
		
	}
	
}
