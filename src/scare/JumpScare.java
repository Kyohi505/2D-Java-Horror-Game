package scare;

import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class JumpScare {
	
	GamePanel gp;
	public Frames[] frame;
	public boolean finalScare = false;
	int finalScareCounter = 0;
	int currentFrame = 0;
	
	public JumpScare(GamePanel gp) {
		this.gp = gp;
		frame = new Frames[27];
		getFrameImage();
	}
	
	public void getFrameImage() {
		try {
            for (int i = 0; i < 27; i++) {
                frame[i] = new Frames();
                frame[i].image = ImageIO.read(
                        getClass().getResourceAsStream("/jumpscare/creep-" + (i + 1) + ".png")
                );
            }			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void draw(Graphics2D g2) {
		
		int x = gp.screenWidth/2 - (gp.tileSize*16)/2;
		int y = 0;
		
		if(finalScare == true) {
			
            if (currentFrame < frame.length) {
                g2.drawImage(frame[currentFrame].image, x, y, gp.tileSize * 16, gp.tileSize * 12, null);

         
                finalScareCounter++;
                if (finalScareCounter % 19 == 0) {
                    currentFrame++;
                }
            }
            else {
             
                finalScare = false;
                currentFrame = 0;
                finalScareCounter = 0;
			}
			
		}
	
	}
}
