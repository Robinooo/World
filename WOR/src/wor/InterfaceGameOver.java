/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wor;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Sylvia
 */
public class InterfaceGameOver {
    private Icon testGameOver;
   // private JLabel myLabelGO ;

    public InterfaceGameOver(){
       testGameOver = new ImageIcon(getClass().getResource("/pictures2/gameover.jpg"));
        JLabel myLabelGO = new JLabel();
        myLabelGO.setIcon(testGameOver);
        JFrame frame2 = new JFrame("Game Over");
        frame2.setSize(1000, 850);
        frame2.add(myLabelGO);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setVisible(true);      
    }


    }

