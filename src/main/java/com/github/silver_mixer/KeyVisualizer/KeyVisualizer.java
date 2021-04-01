package com.github.silver_mixer.KeyVisualizer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

public class KeyVisualizer extends JWindow{
	private static final long serialVersionUID = 1L;
	private static boolean isDebug = false;
	private RenderPanel renderPanel;
	private boolean isMouseEntered = false;
	//Transparent window patch
	private static boolean enableTrasparentPatch = !System.getProperty("os.name").toLowerCase().matches(".*(windows|mac).*");
	private static BufferStrategy bs;
	
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
		String kvcFile = "+Default.kvc";
		for(int i = 0; i < args.length; i++) {
			if(args[i].equals("-debug")) {
				isDebug = true;
				System.out.println("Debug mode has been enabled.");
			}else if(args[i].equals("-config")) {
				i++;
				if(i != args.length) {
					kvcFile = args[i];
				}
			}
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
		KeyVisualizer window = new KeyVisualizer(kvcFile);
		window.setVisible(true);
		window.setLocation(0, 0);
		if(enableTrasparentPatch) {
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					window.createBufferStrategy(2);
					bs = window.getBufferStrategy();
				}
			});
		}
	}

	public KeyVisualizer(String kvcFile) {
		setAlwaysOnTop(true);
		setBackground(new Color(255, 255, 255, 0));
		setLayout(null);
		setBounds(1, 1, 640, 480);
		
		WindowDragListener windowDragListener = new WindowDragListener(this);
		addMouseListener(windowDragListener);
		addMouseMotionListener(windowDragListener);
		
		KeyVisualizerConfig config = new KeyVisualizerConfig();
		if(kvcFile.startsWith("+")) {
			InputStream stream = this.getClass().getResourceAsStream("assets/" + kvcFile.substring(1));
			if(stream == null) {
				JOptionPane.showMessageDialog(null, "プリセットの読み込みに失敗しました。\nデフォルトプリセットを読み込みます。", "KeyVisualizer - 読み込みエラー", JOptionPane.ERROR_MESSAGE);
				stream = this.getClass().getResourceAsStream("assets/Default.kvc");
				if(stream == null) {
					JOptionPane.showMessageDialog(null, "デフォルトプリセットの読み込みに失敗しました。", "KeyVisualizer - 起動エラー", JOptionPane.ERROR_MESSAGE);
					System.exit(1);
				}
			}
			config.load(stream);
		}else {
			try {
				config.load(new FileInputStream(new File(kvcFile)));
			}catch(FileNotFoundException e) {
				JOptionPane.showMessageDialog(null, "指定されたパスにファイルがありません。\nデフォルトプリセットを読み込みます。\n\nパス: " + kvcFile, "KeyVisualizer - 読み込みエラー", JOptionPane.WARNING_MESSAGE);
				InputStream stream = this.getClass().getResourceAsStream("assets/Default.kvc");
				if(stream == null) {
					JOptionPane.showMessageDialog(null, "デフォルトプリセットの読み込みに失敗しました。", "KeyVisualizer - 起動エラー", JOptionPane.ERROR_MESSAGE);
					System.exit(1);
				}
			}
		}
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
		render();
	}
	
	public void render() {
		if(!enableTrasparentPatch) {
			renderPanel.repaint();
		}else {
			try {
				do {
					do {
						Graphics g = bs.getDrawGraphics();
						paintComponents(g);
						g.dispose();
					}while(bs.contentsRestored());
					bs.show();
				}while(bs.contentsLost());
				Toolkit.getDefaultToolkit().sync();
			}catch(IllegalStateException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static String getOS() {
		String os = System.getProperty("os.name").toLowerCase();
		if(os.contains("windows")) {
			return "windows";
		}else if(os.contains("mac")) {
			return "mac";
		}else {
			return "linux";
		}
	}
	
	public static boolean isDebug() {
		return isDebug;
	}
}
