package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Creep extends SuperObject {

	public OBJ_Creep() {
		name = "Creep";
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/creep.png"));
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
