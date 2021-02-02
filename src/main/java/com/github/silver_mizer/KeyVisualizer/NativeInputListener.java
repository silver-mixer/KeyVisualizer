package com.github.silver_mizer.KeyVisualizer;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.EventListenerList;

import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseListener;
import org.jnativehook.mouse.NativeMouseMotionListener;

public class NativeInputListener implements NativeKeyListener, NativeMouseListener, NativeMouseMotionListener{
	private static final NativeInputListener nativeInputListener = new NativeInputListener();
	private static List<Integer> pressedKeys = new ArrayList<Integer>();
	private static EventListenerList eventListeners = new EventListenerList();
	
	private NativeInputListener() {}
	
	public static NativeInputListener getInstance() {
		return nativeInputListener;
	}
	
	public static boolean isPressedKey(int keyCode) {
		return pressedKeys.contains(keyCode);
	}

	public static void addListener(NativeInputListenerInterface listener) {
		eventListeners.add(NativeInputListenerInterface.class, listener);
	}
	
	public static void removeListener(NativeInputListenerInterface listener) {
		eventListeners.remove(NativeInputListenerInterface.class, listener);
	}
	
	@Override
	public void nativeKeyPressed(NativeKeyEvent event) {
		int id = (event.getKeyCode() != 0 ? event.getKeyCode() : event.getRawCode());
		if(!pressedKeys.contains(id)) {
			pressedKeys.add(id);
			System.out.println("<" + (event.getKeyLocation()) + ">" + event.getKeyCode() + "/" + event.getRawCode() + "/" + NativeKeyEvent.getKeyText(event.getKeyCode()));
			for(NativeInputListenerInterface listener: eventListeners.getListeners(NativeInputListenerInterface.class)) {
				((NativeInputListenerInterface)listener).changeKeyState();
			}
		}
	}
	
	@Override
	public void nativeKeyTyped(NativeKeyEvent event) {}
	
	@Override
	public void nativeKeyReleased(NativeKeyEvent event) {
		int id = (event.getKeyCode() != 0 ? event.getKeyCode() : event.getRawCode());
		pressedKeys.remove(Integer.valueOf(id));
		for(NativeInputListenerInterface listener: eventListeners.getListeners(NativeInputListenerInterface.class)) {
			((NativeInputListenerInterface)listener).changeKeyState();
		}
	}
	
	@Override
	public void nativeMousePressed(NativeMouseEvent event) {}
	
	@Override
	public void nativeMouseClicked(NativeMouseEvent event) {}
	
	@Override
	public void nativeMouseReleased(NativeMouseEvent event) {}
	
	@Override
	public void nativeMouseDragged(NativeMouseEvent event) {}
	
	@Override
	public void nativeMouseMoved(NativeMouseEvent event) {}
}
