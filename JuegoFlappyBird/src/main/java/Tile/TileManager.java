/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tile;

import Keys.KeyHandler;
import com.mycompany.juegoflappybird.GamePanel;
import com.mycompany.juegoflappybird.UtilityTool;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author pablo
 */
public class TileManager {
    private GamePanel gp; 
    private KeyHandler kh; 
    public Tile[] tile; 
    public int mapTileNum[][]; 
    ArrayList<String> fileNames = new ArrayList<>(); 
    ArrayList<String> collisionStatus = new ArrayList<>(); 
    
    
    public boolean thereCollision = true; 
    public boolean noCollision = false; 
    
    
    public String map = "/Map/map.txt"; 
    
    public TileManager(GamePanel gp, KeyHandler kh){
        this.gp = gp; 
        this.kh = kh; 
        
        InputStream is = getClass().getResourceAsStream("/Collision/collision.txt"); 
        BufferedReader br = new BufferedReader(new InputStreamReader(is)); 
        
        String linea; 
        
        try {
            while((linea = br.readLine()) != null){
                fileNames.add(linea); 
                collisionStatus.add(br.readLine()); 
                
            }
            br.close(); 
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        tile = new Tile[fileNames.size()]; 
        getTileImage(); 
        
        loadMap(map); 
        
    }
    
    
     public void getTileImage()
    {
        for(int i = 0; i < fileNames.size(); i++){
            
            String fileName; 
            boolean collision; 
            
            fileName = fileNames.get(i); 
            if(collisionStatus.get(i).equals("true")){
                collision = true; 
            }else{
                collision = false; 
            }
            
            setUp(i, fileName, collision); 
            
        }
            
    }
    
    public void setUp(int index, String imagePath, boolean collsion){
        UtilityTool uTool = new UtilityTool(); 
        
        try{
            
            tile[index] = new Tile(); 
            tile[index].image = ImageIO.read(getClass().getResourceAsStream("/Background/"+imagePath)); 
            tile[index].image = uTool.scaleImage(tile[index].image, gp.tileSize, gp.tileSize); 
            tile[index].collision = collsion; 
            
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void loadMap(String path)
    {
        
        InputStream is = getClass().getResourceAsStream(path); 
        BufferedReader br = new BufferedReader(new InputStreamReader(is)); 
        
        try{
            String linea2 = br.readLine(); 
            //this.nombre = linea2; 
            String maxTile[] = linea2.split(" "); 
            gp.maxWorldCol = maxTile.length; 
            gp.maxWorldRow = maxTile.length; 
           
            
            mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow]; 
            br.close(); 
        }catch(IOException e){
            
        }
        
        
        try{
            
            is = getClass().getResourceAsStream(path);
            br = new BufferedReader(new InputStreamReader(is)); 
            
            int col = 0; 
            int row = 0; 
            
            while(col < gp.maxWorldCol && row < gp.maxWorldRow ){
                String line = br.readLine(); 
                
                while(col < gp.maxWorldCol ){
                    String numbers[] = line.split(" "); 
                    
                    int num = Integer.parseInt(numbers[col]); 
                    mapTileNum[col][row] = num; 
                    col++; 
                }
                
                if(col == gp.maxWorldCol){
                    col = 0; 
                    row++; 
                }
            }
            
            br.close(); 
        }catch(Exception e){
            
        }
    }
    
    
    public void draw(Graphics2D g2)
    {
        int worldCol = 0; 
        int worldRow = 0; 

        while(worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow)
        {
            int tileNum = mapTileNum[worldCol][worldRow]; 
            
            int worldX = worldCol * gp.tileSize; 
            int worldY = worldRow * gp.tileSize; 
            int screenX = worldX - gp.player.worldx + gp.player.screenX; 
            int screenY = worldY - gp.player.worldy + gp.player.screenY; 
            
            if(worldX + gp.tileSize > gp.player.worldx - gp.player.screenX &&
                    worldX - gp.tileSize < gp.player.worldx + gp.player.screenX &&
                    worldY + gp.tileSize > gp.player.worldy - gp.player.screenY &&
                    worldY - gp.tileSize < gp.player.worldy + gp.player.screenY){
                    
                g2.drawImage(tile[tileNum].image, screenX,screenY,gp.tileSize,gp.tileSize,null); 
            }
            
           
            worldCol++; 
            
            if(worldCol == gp.maxWorldCol){
                worldCol = 0; 
                worldRow++;  
            }
        }
        
        
    }
    
}
