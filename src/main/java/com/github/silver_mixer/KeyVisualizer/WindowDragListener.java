package com.github.silver_mixer.KeyVisualizer;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class WindowDragListener implements MouseListener, MouseMotionListener{
	private KeyVisualizer window;
	private int clickX, clickY;
	
	public WindowDragListener(KeyVisualizer window) {
		this.window = window;
	}

	@Override
	public void mousePressed(MouseEvent event) {
		clickX = event.getXOnScreen();
		clickY = event.getYOnScreen();
	}
	
	@Override
	public void mouseClicked(MouseEvent event) {
		if(event.getClickCount() == 2)System.exit(0);
	}
	
	@Override
	public void mouseReleased(MouseEvent event) {}
	
	@Override
	public void mouseEntered(MouseEvent event) {
		window.setMouseEntered(true);
	}
	
	@Override
	public void mouseExited(MouseEvent event) {
		window.setMouseEntered(false);
	}
	
	@Override
	public void mouseMoved(MouseEvent event) {}
	
	@Override
	public void mouseDragged(MouseEvent event) {
		int clickCurrentX = event.getXOnScreen(), clickCurrentY = event.getYOnScreen();
		Point currentPosition = window.getLocation();
		window.setLocation(currentPosition.x + (clickCurrentX - clickX), currentPosition.y + (clickCurrentY - clickY));
		clickX = clickCurrentX;
		clickY = clickCurrentY;
	}
}