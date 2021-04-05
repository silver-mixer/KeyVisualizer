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
	private static List<Integer> pressedButtons = new ArrayList<Integer>();
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
	
	public static boolean isPressedButton(int button) {
		return pressedButtons.contains(button);
	}
	
	public static NativeKeyLayout[] getNativeKeyLayout(KVKey[] keys) {
		List<NativeKeyLayout> keyLayouts = new ArrayList<NativeKeyLayout>();
		for(KVKey key: keys) {
			if(keyMap.containsKey(key)) {
				keyLayouts.add(keyMap.get(key));
			}
		}
		return keyLayouts.toArray(new NativeKeyLayout[keyLayouts.size()]);
	}
	
	public static void initializeKeyMap(String os, boolean isJpKeyboard) {
		keyMap.clear();
		//Numeric Key
		keyMap.put(KVKey.KV_0, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_0, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_1, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_1, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_2, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_2, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_3, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_3, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_4, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_4, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_5, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_5, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_6, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_6, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_7, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_7, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_8, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_8, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_9, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_9, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
		//Alphabet Key
		keyMap.put(KVKey.KV_A, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_A, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_B, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_B, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_C, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_C, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_D, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_D, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_E, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_E, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_F, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_F, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_G, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_G, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_H, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_H, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_I, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_I, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_J, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_J, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_K, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_K, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_L, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_L, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_M, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_M, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_N, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_N, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_O, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_O, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_P, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_P, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_Q, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_Q, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_R, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_R, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_S, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_S, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_T, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_T, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_U, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_U, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_V, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_V, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_W, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_W, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_X, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_X, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_Y, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_Y, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_Z, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_Z, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
		//Function Keys
		keyMap.put(KVKey.KV_F1, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_F1, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_F2, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_F2, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_F3, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_F3, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_F4, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_F4, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_F5, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_F5, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_F6, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_F6, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_F7, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_F7, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_F8, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_F8, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_F9, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_F9, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_F10, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_F10, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_F11, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_F11, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_F12, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_F12, false), NativeKeyEvent.KEY_LOCATION_STANDARD));

		keyMap.put(KVKey.KV_PAUSE, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_PAUSE, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_PRINTSCREEN, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_PRINTSCREEN, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
		//Modifier Keys
		keyMap.put(KVKey.KV_LEFT_SHIFT, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_SHIFT, false), NativeKeyEvent.KEY_LOCATION_LEFT));
		keyMap.put(KVKey.KV_LEFT_CONTROL, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_CONTROL, false), NativeKeyEvent.KEY_LOCATION_LEFT));
		keyMap.put(KVKey.KV_LEFT_ALT, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_ALT, false), NativeKeyEvent.KEY_LOCATION_LEFT));
		keyMap.put(KVKey.KV_LEFT_WINDOWS, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_META, false), NativeKeyEvent.KEY_LOCATION_LEFT));
		keyMap.put(KVKey.KV_RIGHT_SHIFT, new NativeKeyLayout(new KeyContainer(0x0e36, false), NativeKeyEvent.KEY_LOCATION_RIGHT));
		keyMap.put(KVKey.KV_RIGHT_CONTROL, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_CONTROL, false), NativeKeyEvent.KEY_LOCATION_RIGHT));
		keyMap.put(KVKey.KV_RIGHT_ALT, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_ALT, false), NativeKeyEvent.KEY_LOCATION_RIGHT));
		keyMap.put(KVKey.KV_RIGHT_WINDOWS, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_META, false), NativeKeyEvent.KEY_LOCATION_RIGHT));
		//Lock Keys
		keyMap.put(KVKey.KV_NUM_LOCK, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_NUM_LOCK, false), NativeKeyEvent.KEY_LOCATION_NUMPAD));
		keyMap.put(KVKey.KV_CAPS_LOCK, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_CAPS_LOCK, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_SCROLL_LOCK, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_SCROLL_LOCK, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
		//Navigation Keys
		keyMap.put(KVKey.KV_ESCAPE, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_ESCAPE, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_CONTEXT_MENU, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_CONTEXT_MENU, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
		//Editing Keys
		keyMap.put(KVKey.KV_ENTER, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_ENTER, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_BACKSPACE, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_BACKSPACE, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_TAB, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_TAB, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
		keyMap.put(KVKey.KV_SPACE, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_SPACE, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
		//Numpad Keys
		keyMap.put(KVKey.KV_NUM_0, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_0, false), NativeKeyEvent.KEY_LOCATION_NUMPAD));
		keyMap.put(KVKey.KV_NUM_1, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_1, false), NativeKeyEvent.KEY_LOCATION_NUMPAD));
		keyMap.put(KVKey.KV_NUM_2, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_2, false), NativeKeyEvent.KEY_LOCATION_NUMPAD));
		keyMap.put(KVKey.KV_NUM_3, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_3, false), NativeKeyEvent.KEY_LOCATION_NUMPAD));
		keyMap.put(KVKey.KV_NUM_4, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_4, false), NativeKeyEvent.KEY_LOCATION_NUMPAD));
		keyMap.put(KVKey.KV_NUM_5, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_5, false), NativeKeyEvent.KEY_LOCATION_NUMPAD));
		keyMap.put(KVKey.KV_NUM_6, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_6, false), NativeKeyEvent.KEY_LOCATION_NUMPAD));
		keyMap.put(KVKey.KV_NUM_7, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_7, false), NativeKeyEvent.KEY_LOCATION_NUMPAD));
		keyMap.put(KVKey.KV_NUM_8, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_8, false), NativeKeyEvent.KEY_LOCATION_NUMPAD));
		keyMap.put(KVKey.KV_NUM_9, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_9, false), NativeKeyEvent.KEY_LOCATION_NUMPAD));
		keyMap.put(KVKey.KV_NUM_ENTER, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_ENTER, false), NativeKeyEvent.KEY_LOCATION_NUMPAD));
		keyMap.put(KVKey.KV_ADD, new NativeKeyLayout(new KeyContainer(0x0e4e, false), NativeKeyEvent.KEY_LOCATION_NUMPAD));
		keyMap.put(KVKey.KV_SUBTRACT, new NativeKeyLayout(new KeyContainer(0x0e4a, false), NativeKeyEvent.KEY_LOCATION_NUMPAD));
		keyMap.put(KVKey.KV_MULTIPLY, new NativeKeyLayout(new KeyContainer(0x0e37, false), NativeKeyEvent.KEY_LOCATION_NUMPAD));
		keyMap.put(KVKey.KV_DIVIDE, new NativeKeyLayout(new KeyContainer(0x0035, false), NativeKeyEvent.KEY_LOCATION_NUMPAD));
		keyMap.put(KVKey.KV_DECIMAL, new NativeKeyLayout(new KeyContainer(0x0053, false), NativeKeyEvent.KEY_LOCATION_NUMPAD));
		if(isJpKeyboard) {
			if(os.equals("linux")) {
				//Extended Keys
				keyMap.put(KVKey.KV_MINUS, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_MINUS, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
				keyMap.put(KVKey.KV_COMMA, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_COMMA, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
				keyMap.put(KVKey.KV_PERIOD, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_PERIOD, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
				keyMap.put(KVKey.KV_SLASH, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_SLASH, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
				keyMap.put(KVKey.KV_SEMICOLON, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_SEMICOLON, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
				keyMap.put(KVKey.KV_OPEN_BRACKET, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_CLOSE_BRACKET, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
				keyMap.put(KVKey.KV_CLOSE_BRACKET, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_BACK_SLASH, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
				keyMap.put(KVKey.KV_BACK_SLASH, new NativeKeyLayout(new KeyContainer(0x005c, true), NativeKeyEvent.KEY_LOCATION_STANDARD));
				//Navigation Keys
				keyMap.put(KVKey.KV_LEFT, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_LEFT, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
				keyMap.put(KVKey.KV_UP, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_UP, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
				keyMap.put(KVKey.KV_RIGHT, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_RIGHT, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
				keyMap.put(KVKey.KV_DOWN, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_DOWN, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
				keyMap.put(KVKey.KV_PAGE_UP, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_PAGE_UP, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
				keyMap.put(KVKey.KV_PAGE_DOWN, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_PAGE_DOWN, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
				keyMap.put(KVKey.KV_HOME, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_HOME, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
				keyMap.put(KVKey.KV_END, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_END, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
				//Editing Keys
				keyMap.put(KVKey.KV_INSERT, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_INSERT, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
				keyMap.put(KVKey.KV_DELETE, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_DELETE, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
				//Japanese Keys
				keyMap.put(KVKey.KV_HANKAKU_ZENKAKU, new NativeKeyLayout(new KeyContainer(0x0029, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
				keyMap.put(KVKey.KV_KATAKANA_HIRAGANA, new NativeKeyLayout(new KeyContainer(0xff27, true), NativeKeyEvent.KEY_LOCATION_STANDARD));
				keyMap.put(KVKey.KV_NON_CONVERSION, new NativeKeyLayout(new KeyContainer(0xffe3, true), NativeKeyEvent.KEY_LOCATION_STANDARD));
				keyMap.put(KVKey.KV_CONVERSION, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_KANJI, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
				//Japanese Extended Keys
				keyMap.put(KVKey.KV_CIRCUMFLEX, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_EQUALS, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
				keyMap.put(KVKey.KV_YEN, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_YEN, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
				keyMap.put(KVKey.KV_AT, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_OPEN_BRACKET, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
				keyMap.put(KVKey.KV_COLON, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_QUOTE, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
			}else if(os.equals("windows") || os.equals("mac")) {
				//Extended Keys
				keyMap.put(KVKey.KV_MINUS, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_MINUS, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
				keyMap.put(KVKey.KV_COMMA, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_COMMA, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
				keyMap.put(KVKey.KV_PERIOD, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_PERIOD, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
				keyMap.put(KVKey.KV_SLASH, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_SLASH, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
				keyMap.put(KVKey.KV_SEMICOLON, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_EQUALS, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
				keyMap.put(KVKey.KV_OPEN_BRACKET, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_OPEN_BRACKET, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
				keyMap.put(KVKey.KV_CLOSE_BRACKET, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_CLOSE_BRACKET, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
				keyMap.put(KVKey.KV_BACK_SLASH, new NativeKeyLayout(new KeyContainer(0x00e2, true), NativeKeyEvent.KEY_LOCATION_STANDARD));
				//Navigation Keys
				keyMap.put(KVKey.KV_LEFT, new NativeKeyLayout(new KeyContainer(0xe04b, false), NativeKeyEvent.KEY_LOCATION_NUMPAD));
				keyMap.put(KVKey.KV_UP, new NativeKeyLayout(new KeyContainer(0xe048, false), NativeKeyEvent.KEY_LOCATION_NUMPAD));
				keyMap.put(KVKey.KV_RIGHT, new NativeKeyLayout(new KeyContainer(0xe04d, false), NativeKeyEvent.KEY_LOCATION_NUMPAD));
				keyMap.put(KVKey.KV_DOWN, new NativeKeyLayout(new KeyContainer(0xe050, false), NativeKeyEvent.KEY_LOCATION_NUMPAD));
				keyMap.put(KVKey.KV_PAGE_UP, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_PAGE_UP, false), NativeKeyEvent.KEY_LOCATION_NUMPAD));
				keyMap.put(KVKey.KV_PAGE_DOWN, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_PAGE_DOWN, false), NativeKeyEvent.KEY_LOCATION_NUMPAD));
				keyMap.put(KVKey.KV_HOME, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_HOME, false), NativeKeyEvent.KEY_LOCATION_NUMPAD));
				keyMap.put(KVKey.KV_END, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_END, false), NativeKeyEvent.KEY_LOCATION_NUMPAD));
				//Editing Keys
				keyMap.put(KVKey.KV_INSERT, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_INSERT, false), NativeKeyEvent.KEY_LOCATION_NUMPAD));
				keyMap.put(KVKey.KV_DELETE, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_DELETE, false), NativeKeyEvent.KEY_LOCATION_NUMPAD));
				//Japanese Keys
				keyMap.put(KVKey.KV_HANKAKU_ZENKAKU, new NativeKeyLayout(new KeyContainer(0x00f4, true), NativeKeyEvent.KEY_LOCATION_STANDARD));
				keyMap.put(KVKey.KV_KATAKANA_HIRAGANA, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_HIRAGANA, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
				keyMap.put(KVKey.KV_NON_CONVERSION, new NativeKeyLayout(new KeyContainer(0x001d, true), NativeKeyEvent.KEY_LOCATION_STANDARD));
				keyMap.put(KVKey.KV_CONVERSION, new NativeKeyLayout(new KeyContainer(0x001c, true), NativeKeyEvent.KEY_LOCATION_STANDARD));
				//Japanese Extended Keys
				keyMap.put(KVKey.KV_CIRCUMFLEX, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_QUOTE, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
				keyMap.put(KVKey.KV_YEN, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_BACK_SLASH, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
				keyMap.put(KVKey.KV_AT, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_BACKQUOTE, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
				keyMap.put(KVKey.KV_COLON, new NativeKeyLayout(new KeyContainer(NativeKeyEvent.VC_SEMICOLON, false), NativeKeyEvent.KEY_LOCATION_STANDARD));
			}
		}
	}
	
	@Override
	public void nativeKeyPressed(NativeKeyEvent event) {
		boolean isRawCode = (event.getKeyCode() == 0);
		int keyCode = (isRawCode ? event.getRawCode() : event.getKeyCode());
		//Windows HANKAKU_ZENKAKU patch
		if(isRawCode && keyCode == 0x00f4)keyCode = 0x00f3;
		NativeKeyLayout keyLayout = new NativeKeyLayout(new KeyContainer(keyCode, isRawCode), event.getKeyLocation());
		if(!pressedKeys.contains(keyLayout)) {
			pressedKeys.add(keyLayout);
			if(KeyVisualizer.isDebug()) {
				System.out.println("<p:" + Integer.toHexString(keyCode) + ">kc=" + Integer.toHexString(event.getKeyCode()) + "/rc=" + Integer.toHexString(event.getRawCode()) + "/kl=" + event.getKeyLocation() + "/nkl=" + keyLayout.toString() + "/kt=" + NativeKeyEvent.getKeyText(event.getKeyCode()));
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
		boolean isRawCode = (event.getKeyCode() == 0);
		int keyCode = (isRawCode ? event.getRawCode() : event.getKeyCode());
		//Windows HANKAKU_ZENKAKU patch
		if(isRawCode && keyCode == 0x00f4)keyCode = 0x00f3;
		NativeKeyLayout keyLayout = new NativeKeyLayout(new KeyContainer(keyCode, isRawCode), event.getKeyLocation());
		pressedKeys.remove(keyLayout);
		if(KeyVisualizer.isDebug()) {
			System.out.println("<r:" + Integer.toHexString(keyCode) + ">kc=" + Integer.toHexString(event.getKeyCode()) + "/rc=" + Integer.toHexString(event.getRawCode()) + "/kl=" + event.getKeyLocation() + "/kt=" + NativeKeyEvent.getKeyText(event.getKeyCode()));
		}
		for(NativeInputListenerInterface listener: eventListeners.getListeners(NativeInputListenerInterface.class)) {
			((NativeInputListenerInterface)listener).changeKeyState();
		}
	}
	
	@Override
	public void nativeMousePressed(NativeMouseEvent event) {
		pressedButtons.add(event.getButton());
		if(KeyVisualizer.isDebug()) {
			System.out.println("<p>MB_" + event.getButton());
		}
		for(NativeInputListenerInterface listener: eventListeners.getListeners(NativeInputListenerInterface.class)) {
			((NativeInputListenerInterface)listener).changeButtonState();
		}
	}
	
	@Override
	public void nativeMouseReleased(NativeMouseEvent event) {
		pressedButtons.remove((Integer)event.getButton());
		if(KeyVisualizer.isDebug()) {
			System.out.println("<r>MB_" + event.getButton());
		}
		for(NativeInputListenerInterface listener: eventListeners.getListeners(NativeInputListenerInterface.class)) {
			((NativeInputListenerInterface)listener).changeButtonState();
		}
	}
	
	@Override
	public void nativeMouseClicked(NativeMouseEvent event) {}
	
	@Override
	public void nativeMouseDragged(NativeMouseEvent event) {}
	
	@Override
	public void nativeMouseMoved(NativeMouseEvent event) {}
}
