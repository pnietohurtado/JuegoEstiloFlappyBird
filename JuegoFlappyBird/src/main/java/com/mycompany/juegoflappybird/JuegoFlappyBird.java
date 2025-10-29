/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.juegoflappybird;

import static com.mycompany.juegoflappybird.JuegoFlappyBird.main;
import static com.sun.tools.javac.Main.main;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
/**
 *
 * @author pablo
 */
public class JuegoFlappyBird {

    public static void main(String[] args) {
        
        JFrame window = new JFrame(); 
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(true);
        window.setTitle("Ovulitos");
        
        //window.setIconImage(ImageIO.read(main.class.getResources("/Logo/Ovulitos.jpg")));
        
        GamePanel gp = new GamePanel(); 
        window.add(gp); 
        window.pack(); 
        
        window.setLocationRelativeTo(null); 
        window.setVisible(true); 
        
        
        
    }
}
