package dev.mate.cinemagame.display;


import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JDialog;
import javax.swing.JFrame;

import dev.mate.cinemagame.Handler;
import dev.mate.cinemagame.entities.CanvasShop;
import dev.mate.cinemagame.entities.EntityManager;
import dev.mate.cinemagame.entities.creatures.Player;
import dev.mate.cinemagame.map.Map;



public class Display implements KeyListener {

	private Canvas canvas;	
	

	
	private JFrame frame;
	

	private JDialog dialog;
	
	
	
	private static String title = "CinemaManager";
	private int height, width;
	

	private Handler handler;
	

	private Player player;
	
	
	public Display(int width, int height) {
		this.width = width;
		this.height = height;
		
		createDisplay();		
		

		
	}
	
	
	
	private void createDisplay () {
		
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setLocationRelativeTo(null);		
		frame.setVisible(true);	
		frame.setResizable(false);		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(this);
		
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));	
		canvas.setMinimumSize(new Dimension(width, height));
		canvas.setFocusable(false);
		
		frame.add(canvas);
		frame.pack();	
	}
	

	
	public Canvas getCanvas() {
		return canvas;
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	
	
	Rectangle kaka = new Rectangle();

	
	
	
	private boolean pressed=false;
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_E && !pressed) {
			System.out.println("pressed");
			pressed=true;

			System.out.println(CanvasShop.actionArea);
			
			
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_E && pressed) {
			pressed=false;
			System.out.println("released");
			
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}
}
