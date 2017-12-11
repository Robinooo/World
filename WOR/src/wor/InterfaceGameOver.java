/**
 * This class is used to create the interface of the window game over
 *
 * @author (Group2)
 * @version (11/12/17)
 */
package wor;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;

/**
 *
 * @author G2
 */
public class InterfaceGameOver {

    private Icon testGameOver; //Ion for the window containing  our image of GameOver
    private Sounds s; // The sound of the window game over
    
    /**
     * Constructor of the interface game over
     */
    public InterfaceGameOver() {
        //s.stop("music/panthère_rose.wav");
        s.playSoundInfinite("music/gadget.wav");
        testGameOver = new ImageIcon(getClass().getResource("/pictures2/gameover.png"));
        JLabel myLabelGO = new JLabel();
        myLabelGO.setIcon(testGameOver);
        JFrame frame2 = new JFrame("Game Over");
        frame2.setSize(900, 900);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setLocationRelativeTo(null);
        frame2.add(myLabelGO);
        frame2.setVisible(true);
    }
}
