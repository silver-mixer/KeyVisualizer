package com.github.silver_mixer.KeyVisualizer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferStrategy;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

public class KeyVisualizer extends JFrame{
	private static final long serialVersionUID = 1L;
	private static boolean isDebug = false, useSystemWindow = true;
	private static String loadedKvcFile;
	private static Insets frameInsets;
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
		JFrame.setDefaultLookAndFeelDecorated(!useSystemWindow);
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
		KeyVisualizer frame = this;
		setTitle("Key Visualizer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setAlwaysOnTop(true);
		setBackground(new Color(255, 255, 255, (useSystemWindow ? 255 : 0)));
		setLayout(null);
		setBounds(1, 1, 640, 480);
		
		WindowDragListener windowDragListener = new WindowDragListener(this);
		addMouseListener(windowDragListener);
		addMouseMotionListener(windowDragListener);
		
		JPopupMenu popupMenu = new JPopupMenu();
		JCheckBoxMenuItem transparentModeItem = new JCheckBoxMenuItem("透過モード", !useSystemWindow);
		transparentModeItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				useSystemWindow = !transparentModeItem.isSelected();
				int x = frame.getX(), y = frame.getY();
				if(!useSystemWindow) {
					Insets insets = frame.getInsets();
					x += insets.left;
					y += insets.top;
					if(frameInsets == null)frameInsets = insets;
				}
				frame.dispose();
				JFrame.setDefaultLookAndFeelDecorated(!useSystemWindow);
				KeyVisualizer window = new KeyVisualizer(loadedKvcFile);
				window.setVisible(true);
				if(useSystemWindow) {
					Insets insets;
					if(frameInsets == null) {
						insets = window.getInsets();
					}else {
						insets = frameInsets;
					}
					x -= insets.left;
					y -= insets.top;
				}
				window.setLocation(x, y);
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
		});
		popupMenu.add(transparentModeItem);
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if(e.isPopupTrigger()) {
					popupMenu.show(e.getComponent(), e.getX(), e.getY());
				}
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				if(e.isPopupTrigger()) {
					popupMenu.show(e.getComponent(), e.getX(), e.getY());
				}
			}
		});
		
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
		loadedKvcFile = kvcFile;
		
		if(useSystemWindow) {
			getContentPane().setPreferredSize(new Dimension(config.getWidth(), config.getHeight()));
			pack();
		}else {
			getRootPane().setWindowDecorationStyle(JRootPane.NONE);
			setSize(config.getWidth(), config.getHeight());
		}
		
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
	
	public static boolean isSystemWindow() {
		return useSystemWindow;
	}
}
