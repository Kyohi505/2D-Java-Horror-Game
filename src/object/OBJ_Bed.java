package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Bed extends SuperObject {
	
	public OBJ_Bed() {
		name = "Bed";
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/bed.png"));
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
