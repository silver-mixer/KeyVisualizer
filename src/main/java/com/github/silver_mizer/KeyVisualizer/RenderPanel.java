package com.github.silver_mizer.KeyVisualizer;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class RenderPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private KeyVisualizer window;
	
	public RenderPanel(KeyVisualizer window) {
		this.window = window;
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
	}
}
