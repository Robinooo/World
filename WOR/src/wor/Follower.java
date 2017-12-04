package wor;

/**
 * This class is used to create a specific character, the follower.. The follower 
 * is a kind of character, that follows the player and helps him in its investigation. 
 *
 * @author (Group2)
 * @version (20th of November 2017)
 */
public class Follower extends Character {

    private String speach;

    /**
     * Constructor for objects of class Follower. A follower is represented by a speach
     * which is specific to this follower and a name (the name of this character). 
     * 
     * @param Speach, the speach of the character 
     * @param n, the name of the character
     */
    public Follower(String sp, String n) {
        name = n;
        speach = sp;
    }

    /**
     * The follow method allows the user to know if the character is following 
     * the player in the map or not. True if the character is following the player.
     * @return false if the character does not follow the player
     */
    public boolean follow(boolean fol) {
        return fol; // true if the character is following the player
    }
    
    /**
     * The getSpeach1 method gets the speach of the follower. 
     * @return speach, the speach of the character
     */
    public String getspeach() {
        return speach;
    }
}
