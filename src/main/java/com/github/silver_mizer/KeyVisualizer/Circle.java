package com.github.silver_mizer.KeyVisualizer;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class Circle extends Shape{
	private int x, y, r;
	
	public Circle(String text, int x, int y, int r, Color fillColor, Color activeColor, int keyCode, int lineWidth, int fontSize) {
		font = new Font(null, Font.PLAIN, fontSize);
		this.text = text;
		this.x = x;
		this.y = y;
		this.r = r;
		this.fillColor = fillColor;
		this.activeColor = activeColor;
		this.keyCode = keyCode;
		this.lineWidth = lineWidth;
	}

	@Override
	public void drawShape(Graphics2D g2d) {
		if(NativeInputListener.isPressedKey(keyCode)) {
			g2d.setColor(activeColor);
		}else {
			g2d.setColor(fillColor);
		}
		g2d.setStroke(new BasicStroke(lineWidth));
		g2d.fillOval(x - r, y - r, r * 2, r * 2);
		g2d.setColor(Color.BLACK);
		g2d.drawOval(x - r, y - r, r * 2, r * 2);
		g2d.setFont(font);
		g2d.drawString(text, x - g2d.getFontMetrics().stringWidth(text) / 2, y + font.getSize() / 2);
	}
}
