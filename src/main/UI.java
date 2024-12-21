package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.DecimalFormat;

import javax.imageio.ImageIO;

public class UI {
	
	GamePanel gp;
	Font arial_40, arial_80B;
	public boolean gameFinished = false;
	
	DecimalFormat dFormat = new DecimalFormat("#0.00");
	double playTime;
	public boolean timerOn = false;
	
	public BufferedImage image, key, cross;
	
	public int commandNum = 0;

	public boolean jumpScare = false;
	int jumpscareCounter = 0;
	
	public int titleScreenState = 0;
	public boolean canPlay;
	int continueCounter = 0;
	
	public UI(GamePanel gp) {
		this.gp = gp;
		
		arial_40 = new Font("Arial", Font.PLAIN, 40);
		arial_80B = new Font("Arial", Font.BOLD, 80);
		
		getCreepFace();
	}
	
	public void getCreepFace() {
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/face.png"));
			key = ImageIO.read(getClass().getResourceAsStream("/objects/key.png"));
			cross = ImageIO.read(getClass().getResourceAsStream("/objects/cross.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void draw(Graphics2D g2) {
		
		if(gp.gameState == gp.titleState) {
			drawTitleScreen(g2);
		}
		
		if(gameFinished == true) {
			
			g2.setFont(arial_40);
			g2.setColor(Color.white);
			
			String text;
			int textLength;
			int x;
			int y;
			
			text = "You Survived the Night!";
			textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
			x = gp.screenWidth/2 - textLength/2;
			y = gp.screenHeight/2 - (gp.tileSize*3);
			g2.drawString(text, x, y);
			
			text = "Time wasted: " + dFormat.format(playTime) + " seconds of your life";
			textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
			x = gp.screenWidth/2 - textLength/2;
			y = gp.screenHeight/2 + (gp.tileSize*4);
			g2.drawString(text, x, y);
			
			g2.setFont(arial_80B);
			g2.setColor(Color.yellow);
			text = "Good Job!";
			textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
			x = gp.screenWidth/2 - textLength/2;
			y = gp.screenHeight/2 + (gp.tileSize*2);
			g2.drawString(text, x, y);
			
			gp.gameThread = null;
			
		}
		
		if(timerOn == true) {
			g2.setFont(arial_40);
			g2.setColor(Color.white);
			
			playTime  += (double)1/60;
			g2.drawString("Time: " + dFormat.format(playTime), gp.tileSize*11, 65);
		}
		if(gameFinished == true) {
			timerOn = false;
		}
		
		if(jumpScare ==true) {
			int x = gp.screenWidth/2 - (gp.tileSize*16)/2;
			int y = 0;
			g2.drawImage(image, x, y, gp.tileSize*18, gp.tileSize*12, null);
			jumpscareCounter++;
		}
		if(jumpscareCounter == 10) {
			jumpscareCounter = 0;
			jumpScare = false;
		}
		
	}
	
	public void drawTitleScreen(Graphics2D g2) {
		String text;
		int x, y;
		int textLength;
		
		if(titleScreenState == 0) {
			g2.setFont(arial_80B);
			text = "GO TO BED";
			textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
			x = gp.screenWidth/2 - textLength/2;
			y = gp.tileSize*3;
			g2.setColor(Color.RED);
			g2.drawString(text, x, y);
			
			//Smile face
			x = gp.screenWidth/2 - (gp.tileSize*4)/2;
			y += gp.tileSize;
			g2.drawImage(image, x, y, gp.tileSize*4, gp.tileSize*4, null);
			
			//menu
			g2.setFont(arial_40);
			g2.setColor(Color.white);
			text = "START";
			textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
			x = gp.screenWidth/2 - textLength/2;
			y += gp.tileSize*6;
			g2.drawString(text, x, y);
			
			if(commandNum == 0) {
				g2.drawString(">", x- gp.tileSize, y);
			}
			
			text = "QUIT";
			textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
			x = gp.screenWidth/2 - textLength/2;
			y += gp.tileSize;
			g2.drawString(text, x, y);
			if(commandNum == 1) {
				g2.drawString(">", x- gp.tileSize, y);
			}
		}
		else if(titleScreenState == 1) {
			
			g2.setFont(arial_40);
			g2.setColor(Color.white);
			text = "YOU ARE LOST IN THE FOREST";
			textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
			x = gp.screenWidth/2 - textLength/2;
			y = gp.tileSize*3;
			g2.drawString(text, x, y);
			
			g2.setFont(arial_40);
			text = "GO FIND YOUR WAY HOME";
			textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
			x = gp.screenWidth/2 - textLength/2;
			y += gp.tileSize;
			g2.drawString(text, x, y);
			
			text = "Controls: WASD/ARROW KEYS";
			textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
			x = gp.screenWidth/2 - textLength/2;
			y += gp.tileSize*2;
			g2.drawString(text, x, y);
			
			x = 25;
			y += gp.tileSize;
			g2.drawImage(gp.player.down1, x, y, gp.tileSize*4, gp.tileSize*4, null);
			
			x = 200;
			y = 340;
			g2.drawImage(key, x, y, gp.tileSize*4, gp.tileSize*4, null);
			
			text = "Find Keys!";
			x = 100;
			y = 560;
			g2.drawString(text, x, y);
			
			x = 500;
			y = 340;
			g2.drawImage(cross, x, y, gp.tileSize*4, gp.tileSize*4, null);
			
			text = "Cross boosts speed!";
			x = 400;
			y = 560;
			g2.drawString(text, x, y);
			
			continueCounter++;
			
			if(continueCounter == 30) {
				continueCounter = 0;
				canPlay = true;
			}
		}
	}
	
	
}
