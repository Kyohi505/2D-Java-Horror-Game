package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_RedKey extends SuperObject{
	
	public OBJ_RedKey() {
		name = "RedKey";
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/redKey.png"));
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
