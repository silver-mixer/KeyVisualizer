package com.github.silver_mixer.KeyVisualizer;

import java.util.EventListener;

public interface NativeInputListenerInterface extends EventListener{

	public void changeKeyState();
	
	public void changeButtonState();
}
