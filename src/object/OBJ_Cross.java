package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Cross extends SuperObject{
	
	public OBJ_Cross() {
		name = "Cross";
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/cross.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
