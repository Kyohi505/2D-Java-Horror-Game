package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_BlueKey extends SuperObject{
	
	public OBJ_BlueKey() {
		name = "BlueKey";
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/blueKey.png"));
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
