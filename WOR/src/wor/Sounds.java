/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package wor;
import javax.sound.sampled.*;
import java.io.File;

/**
 *
 * @author Diane
 */

public class Sounds {
    private static Clip clip;
    public static synchronized void playSoundInfinite(final String url) {
        File f = new File(url);
        new Thread(new Runnable() {
        // The wrapper thread is unnecessary, unless it blocks on the
        // Clip finishing; see comments.
        public void run() {
          try {
            clip = AudioSystem.getClip();
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(f);
            clip.open(inputStream);
            clip.loop(clip.LOOP_CONTINUOUSLY); 
          } catch (Exception e) {
            System.err.println(e.getMessage());
          }
        }
      }).start();
    }
    
    public static synchronized void playSoundSingle(final String url) {
        File f = new File(url);
        new Thread(new Runnable() {
        // The wrapper thread is unnecessary, unless it blocks on the
        // Clip finishing; see comments.
        public void run() {
          try {
            clip = AudioSystem.getClip();
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(f);
            clip.open(inputStream);
            clip.start();
          } catch (Exception e) {
            System.err.println(e.getMessage());
          }
        }
      }).start();
    }
    
    public void stop() {
	clip.stop();
    }
}
    


