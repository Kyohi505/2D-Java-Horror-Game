package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity{
	
	GamePanel gp;
	KeyHandler keyH;
	
	public final int screenX;
	public final int screenY;
	
	int hasHouseKey = 0;
	int hasBlueKey = 0;
	int hasGreenKey = 0;
	int hasRedKey = 0;
	
	public Player(GamePanel gp, KeyHandler keyH) {
		
		this.gp = gp;
		this.keyH = keyH;
		
		screenX = gp.screenWidth/2 - (gp.tileSize/2);
		screenY = gp.screenHeight/2 - (gp.tileSize/2);
		
		//collision
		solidArea = new Rectangle();
		solidArea.x = 8;
		solidArea.y = 16;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		solidArea.width = 32;
		solidArea.height = 32;
		
		setDefaultValues();
		getPlayerImage();
	}
	
	public void setDefaultValues() {
		
		worldX = gp.tileSize * 28;
		worldY = gp.tileSize * 18;
		speed = 4;
		direction = "down";
	}
	
	public void getPlayerImage() {
		try {
			
			up1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_1.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_2.png"));
			
			down1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_1.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_2.png"));
			
			left1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_1.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_2.png"));
			
			right1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_2.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void update() {
		
		if(keyH.upPress == true || keyH.downPress == true || 
				keyH.leftPress == true || keyH.rightPress == true) {
			
			if(keyH.upPress == true) {
				direction = "up";
			}
			else if(keyH.downPress == true) {
				direction = "down";
			}
			else if(keyH.leftPress == true) {
				direction = "left";
			}
			else if(keyH.rightPress == true) {
				direction = "right";
			}
			
			//Check tile collision
			collisionOn = false;
			gp.collision.checkTile(this);
			
			//Item Collision
			int objIndex = gp.collision.checkObject(this, true);
			pickUpObject(objIndex);
			
			//if collision false let player move
			if(collisionOn == false) {
				
				switch(direction) {
				case "up":
					worldY -= speed;
					break;
					
				case "down":
					worldY += speed;
					break;
					
				case "left":
					worldX -= speed;
					break;
					
				case "right":
					worldX += speed;
					break;
					
				}
			}
			
			
			spriteCounter++;
			if(spriteCounter > 12) {
				if(spriteNum == 1) {
					spriteNum = 2;
				}
				
				else if(spriteNum == 2) {
					spriteNum = 1;
				}
				
				spriteCounter = 0;
			}
			
		}
		else {
			spriteNum = 1;
		}
		
	}
	
	public void pickUpObject(int i) {
		if(i != 999) {
			String objectName = gp.obj[i].name;
			
			switch(objectName) {
			case "Key":
				gp.playSE(i);
				hasHouseKey++;
				gp.playMusic(2);
				gp.obj[i] = null;
				
				gp.obj[15] = null;
				gp.obj[16] = null;
				gp.obj[17] = null;
				gp.obj[18] = null;
				
				break;
				
			case "Door":
				if(hasHouseKey > 0) {
					gp.playSE(1);
					gp.obj[i] = null;
				}
				break;
				
			case "BlueKey":
				hasBlueKey++;
				gp.playSE(3);
				gp.obj[i] = null;
				break;
				
			case "BlueDoor":
				if(hasBlueKey > 0) {
					gp.playSE(1);
					gp.obj[i] = null;
				}
				break;
				
			case "RedKey":
				hasRedKey++;
				gp.obj[i] = null;
				break;
				
			case "RedDoor":
				if(hasRedKey > 0) {
					gp.playSE(1);
					gp.obj[i] = null;
				}
				break;
				
			case "GreenKey":
				hasGreenKey++;
				gp.obj[i] = null;
				break;
				
			case "GreenDoor":
				if(hasGreenKey > 0) {
					gp.playSE(1);
					gp.obj[i] = null;
				}
				break;
				
			case "Cross":
				speed += 1;
				gp.playSE(4);
				gp.obj[i] = null;
				break;
				
			case "Bed":
				gp.ui.gameFinished = true;
				gp.stopMusic();
				gp.playMusic(5);
				gp.playSE(7);
				break;
				
			case "Creep":
				gp.ui.jumpScare = true;
				speed -= 1;
				gp.playSE(6);
				gp.obj[i] = null;
				break;
				
			case "Him":
				gp.scare.finalScare = true;
				speed -= 1;
				gp.obj[i] = null;
				gp.playSE(8);
				break;
			}
		}
		
	}
	
	public void draw(Graphics2D g2) {
		
		BufferedImage image = null;
		
		switch(direction) {
		case "up":
			if(spriteNum == 1) {
				image = up1;
			}
			if(spriteNum == 2) {
				image = up2;
			}
			break;
				
		case "down":
			if(spriteNum == 1) {
				image = down1;
			}
			if(spriteNum == 2) {
				image = down2;
			}
			break;
			
		case "right":
			if(spriteNum == 1) {
				image = right1;
			}
			if(spriteNum == 2) {
				image = right2;
			}
			break;
			
		case "left":
			if(spriteNum == 1) {
				image = left1;
			}
			if(spriteNum == 2) {
				image = left2;
			}
			break;
		}
		
		g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
	}
}
