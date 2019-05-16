package dev.mate.cinemagame.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	public static final int FLOOR_WIDTH=256, FLOOR_HEIGHT=256, CHARACTER_WIDTH=64, CHARACTER_HEIGHT=64,
							WALL_WIDTH=128, WALL_HEIGHT=128,
							MENU_BUTTON_WIDTH = 364, MENU_BUTTON_HEIGHT=109 ;
	
	public static BufferedImage floor, wall, crackedFloor, playerStill, canvasShop, seatShop, projectorShop,
								cinema, spaceShop, otherShop;
	public static BufferedImage[] playerDown, playerUp, playerLeft, playerRight;
	public static BufferedImage[] startButton;
	public static BufferedImage inventory , shopPanel;
	

	
	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/base.jpg"));
		SpriteSheet characterSheet = new SpriteSheet(ImageLoader.loadImage("/textures/character.jpg"));
		SpriteSheet menuSheet = new SpriteSheet(ImageLoader.loadImage("/images/menuPlay.png"));
		wall = ImageLoader.loadImage("/textures/wall.png");
		floor = sheet.crop( 0, 0, FLOOR_WIDTH, FLOOR_HEIGHT );		
		crackedFloor = sheet.crop(FLOOR_WIDTH, FLOOR_HEIGHT, FLOOR_WIDTH, FLOOR_HEIGHT);
		playerStill = characterSheet.crop(0, CHARACTER_HEIGHT*2, CHARACTER_WIDTH, CHARACTER_HEIGHT);
		
		
	
		playerDown = new BufferedImage[9];
		for(int i=0; i<playerDown.length;i++) {
			playerDown[i] = characterSheet.crop(CHARACTER_WIDTH*i,CHARACTER_HEIGHT*2 , CHARACTER_WIDTH, CHARACTER_HEIGHT);

		}
		playerUp = new BufferedImage[9];
		for(int i=0; i<playerUp.length;i++) {
			playerUp[i] = characterSheet.crop(CHARACTER_WIDTH*i, 0 , CHARACTER_WIDTH, CHARACTER_HEIGHT);

		}
		playerRight = new BufferedImage[9];
		for(int i=0; i<playerRight.length;i++) {
			playerRight[i] = characterSheet.crop(CHARACTER_WIDTH*i,CHARACTER_HEIGHT*3 , CHARACTER_WIDTH, CHARACTER_HEIGHT);

		}
		playerLeft = new BufferedImage[9];
		for(int i=0; i<playerLeft.length;i++) {
			playerLeft[i] = characterSheet.crop(CHARACTER_WIDTH*i,CHARACTER_HEIGHT , CHARACTER_WIDTH, CHARACTER_HEIGHT);

		}
		
	
		canvasShop = ImageLoader.loadImage("/textures/vaszonbolt.png");
		projectorShop = ImageLoader.loadImage("/textures/vetitobolt.png");
		otherShop = ImageLoader.loadImage("/textures/egyeb.png");
		cinema = ImageLoader.loadImage("/textures/mozi.png");
		spaceShop = ImageLoader.loadImage("/textures/teruletbolt.png");
		seatShop = ImageLoader.loadImage("/textures/ulohely.png");
		

		
		startButton = new BufferedImage[2];
		startButton[0] = menuSheet.crop(0, 0, MENU_BUTTON_WIDTH, MENU_BUTTON_HEIGHT);
		startButton[1] = menuSheet.crop(0, MENU_BUTTON_HEIGHT, MENU_BUTTON_WIDTH, MENU_BUTTON_HEIGHT);		
		
	
		inventory = ImageLoader.loadImage("/images/inventory.png");
		shopPanel = ImageLoader.loadImage("/images/shopPanel.png");
		
	}
	
}


