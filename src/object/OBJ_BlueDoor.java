package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_BlueDoor extends SuperObject {
	
	public OBJ_BlueDoor() {
		name = "BlueDoor";
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/blueDoor.png"));
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		collision = true;
	}

}
