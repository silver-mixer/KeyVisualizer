package com.github.silver_mixer.KeyVisualizer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class Shape{
	protected String[] texts;
	protected Color fillColor, activeColor;
	protected Font font;
	protected int lineWidth;
	protected NativeKeyLayout[] activateKeys;
	
	public void drawShape(Graphics2D g2d) {}
	
	protected void drawString(Graphics2D g2d, String[] texts, int x, int y) {
		y += g2d.getFontMetrics().getHeight() / 2 - g2d.getFontMetrics().getHeight() * (texts.length - 1) / 2;
		for(String str: texts) {
			g2d.drawString(str, x - g2d.getFontMetrics().stringWidth(str) / 2, y);
			y += g2d.getFontMetrics().getHeight();
		}
	}
}
