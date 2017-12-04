package wor;

import javax.swing.*;
import java.awt.*;
/**
 * The LifeBar class represents the life bar of the player in the graphical interface. 
 * This life bar allows the player to visualize the life points remaining. 
 * @author G2
 * @version 27/11/17
 */
public class LifeBar {
    private JProgressBar bar; // the life bar
    
    /** 
     * Constructor of the LifeBar class. Initialization of the lifebar. 
     */
    public LifeBar(){
        bar = new JProgressBar();
        bar.setMaximum(100);
        bar.setMinimum(0);
        bar.setStringPainted(true);
        bar.setBorderPainted(false);
        bar.setBackground(Color.white);
        bar.setForeground(Color.green);
    }
    
    /**
     * The getLifebar method gets the life bar of the player.
     * @return bar, the lifebar
     */
    public JProgressBar getLifeBar(){
        return bar;
    }
    
    /**
     * The setValueBar method sets the life bar to a specific value (a number of life points). 
     * @param val, the number of life points.
     */
    public void setValueBar(int val){
        bar.setValue(val);
    }
}