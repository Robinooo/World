/**
 * The sounds class allows us to put music during the game
 *
 * @author GR2
 * @version 11/12/17
 */
package wor;

import javax.sound.sampled.*;
import java.io.File;

/**
 *
 * @author G2
 */
public class Sounds {

    private static Clip clip;

    /**
     * The constructor of the class Sounds
     * @param url The path of the music
     */
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

    /**
     * A method to start the music during the game
     * @param url The path of the music
     */
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

    /**
     * A method to stop the music during the game
     * @param url The path of the music
     */
    public void stop(String url) {
        clip.stop();
    }
}
