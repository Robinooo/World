package wor;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color; 
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author Diane
 */
public class InterfaceWin {
    private Sounds s;
    private static Clip clip;
    private Icon YouWin;
    
    public InterfaceWin(){
       //AudioSystem.getClip("music/long.wav");
       //clip.stop("music/long.wav");
      //s.stop();
       
       s.playSoundInfinite("music/gadget.wav"); 
       YouWin = new ImageIcon(getClass().getResource("/pictures2/youwin.png"));
        JLabel myLabelGO = new JLabel();
        myLabelGO.setIcon(YouWin);
        JFrame frame2 = new JFrame("You Win");
        frame2.setSize(900, 506);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setLocationRelativeTo(null);
        frame2.add(myLabelGO);
        frame2.setVisible(true);      
    }
}

