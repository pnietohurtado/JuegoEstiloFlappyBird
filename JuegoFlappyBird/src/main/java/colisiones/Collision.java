/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colisiones;

import Player.Entity;
import com.mycompany.juegoflappybird.GamePanel;

/**
 *
 * @author pablo
 */
public class Collision {
    private GamePanel gp; 
    public String direction; 
    
    public Collision(GamePanel gp){
        this.gp = gp; 
    }
    
     public void checkTile(Entity entity){
        int entityLeftWorldX = entity.worldx + entity.solidArea.x; 
        int entityRightWorldX = entity.worldx + entity.solidArea.x + entity.solidArea.width; 
        int entityTopWorldY = entity.worldy + entity.solidArea.y; 
        int entityBottomWorldY = entity.worldy + entity.solidArea.y + entity.solidArea.height; 
        
        int entityLeftCol = entityLeftWorldX/gp.tileSize; 
        int entityRightCol = entityRightWorldX/gp.tileSize; 
        int entityTopRow = entityTopWorldY/gp.tileSize; 
        int entityBottomRow = entityBottomWorldY/gp.tileSize; 
        
        int tileNum1, tileNum2; 
        
        String direction = "up"; 
        
        switch(direction){
            case "up": 
                entityTopRow = (entityTopWorldY - 3) / gp.tileSize; 
                tileNum1 = gp.tileManager.mapTileNum[entityLeftCol][entityTopRow]; 
                tileNum2 = gp.tileManager.mapTileNum[entityRightCol][entityTopRow]; 
                if(gp.tileManager.tile[tileNum1].collision == true ||gp.tileManager.tile[tileNum2].collision == true){
                    entity.collision = true; 
                    this.direction = "up"; 
                    
                    
                    
                }else if(gp.tileManager.tile[tileNum1].collision == false ||gp.tileManager.tile[tileNum2].collision == false){
                    
                    this.direction = "up"; 
                }
                break; 
            case "down": 
                entityBottomRow = (entityBottomWorldY + 3) / gp.tileSize; 
                tileNum1 = gp.tileManager.mapTileNum[entityLeftCol][entityBottomRow]; 
                tileNum2 = gp.tileManager.mapTileNum[entityRightCol][entityBottomRow]; 
                if(gp.tileManager.tile[tileNum1].collision == true ||gp.tileManager.tile[tileNum2].collision == true){
                    entity.collision = true; 
                    this.direction = "down"; 
                }
                else if(gp.tileManager.tile[tileNum1].collision == false ||gp.tileManager.tile[tileNum2].collision == false){
                    this.direction = "down"; 
                }
                break;
        }
    }
    
}
