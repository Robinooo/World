package wor;

import javax.swing.*;
import java.awt.*;
/**
 * The TimeBar class represent the bar that displays the time remaining to the 
 * player. 
 * 
 * @author G2
 * @version 27/11/17
 */
public class TimeBar {
    private JProgressBar bar; // the bar displayed
    
    /**
     * The constructor of the TimeBar class. Initialization of the time bar.
     */
    public TimeBar(){
        bar = new JProgressBar();
        bar.setMaximum(100);
        bar.setMinimum(0);
        bar.setStringPainted(true);
        bar.setValue(50);
        bar.setBorderPainted(false);
        bar.setBackground(Color.black);
        bar.setForeground(Color.blue);
    }
    
    /**
     * Gets the time bar. 
     * @return bar
     */
    public JProgressBar getTimeBar(){
        return bar;
    }
    
    /**
     * Sets the value of the time in the bar, to display the remaining time
     * @param val, the time remaining to the player
     */
    public void setValueBar(int val){
        bar.setValue(val);
        colorBar();
    }
    
    /**
     * Change the color of the bar when there is only 30 points of time remaining.
     */
    public void colorBar(){
        if (bar.getValue() < 30){
            bar.setForeground(Color.red);
        }else{
            bar.setForeground(Color.blue);
        }
    }
}