package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
	
	GamePanel gp;
	public boolean upPress, downPress, rightPress, leftPress;
	
	public KeyHandler(GamePanel gp) {
		this.gp = gp;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		
		if(gp.gameState == gp.titleState) {
			if(gp.ui.titleScreenState == 0) {
				if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP) {
					gp.ui.commandNum--;
					if(gp.ui.commandNum < 0) {
						gp.ui.commandNum = 1;
						
					}
				}
				
				if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) {
					gp.ui.commandNum++;
					if(gp.ui.commandNum > 1) {
						gp.ui.commandNum = 0;
					}
				}
				
				if(code == KeyEvent.VK_ENTER) {
					if(gp.ui.commandNum == 0) {
						gp.ui.titleScreenState = 1;
				
					}
					if(gp.ui.commandNum == 1) {
						System.exit(0);
					}
				}
			}
			if(gp.ui.titleScreenState == 1) {
				if(gp.ui.canPlay == true) {
					if(code == KeyEvent.VK_ENTER) {
						gp.gameState = gp.playState;
						gp.ui.timerOn = true;
						gp.playMusic(0);
					}
				}
			}
		}
		
		if(gp.gameState == gp.playState) {
			if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP) {
				upPress = true;
			}
			
			if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) {
				downPress = true;
			}
			
			if(code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT) {
				leftPress = true;
			}
			
			if(code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT) {
				rightPress = true;
			}
		}
			
	}

	@Override
	public void keyReleased(KeyEvent e) {

		int code = e.getKeyCode();
		
		if(gp.gameState == gp.playState) {
			if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP) {
				upPress = false;
			}
			
			if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) {
				downPress = false;
			}
			
			if(code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT) {
				leftPress = false;
			}
			
			if(code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT) {
				rightPress = false;
			}
		}
		
	}

}
