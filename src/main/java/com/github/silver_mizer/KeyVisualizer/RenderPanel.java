package com.github.silver_mizer.KeyVisualizer;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import org.jnativehook.keyboard.NativeKeyEvent;

public class RenderPanel extends JPanel implements NativeInputListenerInterface{
	private static final long serialVersionUID = 1L;
	private KeyVisualizer window;
	private List<Shape> shapes = new ArrayList<Shape>();
	
	public RenderPanel(KeyVisualizer window) {
		this.window = window;
		shapes.add(new Rectangle("A", 10, 10, 50, 50, Color.WHITE, Color.RED, NativeKeyEvent.VC_A));
		shapes.add(new Circle("B", 95, 35, 25, Color.WHITE, Color.RED, NativeKeyEvent.VC_B));
		shapes.add(new Polygon("Space", new int[] {10, 110, 110, 10}, new int[] {70, 70, 120, 120}, Color.WHITE, Color.RED, NativeKeyEvent.VC_SPACE));
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.setBackground(new Color(0, 0, 255, 0));
		g2d.clearRect(0, 0, getWidth(), getHeight());
		g2d.setStroke(new BasicStroke(2));
		if(window.isMouseEntered()) {
			g2d.setColor(Color.GREEN);
			g2d.drawRect(1, 1, getWidth() - 2, getHeight() -2);
		}else {
			g2d.setColor(Color.BLACK);
			g2d.drawRect(1, 1, getWidth() - 2, getHeight() -2);
		}
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		for(Shape shape: shapes) {
			shape.drawShape(g2d);
		}
	}
	
	@Override
	public void changeKeyState() {
		repaint();
	}
}
