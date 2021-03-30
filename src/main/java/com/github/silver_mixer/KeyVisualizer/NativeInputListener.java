package com.github.silver_mixer.KeyVisualizer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.event.EventListenerList;

import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseListener;
import org.jnativehook.mouse.NativeMouseMotionListener;

public class NativeInputListener implements NativeKeyListener, NativeMouseListener, NativeMouseMotionListener{
	private static final NativeInputListener nativeInputListener = new NativeInputListener();
	private static List<NativeKeyLayout> pressedKeys = new ArrayList<NativeKeyLayout>();
	private static EventListenerList eventListeners = new EventListenerList();
	private static Map<KVKey, NativeKeyLayout> keyMap = new HashMap<KVKey, NativeKeyLayout>();
	
	private NativeInputListener() {}
	
	public static NativeInputListener getInstance() {
		return nativeInputListener;
	}

	public static void addListener(NativeInputListenerInterface listener) {
		eventListeners.add(NativeInputListenerInterface.class, listener);
	}
	
	public static void removeListener(NativeInputListenerInterface listener) {
		eventListeners.remove(NativeInputListenerInterface.class, listener);
	}
	
	public static boolean isPressedKey(NativeKeyLayout keyLayout) {
		return pressedKeys.contains(keyLayout);
	}
	
	public static NativeKeyLayout[] getNativeKeyLayout(KVKey key) {
		if(keyMap.containsKey(key)) {
			return new NativeKeyLayout[] {keyMap.get(key)};
		}else {
			return new NativeKeyLayout[] {};
		}
	}
	
	public static void initializeKeyMap(String os, boolean isJpKeyboard) {
		keyMap.clear();
		//Numeric Key
		keyMap.put(KVKey.KV_0, new NativeKeyLayout(NativeKeyEvent.VC_0, NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_1, new NativeKeyLayout(NativeKeyEvent.VC_1, NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_2, new NativeKeyLayout(NativeKeyEvent.VC_2, NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_3, new NativeKeyLayout(NativeKeyEvent.VC_3, NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_4, new NativeKeyLayout(NativeKeyEvent.VC_4, NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_5, new NativeKeyLayout(NativeKeyEvent.VC_5, NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_6, new NativeKeyLayout(NativeKeyEvent.VC_6, NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_7, new NativeKeyLayout(NativeKeyEvent.VC_7, NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_8, new NativeKeyLayout(NativeKeyEvent.VC_8, NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_9, new NativeKeyLayout(NativeKeyEvent.VC_9, NativeKeyEvent.KEY_LOCATION_STANDARD));
		//Alphabet Key
		keyMap.put(KVKey.KV_A, new NativeKeyLayout(NativeKeyEvent.VC_A, NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_B, new NativeKeyLayout(NativeKeyEvent.VC_B, NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_C, new NativeKeyLayout(NativeKeyEvent.VC_C, NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_D, new NativeKeyLayout(NativeKeyEvent.VC_D, NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_E, new NativeKeyLayout(NativeKeyEvent.VC_E, NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_F, new NativeKeyLayout(NativeKeyEvent.VC_F, NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_G, new NativeKeyLayout(NativeKeyEvent.VC_G, NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_H, new NativeKeyLayout(NativeKeyEvent.VC_H, NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_I, new NativeKeyLayout(NativeKeyEvent.VC_I, NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_J, new NativeKeyLayout(NativeKeyEvent.VC_J, NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_K, new NativeKeyLayout(NativeKeyEvent.VC_K, NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_L, new NativeKeyLayout(NativeKeyEvent.VC_L, NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_M, new NativeKeyLayout(NativeKeyEvent.VC_M, NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_N, new NativeKeyLayout(NativeKeyEvent.VC_N, NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_O, new NativeKeyLayout(NativeKeyEvent.VC_O, NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_P, new NativeKeyLayout(NativeKeyEvent.VC_P, NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_Q, new NativeKeyLayout(NativeKeyEvent.VC_Q, NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_R, new NativeKeyLayout(NativeKeyEvent.VC_R, NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_S, new NativeKeyLayout(NativeKeyEvent.VC_S, NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_T, new NativeKeyLayout(NativeKeyEvent.VC_T, NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_U, new NativeKeyLayout(NativeKeyEvent.VC_U, NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_V, new NativeKeyLayout(NativeKeyEvent.VC_V, NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_W, new NativeKeyLayout(NativeKeyEvent.VC_W, NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_X, new NativeKeyLayout(NativeKeyEvent.VC_X, NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_Y, new NativeKeyLayout(NativeKeyEvent.VC_Y, NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_Z, new NativeKeyLayout(NativeKeyEvent.VC_Z, NativeKeyEvent.KEY_LOCATION_STANDARD));
		//Function Keys
		keyMap.put(KVKey.KV_F1, new NativeKeyLayout(NativeKeyEvent.VC_F1, NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_F2, new NativeKeyLayout(NativeKeyEvent.VC_F2, NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_F3, new NativeKeyLayout(NativeKeyEvent.VC_F3, NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_F4, new NativeKeyLayout(NativeKeyEvent.VC_F4, NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_F5, new NativeKeyLayout(NativeKeyEvent.VC_F5, NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_F6, new NativeKeyLayout(NativeKeyEvent.VC_F6, NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_F7, new NativeKeyLayout(NativeKeyEvent.VC_F7, NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_F8, new NativeKeyLayout(NativeKeyEvent.VC_F8, NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_F9, new NativeKeyLayout(NativeKeyEvent.VC_F9, NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_F10, new NativeKeyLayout(NativeKeyEvent.VC_F10, NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_F11, new NativeKeyLayout(NativeKeyEvent.VC_F11, NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_F12, new NativeKeyLayout(NativeKeyEvent.VC_F12, NativeKeyEvent.KEY_LOCATION_STANDARD));

		keyMap.put(KVKey.KV_PAUSE, new NativeKeyLayout(NativeKeyEvent.VC_PAUSE, NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_PRINTSCREEN, new NativeKeyLayout(NativeKeyEvent.VC_PRINTSCREEN, NativeKeyEvent.KEY_LOCATION_STANDARD));
		//Modifier Keys
		keyMap.put(KVKey.KV_LEFT_SHIFT, new NativeKeyLayout(NativeKeyEvent.VC_SHIFT, NativeKeyEvent.KEY_LOCATION_LEFT));
		keyMap.put(KVKey.KV_LEFT_CONTROL, new NativeKeyLayout(NativeKeyEvent.VC_CONTROL, NativeKeyEvent.KEY_LOCATION_LEFT));
		keyMap.put(KVKey.KV_LEFT_ALT, new NativeKeyLayout(NativeKeyEvent.VC_ALT, NativeKeyEvent.KEY_LOCATION_LEFT));
		keyMap.put(KVKey.KV_LEFT_WINDOWS, new NativeKeyLayout(NativeKeyEvent.VC_META, NativeKeyEvent.KEY_LOCATION_LEFT));
		keyMap.put(KVKey.KV_RIGHT_SHIFT, new NativeKeyLayout(0x0e36, NativeKeyEvent.KEY_LOCATION_RIGHT));
		keyMap.put(KVKey.KV_RIGHT_CONTROL, new NativeKeyLayout(NativeKeyEvent.VC_CONTROL, NativeKeyEvent.KEY_LOCATION_RIGHT));
		keyMap.put(KVKey.KV_RIGHT_ALT, new NativeKeyLayout(NativeKeyEvent.VC_ALT, NativeKeyEvent.KEY_LOCATION_RIGHT));
		keyMap.put(KVKey.KV_RIGHT_WINDOWS, new NativeKeyLayout(NativeKeyEvent.VC_META, NativeKeyEvent.KEY_LOCATION_RIGHT));
		//Lock Keys
		keyMap.put(KVKey.KV_NUM_LOCK, new NativeKeyLayout(NativeKeyEvent.VC_NUM_LOCK, NativeKeyEvent.KEY_LOCATION_NUMPAD));
		keyMap.put(KVKey.KV_CAPS_LOCK, new NativeKeyLayout(NativeKeyEvent.VC_CAPS_LOCK, NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_SCROLL_LOCK, new NativeKeyLayout(NativeKeyEvent.VC_SCROLL_LOCK, NativeKeyEvent.KEY_LOCATION_STANDARD));
		//Navigation Keys
		keyMap.put(KVKey.KV_LEFT, new NativeKeyLayout(NativeKeyEvent.VC_LEFT, NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_UP, new NativeKeyLayout(NativeKeyEvent.VC_UP, NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_RIGHT, new NativeKeyLayout(NativeKeyEvent.VC_RIGHT, NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_DOWN, new NativeKeyLayout(NativeKeyEvent.VC_DOWN, NativeKeyEvent.KEY_LOCATION_STANDARD));

		keyMap.put(KVKey.KV_PAGE_UP, new NativeKeyLayout(NativeKeyEvent.VC_PAGE_UP, NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_PAGE_DOWN, new NativeKeyLayout(NativeKeyEvent.VC_PAGE_DOWN, NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_HOME, new NativeKeyLayout(NativeKeyEvent.VC_HOME, NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_END, new NativeKeyLayout(NativeKeyEvent.VC_END, NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_ESCAPE, new NativeKeyLayout(NativeKeyEvent.VC_ESCAPE, NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_CONTEXT_MENU, new NativeKeyLayout(NativeKeyEvent.VC_CONTEXT_MENU, NativeKeyEvent.KEY_LOCATION_STANDARD));
		//Editing Keys
		keyMap.put(KVKey.KV_ENTER, new NativeKeyLayout(NativeKeyEvent.VC_ENTER, NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_BACKSPACE, new NativeKeyLayout(NativeKeyEvent.VC_BACKSPACE, NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_INSERT, new NativeKeyLayout(NativeKeyEvent.VC_INSERT, NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_DELETE, new NativeKeyLayout(NativeKeyEvent.VC_DELETE, NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_TAB, new NativeKeyLayout(NativeKeyEvent.VC_TAB, NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_SPACE, new NativeKeyLayout(NativeKeyEvent.VC_SPACE, NativeKeyEvent.KEY_LOCATION_STANDARD));
		//Numpad Keys
		keyMap.put(KVKey.KV_NUM_0, new NativeKeyLayout(NativeKeyEvent.VC_0, NativeKeyEvent.KEY_LOCATION_NUMPAD));
		keyMap.put(KVKey.KV_NUM_1, new NativeKeyLayout(NativeKeyEvent.VC_1, NativeKeyEvent.KEY_LOCATION_NUMPAD));
		keyMap.put(KVKey.KV_NUM_2, new NativeKeyLayout(NativeKeyEvent.VC_2, NativeKeyEvent.KEY_LOCATION_NUMPAD));
		keyMap.put(KVKey.KV_NUM_3, new NativeKeyLayout(NativeKeyEvent.VC_3, NativeKeyEvent.KEY_LOCATION_NUMPAD));
		keyMap.put(KVKey.KV_NUM_4, new NativeKeyLayout(NativeKeyEvent.VC_4, NativeKeyEvent.KEY_LOCATION_NUMPAD));
		keyMap.put(KVKey.KV_NUM_5, new NativeKeyLayout(NativeKeyEvent.VC_5, NativeKeyEvent.KEY_LOCATION_NUMPAD));
		keyMap.put(KVKey.KV_NUM_6, new NativeKeyLayout(NativeKeyEvent.VC_6, NativeKeyEvent.KEY_LOCATION_NUMPAD));
		keyMap.put(KVKey.KV_NUM_7, new NativeKeyLayout(NativeKeyEvent.VC_7, NativeKeyEvent.KEY_LOCATION_NUMPAD));
		keyMap.put(KVKey.KV_NUM_8, new NativeKeyLayout(NativeKeyEvent.VC_8, NativeKeyEvent.KEY_LOCATION_NUMPAD));
		keyMap.put(KVKey.KV_NUM_9, new NativeKeyLayout(NativeKeyEvent.VC_9, NativeKeyEvent.KEY_LOCATION_NUMPAD));
		keyMap.put(KVKey.KV_NUM_ENTER, new NativeKeyLayout(NativeKeyEvent.VC_ENTER, NativeKeyEvent.KEY_LOCATION_NUMPAD));
		keyMap.put(KVKey.KV_ADD, new NativeKeyLayout(0x0e4e, NativeKeyEvent.KEY_LOCATION_NUMPAD));
		keyMap.put(KVKey.KV_SUBTRACT, new NativeKeyLayout(0x0e4a, NativeKeyEvent.KEY_LOCATION_NUMPAD));
		keyMap.put(KVKey.KV_MULTIPLY, new NativeKeyLayout(0x0e37, NativeKeyEvent.KEY_LOCATION_NUMPAD));
		keyMap.put(KVKey.KV_DIVIDE, new NativeKeyLayout(0x0035, NativeKeyEvent.KEY_LOCATION_NUMPAD));
		keyMap.put(KVKey.KV_DECIMAL, new NativeKeyLayout(0x0053, NativeKeyEvent.KEY_LOCATION_NUMPAD));
		if(isJpKeyboard) {
			if(os.equals("linux")) {
				//Extended Keys
				keyMap.put(KVKey.KV_MINUS, new NativeKeyLayout(NativeKeyEvent.VC_MINUS, NativeKeyEvent.KEY_LOCATION_STANDARD));
				keyMap.put(KVKey.KV_COMMA, new NativeKeyLayout(NativeKeyEvent.VC_COMMA, NativeKeyEvent.KEY_LOCATION_STANDARD));
				keyMap.put(KVKey.KV_PERIOD, new NativeKeyLayout(NativeKeyEvent.VC_PERIOD, NativeKeyEvent.KEY_LOCATION_STANDARD));
				keyMap.put(KVKey.KV_SLASH, new NativeKeyLayout(NativeKeyEvent.VC_SLASH, NativeKeyEvent.KEY_LOCATION_STANDARD));
				keyMap.put(KVKey.KV_SEMICOLON, new NativeKeyLayout(NativeKeyEvent.VC_SEMICOLON, NativeKeyEvent.KEY_LOCATION_STANDARD));
				keyMap.put(KVKey.KV_OPEN_BRACKET, new NativeKeyLayout(NativeKeyEvent.VC_CLOSE_BRACKET, NativeKeyEvent.KEY_LOCATION_STANDARD));
				keyMap.put(KVKey.KV_CLOSE_BRACKET, new NativeKeyLayout(NativeKeyEvent.VC_BACK_SLASH, NativeKeyEvent.KEY_LOCATION_STANDARD));
				keyMap.put(KVKey.KV_BACK_SLASH, new NativeKeyLayout(0x005c, NativeKeyEvent.KEY_LOCATION_STANDARD));
				//Japanese Keys
				keyMap.put(KVKey.KV_HANKAKU_ZENKAKU, new NativeKeyLayout(0x0029, NativeKeyEvent.KEY_LOCATION_STANDARD));
				keyMap.put(KVKey.KV_KATAKANA_HIRAGANA, new NativeKeyLayout(0xff27, NativeKeyEvent.KEY_LOCATION_STANDARD));
				keyMap.put(KVKey.KV_NON_CONVERSION, new NativeKeyLayout(0xffe3, NativeKeyEvent.KEY_LOCATION_STANDARD));
				keyMap.put(KVKey.KV_CONVERSION, new NativeKeyLayout(NativeKeyEvent.VC_KANJI, NativeKeyEvent.KEY_LOCATION_STANDARD));
				//Japanese Extended Keys
				keyMap.put(KVKey.KV_CIRCUMFLEX, new NativeKeyLayout(NativeKeyEvent.VC_EQUALS, NativeKeyEvent.KEY_LOCATION_STANDARD));
				keyMap.put(KVKey.KV_YEN, new NativeKeyLayout(NativeKeyEvent.VC_YEN, NativeKeyEvent.KEY_LOCATION_STANDARD));
				keyMap.put(KVKey.KV_AT, new NativeKeyLayout(NativeKeyEvent.VC_OPEN_BRACKET, NativeKeyEvent.KEY_LOCATION_STANDARD));
				keyMap.put(KVKey.KV_COLON, new NativeKeyLayout(NativeKeyEvent.VC_QUOTE, NativeKeyEvent.KEY_LOCATION_STANDARD));
			}
		}
	}
	
	@Override
	public void nativeKeyPressed(NativeKeyEvent event) {
		int id = (event.getKeyCode() != 0 ? event.getKeyCode() : event.getRawCode());
		NativeKeyLayout keyLayout = new NativeKeyLayout(id, event.getKeyLocation());
		if(!pressedKeys.contains(keyLayout)) {
			pressedKeys.add(keyLayout);
			if(KeyVisualizer.isDebug()) {
				System.out.println("<p:" + Integer.toHexString(id) + ">kc=" + Integer.toHexString(event.getKeyCode()) + "/rc=" + Integer.toHexString(event.getRawCode()) + "/kl=" + event.getKeyLocation() + "/nkl=" + keyLayout.toString() + "/kt=" + NativeKeyEvent.getKeyText(event.getKeyCode()));
			}
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
		pressedKeys.remove(new NativeKeyLayout(id, event.getKeyLocation()));
		if(KeyVisualizer.isDebug()) {
			System.out.println("<r:" + Integer.toHexString(id) + ">kc=" + Integer.toHexString(event.getKeyCode()) + "/rc=" + Integer.toHexString(event.getRawCode()) + "/kl=" + event.getKeyLocation() + "/kt=" + NativeKeyEvent.getKeyText(event.getKeyCode()));
		}
		for(NativeInputListenerInterface listener: eventListeners.getListeners(NativeInputListenerInterface.class)) {
			((NativeInputListenerInterface)listener).changeKeyState();
		}
	}
	
	@Override
	public void nativeMousePressed(NativeMouseEvent event) {
		if(KeyVisualizer.isDebug()) {
			System.out.println("<p>MB_" + event.getButton());
		}
	}
	
	@Override
	public void nativeMouseReleased(NativeMouseEvent event) {
		if(KeyVisualizer.isDebug()) {
			System.out.println("<r>MB_" + event.getButton());
		}}
	
	@Override
	public void nativeMouseClicked(NativeMouseEvent event) {}
	
	@Override
	public void nativeMouseDragged(NativeMouseEvent event) {}
	
	@Override
	public void nativeMouseMoved(NativeMouseEvent event) {}
}
