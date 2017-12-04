package wor;

import javax.swing.*;
import java.awt.*;
/**
 * The PersuasionBar class represents the bar which allows the player to visualize 
 * the number of persuasion points of the player into a bar. 
 * @author G2
 * @version 27/11/17
 */
public class PersuasionBar {
    private JProgressBar bar; // the graphical bar

    /**
     * Constructor of the persuasion bar. 
     */
    public PersuasionBar(){
        bar = new JProgressBar();
        bar.setMaximum(100);
        bar.setMinimum(0);
        bar.setStringPainted(true);
        bar.setValue(50);
        bar.setBorderPainted(false);
        bar.setBackground(Color.white);
        bar.setForeground(Color.blue);
    }
    
    /**
     * The getPersuasionBar method gets the persuasion bar of the player
     * @return bar
     */
    public JProgressBar getPersuasionBar(){
        return bar;
    }
    
    /**
     * The setValueBar method sets the persuasion bar of the player by modifying 
     * the number of persuasion points of the player. 
     * @param val, the number of persuasion points of the player
     */
    public void setValueBar(int val){
        bar.setValue(val);
        colorBar();
    }
    
    /**
     * The colorBar method changes the color of the bar when the number of 
     * persuasion points pass threshold of 59 persuasion points. 
     */
    public void colorBar(){
        if (bar.getValue() >59 ){
            bar.setForeground(Color.red);
        }else{
            bar.setForeground(Color.blue);
        }
    }
}