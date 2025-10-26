package Keys;


import com.mycompany.juegoflappybird.GamePanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author pablo
 */
public class KeyHandler implements KeyListener{
    
    public boolean up; 
    private GamePanel gp; 
    
    public KeyHandler(GamePanel gp){
        this.gp = gp; 
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        int code = e.getKeyCode(); 
        if(code == KeyEvent.VK_UP){
            try{
                up = true; 
                gp.sound.play(1, false ,"effect");
                System.out.println("Salta!");
                Thread.sleep(100); // So the player can't exploid the jump key 
            }catch(Exception de){
                de.printStackTrace();
            }
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode(); 
        if(code == KeyEvent.VK_UP){
            up = false;
            do{
                System.out.println("Está cayendo!");
            }while(up); 
        }
    }
    
}
