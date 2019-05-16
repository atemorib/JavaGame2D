package dev.mate.cinemagame.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import dev.mate.cinemagame.ui.UIManager;

public class Mouse implements MouseListener, MouseMotionListener {

	private static int mouseY = -1;
	private static int mouseX = -1;
	private boolean mouseB1, mouseB2;
	private UIManager uiManager;
	
	public Mouse() {
		
	}
	
	public void setUIManager(UIManager uiManager) {
		this.uiManager = uiManager;
	}

	
	@Override
	public void mouseDragged(MouseEvent e) {

	}

	@Override
	public void mouseMoved(MouseEvent e) {
			mouseX = e.getX();
			mouseY = e.getY();
			
			if(uiManager !=null ) {
				uiManager.onMouseMove(e);
			}
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
			if(e.getButton()==MouseEvent.BUTTON1) {
				mouseB1 = true;
			}
			else if(e.getButton()==MouseEvent.BUTTON3) {
				mouseB2 = true;
			}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getButton()==MouseEvent.BUTTON1) {
			mouseB1 = false;
		}
		else if(e.getButton()==MouseEvent.BUTTON3) {
			mouseB2 = false;
		}
		
		if(uiManager !=null ) {
			uiManager.onMouseRelease(e);
		}
	}

	public boolean isB1Pressed() {
		return mouseB1;
	}
	public boolean isB2Pressed() {
		return mouseB2;
	}
	public int getMouseX() {
		return mouseX;
	}
	public int getMouseY() {
		return mouseY;
	}
}
