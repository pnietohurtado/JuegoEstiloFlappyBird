/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sound;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

/**
 *
 * @author pablo
 */
public class Sound {

    URL sound[] = new URL[100]; 
    private final Map<Integer, Clip> clips = new HashMap<>(); 
    public float volumeMusic; 
    public float volumeEffect; 
    
    public Sound(){
        sound[1] = getClass().getResource("/Sonido/Salto.wav"); 
        
        this.volumeMusic = -20.0f; 
        this.volumeEffect = -20.0f; 
    }
    
    public void play(int i, boolean loop, String action){
        try{
            AudioInputStream ais = AudioSystem.getAudioInputStream(sound[i]); 
            if(action.equals("music")){
                Clip newClip = AudioSystem.getClip(); 
                newClip.open(ais); 
                
                FloatControl audioVolume = (FloatControl) newClip.getControl(FloatControl.Type.MASTER_GAIN); 
                audioVolume.setValue(volumeMusic);
                
                if(loop){
                    newClip.loop(Clip.LOOP_CONTINUOUSLY);
                }else {
                    newClip.start(); 
                }
            }else if(action.equals("effect")){
                Clip newClip = AudioSystem.getClip(); 
                newClip.open(ais); 
                
                FloatControl audioVolume = (FloatControl) newClip.getControl(FloatControl.Type.MASTER_GAIN); 
                audioVolume.setValue(volumeMusic);
                
                /*
                if(loop){
                    newClip.loop(Clip.LOOP_CONTINUOUSLY);
                }else {
                    newClip.start(); 
                }*/
                newClip.start(); 
            }
            
        }catch(Exception e){
            e.printStackTrace(); 
        }
    }
    
    public void stop(int i) {
        Clip c = clips.get(i); 
        if(c != null && c.isRunning()){
            c.stop(); 
            c.close();
        }
    }
      
    
}
