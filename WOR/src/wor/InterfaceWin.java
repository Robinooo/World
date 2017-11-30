package wor;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color; 

/**
 *
 * @author DIane
 */
public class InterfaceWin {
   private Icon YouWin;
   // private JLabel myLabelGO ;

    public InterfaceWin(){
       YouWin = new ImageIcon(getClass().getResource("/pictures2/youwin.png"));
        JLabel myLabelGO = new JLabel();
        myLabelGO.setIcon(YouWin);
        JFrame frame2 = new JFrame("You Win");
        frame2.setSize(650, 400);
        frame2.add(myLabelGO);
        //Définition de sa couleur de fond
        frame2.setBackground(Color.BLUE);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setVisible(true);      
    }


}

