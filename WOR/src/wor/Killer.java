package wor;

/**
 * This class is used to create a killer character, the killer can try to kill
 * the player if they meet during the game.
 *
 * @author Group 2
 * @version 11/20/17
 */
public class Killer extends Character {

    /**
     * Constructor for objects of class Killer. The killer is represented by a
     * name.
     *
     * @param name, the name of the killer
     */
    public Killer(String n) {
        name = n.toUpperCase();
    }

    /**
     * If the player meet the killer, the killer will try to kill him as well.
     * The player will lose time and life points, if time or life points goes to
     * 0, the playre dies in the process...
     */
    public void kill() {
    }
}
