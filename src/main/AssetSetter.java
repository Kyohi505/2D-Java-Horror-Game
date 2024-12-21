package main;

import object.OBJ_Cross;
import object.OBJ_BlueDoor;
import object.OBJ_BlueKey;
import object.OBJ_Bed;
import object.OBJ_Creep;
import object.OBJ_Door;
import object.OBJ_GreenDoor;
import object.OBJ_GreenKey;
import object.OBJ_Him;
import object.OBJ_Key;
import object.OBJ_RedDoor;
import object.OBJ_RedKey;
import object.OBJ_Tree;

public class AssetSetter {
	
	GamePanel gp;
	
	public AssetSetter(GamePanel gp) {
		this.gp = gp;
	}
	
	public void setObject() {
		gp.obj[0] = new OBJ_Key();
		gp.obj[0].worldX = 14 * gp.tileSize;
		gp.obj[0].worldY = 22 * gp.tileSize;
		
		gp.obj[1] = new OBJ_BlueKey();
		gp.obj[1].worldX = 4 * gp.tileSize;
		gp.obj[1].worldY = 7 * gp.tileSize;
		
		gp.obj[2] = new OBJ_RedKey();
		gp.obj[2].worldX = 4 * gp.tileSize;
		gp.obj[2].worldY = 28 * gp.tileSize;
		
		gp.obj[3] = new OBJ_GreenKey();
		gp.obj[3].worldX = 46 * gp.tileSize;
		gp.obj[3].worldY = 48 * gp.tileSize;
		
		gp.obj[4] = new OBJ_Door();
		gp.obj[4].worldX = 44 * gp.tileSize;
		gp.obj[4].worldY = 5 * gp.tileSize;
		
		gp.obj[5] = new OBJ_BlueDoor();
		gp.obj[5].worldX = 6 * gp.tileSize;
		gp.obj[5].worldY = 28 * gp.tileSize;
		
		gp.obj[6] = new OBJ_RedDoor();
		gp.obj[6].worldX = 40 * gp.tileSize;
		gp.obj[6].worldY = 47 * gp.tileSize;
		
		gp.obj[7] = new OBJ_GreenDoor();
		gp.obj[7].worldX = 12 * gp.tileSize;
		gp.obj[7].worldY = 22 * gp.tileSize;
		
		gp.obj[8] = new OBJ_Bed();
		gp.obj[8].worldX = 29 * gp.tileSize;
		gp.obj[8].worldY = 4 * gp.tileSize;
		
		gp.obj[9] = new OBJ_Cross();
		gp.obj[9].worldX = 10 * gp.tileSize;
		gp.obj[9].worldY = 29 * gp.tileSize;
		
		gp.obj[10] = new OBJ_Cross();
		gp.obj[10].worldX = 30 * gp.tileSize;
		gp.obj[10].worldY = 42 * gp.tileSize;
		
		gp.obj[11] = new OBJ_Creep();
		gp.obj[11].worldX = 45 * gp.tileSize;
		gp.obj[11].worldY = 47 * gp.tileSize;
		
		gp.obj[12] = new OBJ_Creep();
		gp.obj[12].worldX = 6 * gp.tileSize;
		gp.obj[12].worldY = 4 * gp.tileSize;
		
		gp.obj[13] = new OBJ_Creep();
		gp.obj[13].worldX = 47 * gp.tileSize;
		gp.obj[13].worldY = 31 * gp.tileSize;
		
		gp.obj[14] = new OBJ_Him();
		gp.obj[14].worldX = 46 * gp.tileSize;
		gp.obj[14].worldY = 8 * gp.tileSize;
		
		gp.obj[15] = new OBJ_Tree();
		gp.obj[15].worldX = 45 * gp.tileSize;
		gp.obj[15].worldY = 18 * gp.tileSize;
		
		gp.obj[16] = new OBJ_Tree();
		gp.obj[16].worldX = 46 * gp.tileSize;
		gp.obj[16].worldY = 18 * gp.tileSize;
		
		gp.obj[17] = new OBJ_Tree();
		gp.obj[17].worldX = 47 * gp.tileSize;
		gp.obj[17].worldY = 18 * gp.tileSize;
		
		gp.obj[18] = new OBJ_Tree();
		gp.obj[18].worldX = 48 * gp.tileSize;
		gp.obj[18].worldY = 18 * gp.tileSize;
		
		gp.obj[15].collision = true;
		gp.obj[16].collision = true;
		gp.obj[17].collision = true;
		gp.obj[18].collision = true;
		
		gp.obj[19] = new OBJ_Cross();
		gp.obj[19].worldX = 25 * gp.tileSize;
		gp.obj[19].worldY = 13 * gp.tileSize;
	}
}
