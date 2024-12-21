package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Him extends SuperObject{

	public OBJ_Him() {
		name = "Him";
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/him.png"));
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
