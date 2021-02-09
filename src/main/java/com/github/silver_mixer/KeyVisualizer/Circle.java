package com.github.silver_mixer.KeyVisualizer;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class Circle extends Shape{
	private int x, y, r;
	
	public Circle(String text, int x, int y, int r, Color fillColor, Color activeColor, KVKey key, int lineWidth, int fontSize) {
		font = new Font(null, Font.PLAIN, fontSize);
		this.texts = text.split("\n");
		this.x = x;
		this.y = y;
		this.r = r;
		this.fillColor = fillColor;
		this.activeColor = activeColor;
		this.activateKeys = NativeInputListener.getNativeKeyLayout(key);
		this.lineWidth = lineWidth;
	}

	@Override
	public void drawShape(Graphics2D g2d) {
		g2d.setColor(fillColor);
		for(NativeKeyLayout k: activateKeys) {
			if(NativeInputListener.isPressedKey(k)) {
				g2d.setColor(activeColor);
				break;
			}
		}
		g2d.setStroke(new BasicStroke(lineWidth));
		g2d.fillOval(x - r, y - r, r * 2, r * 2);
		g2d.setColor(Color.BLACK);
		g2d.drawOval(x - r, y - r, r * 2, r * 2);
		g2d.setFont(font);
		drawString(g2d, texts, x, y);
	}
}
