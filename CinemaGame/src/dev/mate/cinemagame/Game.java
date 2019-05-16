package dev.mate.cinemagame;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import dev.mate.cinemagame.display.Display;
import dev.mate.cinemagame.gfx.Assets;
import dev.mate.cinemagame.gfx.Camera;
import dev.mate.cinemagame.input.Keymanager;
import dev.mate.cinemagame.input.Mouse;
import dev.mate.cinemagame.states.GameState;
import dev.mate.cinemagame.states.MenuState;
import dev.mate.cinemagame.states.State;


public class Game implements Runnable {
	
	private Display display;
	public String title;
	private int width, height;		
	
	private Thread thread;
	private boolean running = false;
	
	private BufferStrategy bs;
	private Graphics g;

	
	
	public State gameState;
	public State menuState;	
	
	
	private Keymanager keyManager; 
	private Mouse mouse;
	
	
	
	private Camera gameCamera;
	
	
	private Handler handler;
	


	
	public Game(int width, int height) {
		
		this.width = width;
		this.height = height; 
		keyManager = new Keymanager();
		mouse = new Mouse();
		
		
		
	}
	
	private void initialize () {
		display = new Display(width, height);
		display.getFrame().addKeyListener(keyManager);
		
		display.getFrame().addMouseListener(mouse);
		display.getFrame().addMouseMotionListener(mouse);
		display.getCanvas().addMouseListener(mouse);
		display.getCanvas().addMouseMotionListener(mouse);
		Assets.init();
	
		handler = new Handler(this);
		gameCamera = new Camera(handler, 0, 0);
		
		gameState = new GameState(handler);
		menuState = new MenuState(handler);
		
		
		State.setState(menuState);
		
		
	}
	
	
	
	private void update() {
		keyManager.tick();
		if(State.getState() != null) {
			State.getState().tick();
		}
		
		
	}
	
	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null) {
			display.getCanvas().createBufferStrategy(2);
			return;
		}
		g = bs.getDrawGraphics();
	
		g.clearRect(0, 0, width, height);
		
		
		
				
		if(State.getState() != null) {
			State.getState().render(g);
		}



		
		//TODO: rajz test stop 
		bs.show();
		g.dispose(); 
	}
	
	public void run() {
		
		initialize();
		
		
		
		int fps = 120;
		final double timerPerTick = 1000000000.0 / fps; 
		double delta = 0;															
		
		long lastTime = System.nanoTime();
		long timer = 0;							
		int ticks = 0;							
		
		while (running) {
			
			long now = System.nanoTime();			
			delta += (now-lastTime) / timerPerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1) {					
				
				update();
				
				ticks++;
				delta--;
				
			}
			render();
		
			
			if(timer >= 1000000000) {
				//System.out.println("FPS:" +ticks);
				display.getFrame().setTitle(display.getTitle() + " | " + "FPS: "+ticks);
				ticks = 0;
				timer = 0;
				//System.out.println("Money: "+ money);
				
			}
			
			
		}
		
		stop();
		
	}
	
	
	
	public synchronized void start () {
		if(running) {
			return;
		}
		running = true;
		thread = new Thread(this);
		thread.start();		//thread.start() egy �j threadet csin�l ami megh�vja a run met�dust
	}
	
	public synchronized void stop () {
		if(!running) {
			return;
		}
		running = false;
		
		
		try {
			thread.join();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	
	//Getters & setters
	public Keymanager getKeyManager() {
		return keyManager;
	}
	
	public Mouse getMouse() {
		return mouse;
	}
	
	public Camera getCamera() {
		return gameCamera;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
}
