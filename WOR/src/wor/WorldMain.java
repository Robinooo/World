package wor;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sylvia
 */
public class WorldMain {
    
    //private World w;
    
    public static void main(String[] args) {
        World w = new World();
        //InterfaceDebut game = new InterfaceDebut();
        w.getPlayer().move("down");
        w.getPlayer().move("left");
        w.getPlayer().move("down");
    }
 
}
