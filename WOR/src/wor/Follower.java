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
    public Follower(String Speach, String n) {
        name = n;
        speach = Speach;
    }

    /**
     * The follow method allows the user to know if the character is following 
     * the player in the map or not. True if the character is following the player.
     */
    public boolean follow() {
        return false; // the talking character is not following the player
    }
    
    /**
     * The getSpeach1 method gets the speach of the follower. 
     * @return speach, the speach of the character
     */
    public String getspeach1() {
        return speach;
    }
    
    /**
     * The follow2 method returns the speach of the follower, depending on the 
     * persuasion points of the player. 
     * 
     * @param persuasion
     * @return getspeach1, the speach of the follower
     */
    public String follow2(int persuasion) {
            return getspeach1(); // Depending of the persuasion points  
    }
}
