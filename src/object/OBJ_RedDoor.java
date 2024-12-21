package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_RedDoor extends SuperObject {
	
	public OBJ_RedDoor() {
		name = "RedDoor";
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/redDoor.png"));
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		collision = true;
	}
}

