package wor;

/**
 * This class is used to create a specific character, the follower. The
 * follower is a kind of character, that follows the player and helps him in its
 * investigation.
 *
 * @author (Group2)
 * @version (5/12/17)
 */
public class Follower extends Character {

    private String speech;
    private boolean fol;

    /**
     * Constructor for objects of class Follower. A follower is represented by a
     * speech which is specific to this follower and a name (the name of this
     * character).
     *
     * @param sp, the speech of the character
     * @param n, the name of the character
     */
    public Follower(String sp, String n) {
        name = n;
        speech = sp;
        fol = false;
    }

    /**
     * The follow method allows the user to know if the character is following
     * the player in the map or not. True if the character is following the
     * player.
     *
     * @return false if the character does not follow the player
     */
    public boolean getfollow() {
        return fol; // true if the character is following the player
    }
    
    /**
     * Modifies the status of the follower. True if the character is following the player.
     */
    public void follow() {
        fol = true;
    }

    /**
     * The getSpeach1 method gets the speech of the follower.
     *
     * @return speech, the speech of the character
     */
    public String getspeech() {
        return speech;
    }
}
