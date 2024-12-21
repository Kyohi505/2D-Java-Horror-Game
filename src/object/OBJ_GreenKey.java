package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_GreenKey extends SuperObject{
	
	public OBJ_GreenKey() {
		name = "GreenKey";
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/greenKey.png"));
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
