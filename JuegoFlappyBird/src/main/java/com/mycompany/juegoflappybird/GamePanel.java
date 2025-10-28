/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.juegoflappybird;

import Keys.KeyHandler;
import Player.Player;
import Sound.Sound;
import Tile.TileManager;
import colisiones.Collision;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author pablo
 */
public class GamePanel extends JPanel implements Runnable{

    // Screen 
    final int originalTileSize = 16; 
    final int scale = 3; 
    
    public final int tileSize = originalTileSize * scale; 
    public final int maxScreenCol = 16; 
    public final int maxScreenRow = 12; 
    public final int screenWidth = tileSize * maxScreenCol; 
    public final int screenHeight = tileSize * maxScreenRow; 
    
    
    // World Settings 
    public int maxWorldCol;
    public int maxWorldRow; 
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeigth = tileSize * maxWorldRow;
    
    
    // Variables 
    private Thread gameThread; 
    private final int FPS = 60; 
    
    // Intances 
    public KeyHandler kh = new KeyHandler(this); 
    public Sound sound = new Sound(); 
    public Player player = new Player(this, kh); 
    public Collision cH = new Collision(this); 
    public TileManager tileManager = new TileManager(this, kh); 

    
    public GamePanel(){
        this.setPreferredSize(new Dimension(this.screenWidth, this.screenHeight));
        this.setMinimumSize(new Dimension(this.screenWidth, this.screenHeight));
        this.setBackground(Color.black);
        this.addKeyListener(kh);
        this.setDoubleBuffered(true);
        this.setFocusable(true); 
    }
    
    // RUN
    @Override
    public void run() {
        double drawInterval = 1000000000/FPS; 
        double delta = 0; 
        long lastTime = System.nanoTime(); 
        long currentTime; 
        
        long timer = 0; 
        int drawCount = 0; 
        
        while(gameThread != null){
            currentTime = System.nanoTime(); 
            
            delta += (currentTime - lastTime) / drawInterval; 
            timer += (currentTime - lastTime); 
            lastTime = currentTime; 
            
            if(delta >= 1){
                update(); 
                repaint(); 
                delta--; 
                drawCount++; 
            }
            
            if(timer >= 1000000000){
                drawCount = 0; 
                timer = 0; 
            }
        }
    }
    
    
    // METHODS 
    
    public void startGameThread(){
        gameThread = new Thread(this); 
        gameThread.start(); 
    }
    
    
    // UPDATE 
    public void update(){
        
    }
    
    
    // PAINT 
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g; 
        
        g2.setColor(Color.red);
        g2.drawString("Hola que tal", 100, 100); 
    }
    
    
}
