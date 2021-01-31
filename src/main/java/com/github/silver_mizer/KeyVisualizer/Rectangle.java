package com.github.silver_mizer.KeyVisualizer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import org.jnativehook.keyboard.NativeKeyEvent;

public class Rectangle extends Shape{
	private int startx, starty, width, height;
	private Font font = new Font(null, Font.PLAIN, 24);
	
	public Rectangle(String text, int startx, int starty, int width, int height, Color fillColor, Color activeColor) {
		this.text = text;
		this.startx = startx;
		this.starty = starty;
		this.width = width;
		this.height = height;
		this.fillColor = fillColor;
		this.activeColor = activeColor;
	}

	@Override
	public void drawShape(Graphics2D g2d) {
		if(NativeInputListener.isPressedKey(NativeKeyEvent.VC_A)) {
			g2d.setColor(activeColor);
		}else {
			g2d.setColor(fillColor);
		}
		g2d.fillRect(startx, starty, width, height);
		g2d.setColor(Color.BLACK);
		g2d.drawRect(startx, starty, width, height);
		g2d.setFont(font);
		g2d.drawString(text, startx + width / 2 - g2d.getFontMetrics().stringWidth(text) / 2, starty + height / 2 + font.getSize() / 2);
	}
}
