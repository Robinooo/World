package wor;

/**
 * This class represents characters that are talking to the player.
 *
 * @author (Group2)
 * @version (20th of November 2017)
 */
public class Follower extends Character {

    private String speach1;

    /**
     * Constructor for objects of class Follower
     */
    public Follower(String Speach, String n) {
        name = n;
        speach1 = Speach;
    }

    /**
     * This method represents if the character is following the player in the
     * map.
     */
    public boolean follow() {
        return false; // the talking characters are not following the player
    }
    
    public String getspeach1() {
        return speach1;//"testSpeach1";
    }
    public String follow2(int persuasion) {
   
            return getspeach1(); // Depending of the persuasion points
        
    }
    
    
}
