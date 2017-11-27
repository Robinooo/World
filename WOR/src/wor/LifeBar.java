/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wor;

import javax.swing.*;
import java.awt.*;
/**
 *
 * @author G2
 */
public class LifeBar {
    private JProgressBar bar;
    
    public LifeBar(){
        bar = new JProgressBar();
        bar.setMaximum(100);
        bar.setMinimum(0);
        bar.setStringPainted(true);
        bar.setBorderPainted(false);
        bar.setBackground(Color.white);
        bar.setForeground(Color.green);
    }
    
    public JProgressBar getLifeBar(){
        return bar;
    }
    
    public void setValueBar(int val){
        bar.setValue(val);
    }
}