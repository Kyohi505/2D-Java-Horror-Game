package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_GreenDoor extends SuperObject{

	public OBJ_GreenDoor() {
		name = "GreenDoor";
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/greenDoor.png"));
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		collision = true;
	}
}
