package com.github.silver_mixer.KeyVisualizer;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class KeyVisualizerConfig{
	private List<Shape> shapes = new ArrayList<Shape>();
	private int paddingTop = 0, paddingBottom = 0, paddingLeft = 0, paddingRight = 0;
	private int width = 0, height = 0;
	
	public boolean load(InputStream stream) {
		if(stream == null)return false;
		try(BufferedReader br = new BufferedReader(new InputStreamReader(stream))){
			int lineWidth = 2, fontSize = 14;
			int maxWidth = 0, maxHeight = 0;
			String line;
			NativeInputListener.initializeKeyMap(KeyVisualizer.getOS(), false);
			while((line = br.readLine()) != null) {
				if(line.isEmpty() || line.startsWith("#"))continue;
				String[] op = getCommands(line);
				if(op.length == 0)continue;
				if(op[0].equals("RECT") && op.length >= 6) {
					int x, y, w, h;
					int fillR, fillG, fillB, fillA = 255;
					int activeR, activeG, activeB, activeA = 255;
					List<KVKey> keys = new ArrayList<KVKey>();
					List<Integer> buttons = new ArrayList<Integer>();
					String[] args = op[2].split(",");
					if(args.length < 4)continue;
					x = Integer.parseInt(args[0]);
					y = Integer.parseInt(args[1]);
					w = Integer.parseInt(args[2]);
					h = Integer.parseInt(args[3]);
					args = op[3].split(",");
					if(args.length < 3)continue;
					fillR = Integer.parseInt(args[0]);
					fillG = Integer.parseInt(args[1]);
					fillB = Integer.parseInt(args[2]);
					if(args.length >= 4)fillA = Integer.parseInt(args[3]);
					args = op[4].split(",");
					if(args.length < 3)continue;
					activeR = Integer.parseInt(args[0]);
					activeG = Integer.parseInt(args[1]);
					activeB = Integer.parseInt(args[2]);
					if(args.length >= 4)activeA = Integer.parseInt(args[3]);
					args = op[5].split(",");
					for(String arg: args) {
						if(arg.matches("(LMB|MMB|RMB|MB_[0-9]+)")) {
							int button = 0;
							if(arg.equals("LMB")) {
								button = 1;
							}else if(arg.equals("MMB")) {
								button = 2;
							}else if(arg.equals("RMB")) {
								button = 3;
							}else {
								button = Integer.parseInt(arg.replaceAll("[^0-9]", ""));
							}
							buttons.add(button);
						}else {
							try {
								keys.add(KVKey.valueOf("KV_" + arg));
							}catch(IllegalArgumentException e) {}
						}
					}
					shapes.add(new Rectangle(op[1], x + paddingLeft, y + paddingTop, w, h, new Color(fillR, fillG, fillB, fillA), new Color(activeR, activeG, activeB, activeA), keys.toArray(new KVKey[keys.size()]), buttons.toArray(new Integer[buttons.size()]), lineWidth, fontSize));
					if(maxWidth < x + w + paddingLeft)maxWidth = x + w + paddingLeft;
					if(maxHeight < y + h + paddingTop)maxHeight = y + h + paddingTop;
				}else if(op[0].equals("CIRCLE") && op.length >= 6) {
					int x, y, r;
					int fillR, fillG, fillB, fillA = 255;
					int activeR, activeG, activeB, activeA = 255;
					List<KVKey> keys = new ArrayList<KVKey>();
					List<Integer> buttons = new ArrayList<Integer>();
					String[] args = op[2].split(",");
					if(args.length < 3)continue;
					x = Integer.parseInt(args[0]);
					y = Integer.parseInt(args[1]);
					r = Integer.parseInt(args[2]);
					args = op[3].split(",");
					if(args.length < 3)continue;
					fillR = Integer.parseInt(args[0]);
					fillG = Integer.parseInt(args[1]);
					fillB = Integer.parseInt(args[2]);
					if(args.length >= 4)fillA = Integer.parseInt(args[3]);
					args = op[4].split(",");
					if(args.length < 3)continue;
					activeR = Integer.parseInt(args[0]);
					activeG = Integer.parseInt(args[1]);
					activeB = Integer.parseInt(args[2]);
					if(args.length >= 4)activeA = Integer.parseInt(args[3]);
					args = op[5].split(",");
					for(String arg: args) {
						if(arg.matches("(LMB|MMB|RMB|MB_[0-9]+)")) {
							int button = 0;
							if(arg.equals("LMB")) {
								button = 1;
							}else if(arg.equals("MMB")) {
								button = 2;
							}else if(arg.equals("RMB")) {
								button = 3;
							}else {
								button = Integer.parseInt(arg.replaceAll("[^0-9]", ""));
							}
							buttons.add(button);
						}else {
							try {
								keys.add(KVKey.valueOf("KV_" + arg));
							}catch(IllegalArgumentException e) {}
						}
					}
					shapes.add(new Circle(op[1], x + paddingLeft, y + paddingTop, r, new Color(fillR, fillG, fillB, fillA), new Color(activeR, activeG, activeB, activeA), keys.toArray(new KVKey[keys.size()]), buttons.toArray(new Integer[buttons.size()]), lineWidth, fontSize));
					if(maxWidth < x + r + paddingLeft)maxWidth = x + r + paddingLeft;
					if(maxHeight < y + r + paddingTop)maxHeight = y + r + paddingTop;
				}else if(op[0].equals("POLY") && op.length >= 6) {
					int[] xpoints, ypoints;
					int maxx = 0, maxy = 0;
					int fillR, fillG, fillB, fillA = 255;
					int activeR, activeG, activeB, activeA = 255;
					List<KVKey> keys = new ArrayList<KVKey>();
					List<Integer> buttons = new ArrayList<Integer>();
					String[] args = op[2].split(",");
					if(args.length < 4)continue;
					xpoints = new int[args.length / 2];
					ypoints = new int[args.length / 2];
					for(int i = 0; i < args.length / 2; i++) {
						xpoints[i] = Integer.parseInt(args[i * 2]) + paddingLeft;
						ypoints[i] = Integer.parseInt(args[i * 2 + 1]) + paddingTop;
						if(maxx < xpoints[i])maxx = xpoints[i];
						if(maxy < ypoints[i])maxy = ypoints[i];
					}
					args = op[3].split(",");
					if(args.length < 3)continue;
					fillR = Integer.parseInt(args[0]);
					fillG = Integer.parseInt(args[1]);
					fillB = Integer.parseInt(args[2]);
					if(args.length >= 4)fillA = Integer.parseInt(args[3]);
					args = op[4].split(",");
					if(args.length < 3)continue;
					activeR = Integer.parseInt(args[0]);
					activeG = Integer.parseInt(args[1]);
					activeB = Integer.parseInt(args[2]);
					if(args.length >= 4)activeA = Integer.parseInt(args[3]);
					args = op[5].split(",");
					for(String arg: args) {
						if(arg.matches("(LMB|MMB|RMB|MB_[0-9]+)")) {
							int button = 0;
							if(arg.equals("LMB")) {
								button = 1;
							}else if(arg.equals("MMB")) {
								button = 2;
							}else if(arg.equals("RMB")) {
								button = 3;
							}else {
								button = Integer.parseInt(arg.replaceAll("[^0-9]", ""));
							}
							buttons.add(button);
						}else {
							try {
								keys.add(KVKey.valueOf("KV_" + arg));
							}catch(IllegalArgumentException e) {}
						}
					}
					shapes.add(new Polygon(op[1], xpoints, ypoints, new Color(fillR, fillG, fillB, fillA), new Color(activeR, activeG, activeB, activeA), keys.toArray(new KVKey[keys.size()]), buttons.toArray(new Integer[buttons.size()]), lineWidth, fontSize));
					if(maxWidth < maxx)maxWidth = maxx;
					if(maxHeight < maxy)maxHeight = maxy;
				}else if(op[0].equals("LINEWIDTH") && op.length >= 1) {
					lineWidth = Integer.parseInt(op[1]);
				}else if(op[0].equals("FONTSIZE") && op.length >= 1) {
					fontSize = Integer.parseInt(op[1]);
				}else if(op[0].equals("PADDING") && op.length >= 1) {
					String[] args = op[1].split(",");
					if(args.length < 4)continue;
					paddingTop = Integer.parseInt(args[0]);
					paddingBottom = Integer.parseInt(args[1]);
					paddingLeft = Integer.parseInt(args[2]);
					paddingRight = Integer.parseInt(args[3]);
				}else if(op[0].equals("JPMODE")) {
					NativeInputListener.initializeKeyMap(KeyVisualizer.getOS(), true);
				}
			}
			width = maxWidth + paddingRight;
			height = maxHeight + paddingBottom;
		}catch(IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public List<Shape> getShapes(){
		return shapes;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	private String[] getCommands(String line) {
		List<String> commands = new ArrayList<String>();
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i < line.length(); i++) {
			if(line.charAt(i) == '\\') {
				i++;
				if(line.length() == i)continue;
				if(line.charAt(i) == '\\') {
					builder.append('\\');
				}else if(line.charAt(i) == ';') {
					builder.append(';');
				}else if(line.charAt(i) == 'n') {
					builder.append('\n');
				}
			}else if(line.charAt(i) == ';'){
				commands.add(builder.toString());
				builder = new StringBuilder();
			}else {
				builder.append(line.charAt(i));
			}
		}
		commands.add(builder.toString());
		return commands.toArray(new String[commands.size()]);
	}
}
