package wor;


/**
 * This class is used to create a killer character, the killer can try to kill the player if they meet during the game.
 *
 * @author Group 2
 * @version 11/20/17
 */
public class Killer extends Character
{
    private int time = 200; // The time to solve the enigma

    /**
     * Constructor for objects of class Killer
     */
    // public Killer()
    // {
        // super("Killer");
        // isKiller = true;
    // }
    
    public Killer (String n)
    {
        name=n.toUpperCase();
        // currentRoom=cR;
        isLier=false;
    }
        
    /**
     * If the player meet the killer, the killer will try to kill him as well.
     * The player will lose time and life points, if time or life points goes to 0, the playre dies in the process...
     */
    public void kill()
    {
    }
    
    /**
     * Get how much time left there is for the player to solve the enigma. 
     */
    public int getTime(){
        return 200;//time;
    }
}
