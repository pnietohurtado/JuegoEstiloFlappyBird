/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author pablo
 */
public class TileManager {
    private GamePanel gp; 
    private KeyHandler kh; 
    public Tile[] tile; 
    public int mapTileNum[]; 
    ArrayList<String> fileNames = new ArrayList<>(); 
    ArrayList<String> collisionStatus = new ArrayList<>(); 
    
    
    public boolean thereCollision = true; 
    public boolean noCollision = false; 
    
    
    public String map = "/Maps/mapa1.txt"; 
    
    public TileManager(GamePanel gp, KeyHandler kh){
        this.gp = gp; 
        this.kh = kh; 
        
        InputStream is = getClass().getResourceAsStream("/Maps/collision.txt"); 
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
        
        loadMap[0]; 
        
    }
}
