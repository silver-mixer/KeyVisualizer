package com.github.silver_mixer.KeyVisualizer;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class Polygon extends Shape{
	private int[] xpoints, ypoints;
	private int centerx, centery;
	
	public Polygon(String text, int[] xpoints, int[] ypoints, Color fillColor, Color activeColor, int keyCode, int lineWidth, int fontSize) {
		font = new Font(null, Font.PLAIN, fontSize);
		this.text = text;
		this.xpoints = xpoints;
		this.ypoints = ypoints;
		this.fillColor = fillColor;
		this.activeColor = activeColor;
		this.keyCode = keyCode;
		this.lineWidth = lineWidth;
		int minx = xpoints[0], maxx = xpoints[0], miny = ypoints[0], maxy = ypoints[0];
		for(int x: xpoints) {
			if(x < minx)minx = x;
			if(maxx < x)maxx = x;
		}
		for(int y: ypoints) {
			if(y < miny)miny = y;
			if(maxy < y)maxy = y;
		}
		centerx = minx + (maxx - minx) / 2;
		centery = miny + (maxy - miny) / 2;
	}
	
	@Override
	public void drawShape(Graphics2D g2d) {
		if(keyCode != -1 && NativeInputListener.isPressedKey(keyCode)) {
			g2d.setColor(activeColor);
		}else {
			g2d.setColor(fillColor);
		}
		g2d.setStroke(new BasicStroke(lineWidth));
		g2d.fillPolygon(xpoints, ypoints, xpoints.length);
		g2d.setColor(Color.BLACK);
		g2d.drawPolygon(xpoints, ypoints, xpoints.length);
		g2d.setFont(font);
		g2d.drawString(text, centerx - g2d.getFontMetrics().stringWidth(text) / 2, centery + font.getSize() / 2);
	}
}