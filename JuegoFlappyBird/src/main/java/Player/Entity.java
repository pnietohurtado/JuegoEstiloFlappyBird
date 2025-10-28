/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Player;

import com.mycompany.juegoflappybird.GamePanel;
import com.mycompany.juegoflappybird.UtilityTool;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author pablo
 */
public class Entity {
 
    public int worldx, worldy; 
    protected BufferedImage u; 
    protected int spriteCounter = 0; 
    protected int spriteNum = 1; 
    
    public Rectangle solidArea = new Rectangle(0,0,48,48); 
    public Rectangle nearSolidArea; 
    public int solidAreaDefaultX, solidAreaDefaultY; 
    public boolean collision; 
    
    public boolean move = false; 
    
    private GamePanel gp; 
    
    public Entity (GamePanel gp){
        this.gp = gp; 
    }
    
    public BufferedImage setUp(String imagePath){
        UtilityTool u = new UtilityTool(); 
        BufferedImage image = null; 
        
        try{

            image = ImageIO.read(getClass().getResourceAsStream(imagePath + ".png"));
            image = u.scaleImage(image, gp.tileSize , gp.tileSize); 
            
        }catch(IOException e){
            e.printStackTrace(); 
        }
        
        return image; 
    }
    
    
}
