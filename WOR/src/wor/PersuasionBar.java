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
public class PersuasionBar {
    private JProgressBar bar;
    private int value;
    
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
    
    public JProgressBar getPersuasionBar(){
        return bar;
    }
    
    public void setValueBar(int val){
        bar.setValue(val);
        colorBar();
    }
    
    public void colorBar(){
        if (bar.getValue() >59 ){
            bar.setForeground(Color.red);
        }else{
            bar.setForeground(Color.blue);
        }
    }
}