package com.github.silver_mizer.KeyVisualizer;

import java.awt.Color;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import javax.swing.JWindow;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

public class KeyVisualizer extends JWindow{
	private static final long serialVersionUID = 1L;
	private RenderPanel renderPanel;
	private boolean isMouseEntered = false;
	
	public static void main(String[] args) {
		LogManager.getLogManager().reset();
		Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
		logger.setLevel(Level.OFF);
		try {
			if(!GlobalScreen.isNativeHookRegistered()) {
				GlobalScreen.registerNativeHook();
			}
		}catch(NativeHookException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				try {
					if(GlobalScreen.isNativeHookRegistered()) {
						GlobalScreen.unregisterNativeHook();
					}
				}catch(NativeHookException e) {
					e.printStackTrace();
					System.exit(1);
				}
			}
		});
		
		GlobalScreen.addNativeKeyListener(NativeInputListener.getInstance());
		GlobalScreen.addNativeMouseListener(NativeInputListener.getInstance());
		GlobalScreen.addNativeMouseMotionListener(NativeInputListener.getInstance());
		KeyVisualizer window = new KeyVisualizer();
		window.setVisible(true);
		window.setLocation(0, 0);
	}

	public KeyVisualizer() {
		setAlwaysOnTop(true);
		setBackground(new Color(255, 255, 255, 0));
		setLayout(null);
		setBounds(1, 1, 640, 480);
		
		WindowDragListener windowDragListener = new WindowDragListener(this);
		addMouseListener(windowDragListener);
		addMouseMotionListener(windowDragListener);
		
		KeyVisualizerConfig config = new KeyVisualizerConfig();
		config.load(new File(KeyVisualizer.class.getResource("assets/Test.kvc").getFile()));
		setBounds(1, 1, config.getWidth(), config.getHeight());
		
		renderPanel = new RenderPanel(this);
		renderPanel.setBounds(0, 0, config.getWidth(), config.getHeight());
		renderPanel.setShapes(config.getShapes());
		NativeInputListener.addListener(renderPanel);
		add(renderPanel);
	}
	
	public boolean isMouseEntered() {
		return isMouseEntered;
	}
	
	public void setMouseEntered(boolean entered) {
		isMouseEntered = entered;
		renderPanel.repaint();
	}
	
	public void render() {
		renderPanel.repaint();
	}
}
