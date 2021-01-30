package com.github.silver_mizer.KeyVisualizer;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import javax.swing.JWindow;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseListener;
import org.jnativehook.mouse.NativeMouseMotionListener;

public class KeyVisualizer extends JWindow implements NativeKeyListener, NativeMouseListener, NativeMouseMotionListener{
	private static final long serialVersionUID = 1L;
	private List<Integer> pressedKeys = new ArrayList<Integer>();

	@Override
	public void nativeKeyPressed(NativeKeyEvent event) {
		int id = (event.getKeyCode() != 0 ? event.getKeyCode() : event.getRawCode());
		if(!pressedKeys.contains(id)) {
			pressedKeys.add(id);
			System.out.println("<" + (event.getKeyLocation()) + ">" + event.getKeyCode() + "/" + event.getRawCode() + "/" + NativeKeyEvent.getKeyText(event.getKeyCode()));
		}
	}
	
	@Override
	public void nativeKeyTyped(NativeKeyEvent event) {}
	
	@Override
	public void nativeKeyReleased(NativeKeyEvent event) {
		int id = (event.getKeyCode() != 0 ? event.getKeyCode() : event.getRawCode());
		pressedKeys.remove(Integer.valueOf(id));
	}
	
	@Override
	public void nativeMousePressed(NativeMouseEvent event) {
		
	}
	
	@Override
	public void nativeMouseClicked(NativeMouseEvent event) {
		
	}
	
	@Override
	public void nativeMouseReleased(NativeMouseEvent event) {
		
	}
	
	@Override
	public void nativeMouseDragged(NativeMouseEvent event) {
	}
	
	@Override
	public void nativeMouseMoved(NativeMouseEvent event) {
	}
	
	public KeyVisualizer() {
		setAlwaysOnTop(true);
		setBackground(new Color(255, 255, 255, 128));
		setLayout(null);
		setBounds(1, 1, 640, 480);
		
		WindowDragListener windowDragListener = new WindowDragListener(this);
		addMouseListener(windowDragListener);
		addMouseMotionListener(windowDragListener);
	}
	
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
		
		KeyVisualizer window = new KeyVisualizer();
		GlobalScreen.addNativeKeyListener(window);
		GlobalScreen.addNativeMouseListener(window);
		GlobalScreen.addNativeMouseMotionListener(window);
		window.setVisible(true);
		window.setLocation(0, 0);
	}
}
