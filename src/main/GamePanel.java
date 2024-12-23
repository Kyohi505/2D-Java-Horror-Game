package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Player;
import object.SuperObject;
import scare.JumpScare;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable{
	
	//Screen Settings
	final int originalTileSize = 16;
	final int scale = 3;
	
	public final int tileSize = originalTileSize * scale;
	
	public final int maxScreenCol = 16;
	public final int maxScreenRow = 12;
	
	public final int screenWidth = tileSize * maxScreenCol;
	public final int screenHeight = tileSize * maxScreenRow;
	
	//World Settings
	public final int maxWorldCol = 50;
	public final int maxWorldRow = 50;
	
	//System
	KeyHandler keyH = new KeyHandler(this);
	TileManager tileM = new TileManager(this);
	public CollisionChecker collision = new CollisionChecker(this);
	public AssetSetter aSetter = new AssetSetter(this);
	public UI ui = new UI(this);
	public JumpScare scare = new JumpScare(this);
	
	//Sounds
	Sound music = new Sound();
	Sound se = new Sound();
	
	Thread gameThread;
	
	//Entity and Objects
	public Player player = new Player(this, keyH);
	public SuperObject obj[] = new SuperObject[25];

	//FPS
	int FPS = 60;
	
	//Game State
	public int gameState;
	public final int titleState = 0;
	public final int playState = 1;
	
	public GamePanel() {
		
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}
	
	public void setupGame() {
		aSetter.setObject();
		gameState = titleState;
	}
	
	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	@Override
	public void run() {
		
		double drawInterval = 1000000000/FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		
		while(gameThread != null) {
			
			currentTime = System.nanoTime();
			delta += (currentTime - lastTime)/ drawInterval;
			
			lastTime = currentTime;
			
			if(delta >= 1) {
				
				update();	
				repaint();
				
				delta--;
			}		
			
		}
		
	}
	
	public void update() {
		
		if(gameState == playState) {
			player.update();
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		//Title State
		if(gameState == titleState) {
			ui.draw(g2);
		}
		
		else {
			//Tile
			tileM.draw(g2);
			
			//Object
			for(int i = 0; i < obj.length; i++) {
				if(obj[i] != null) {
					obj[i].draw(g2, this);
				}
			}
			
			//Player
			player.draw(g2);
			
			//UI
			ui.draw(g2);
			
			scare.draw(g2);
			
			g2.dispose();
		}
		
	}
	
	public void playMusic(int i) {
		music.setFile(i);
		music.play();
		music.loop();
	}
	
	public void stopMusic() {
		music.stop();
	}
	
	public void playSE(int i) {
		se.setFile(i);
		se.play();
	}
}
