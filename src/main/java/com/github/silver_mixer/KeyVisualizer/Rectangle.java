package com.github.silver_mixer.KeyVisualizer;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class Rectangle extends Shape{
	private int startx, starty, width, height;
	
	public Rectangle(String text, int startx, int starty, int width, int height, Color fillColor, Color activeColor, KVKey[] keys, Integer[] buttons, int lineWidth, int fontSize) {
		font = new Font(null, Font.PLAIN, fontSize);
		this.texts = text.split("\n");
		this.startx = startx;
		this.starty = starty;
		this.width = width;
		this.height = height;
		this.fillColor = fillColor;
		this.activeColor = activeColor;
		this.activateKeys = NativeInputListener.getNativeKeyLayout(keys);
		this.activateButtons = buttons;
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
		for(int b: activateButtons) {
			if(NativeInputListener.isPressedButton(b)) {
				g2d.setColor(activeColor);
				break;
			}
		}
		g2d.setStroke(new BasicStroke(lineWidth));
		g2d.fillRect(startx, starty, width, height);
		g2d.setColor(Color.BLACK);
		g2d.drawRect(startx, starty, width, height);
		g2d.setFont(font);
		drawString(g2d, texts, startx + width / 2, starty + height / 2);
	}
}
