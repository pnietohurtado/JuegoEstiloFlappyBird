/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Player;

import Keys.KeyHandler;
import com.mycompany.juegoflappybird.GamePanel;
import java.awt.Rectangle;

/**
 *
 * @author pablo
 */
public class Player extends Entity{

    
    private KeyHandler kh; 
    private GamePanel gp; 
    
    public final int screenX; 
    public final int screenY; 
    
    public Player(GamePanel gp, KeyHandler kh){
    
        super(gp); 
        
        this.kh = kh; 
        
        this.screenX = gp.screenWidth/2 - (gp.tileSize / 2); 
        this.screenY = gp.screenHeight / 2 - (gp.tileSize / 2); 
        
        solidArea = new Rectangle(); 
        solidArea.x = 8; 
        solidArea.y = 16; 
        
        solidAreaDefaultX = solidArea.x; 
        solidAreaDefaultY = solidArea.y; 
        
        solidArea.width = 32; 
        solidArea.height = 32; 
        
        setDefaultValues(); 
        getPlayerImage(); 
        
        
    }
    
    // Player's Initial Position 
    public void setDefaultValues() 
    {
        try{
            worldx = gp.tileSize * 34 ; 
            worldy = gp.tileSize * 34 ; 
        }catch(Exception e ){
            System.out.println("TileSize " + gp.tileSize);
            System.out.println("El valor de X : " + worldx);
        }
    }
    
    String u1 = "/Player/Ovulito"; 
    public void getPlayerImage(){
        u = setUp(u1); 
    }
    
    
     public void update()
    {
        if(kh.up == true ){
            
            if(kh.up == true)
            {
                
            }
            // Check tile collision 
            collision = false; 
            gp.cH.checkTile(this);
            
            // If collision is false, player can't move 
            if(collision == false){
                switch("up" ){
                    case "up": 
                        worldx -= 3;  
                        break; 
                    case "down": 
                        worldy += 3; 
                        break; 
                }
            }
            
            spriteCounter++; 
            if(spriteCounter > 12){
                if(spriteNum == 1){
                    spriteNum = 2; 
                }else if (spriteNum == 2){
                    spriteNum = 1; 
                }
                spriteCounter = 0; 
            }    
            
        }
    }
    
}
