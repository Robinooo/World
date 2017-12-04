package wor;

/**
 * Talking is a subclass of Character. A talking character is a character that 
 * speak to the player. It has two different speaches, depending on the 
 * persuasion points of the player. 
 *
 * @author G2
 * @version 20/10/17
 */
public class Talking extends Character {

    private String speach1; // low persuasion points
    private String speach2; // high persuasion points

    /**
     * Constructor for objects of class Talking Create a person talking. A talking
     * character is represented by its name and its two speaches.
     * @param s1 The first speach of the talking when his rate of persuasion is low
     * @param s2 The second speach of the talking when his rate of persuasion is high
     * @param n The name of the talking character
     */
    public Talking(String s1, String s2, String n) {
        name = n;
        speach1 = s1;
        speach2 = s2;
    }

    /**
     * A getter to know the speach1
     * @return the first speach of the character, when the player's persuasion rate is low
     */
    public String getspeach1() {
        return speach1;
    }

    /**
     * A getter to know the speach2
     * @return the second speach of the character, when the player's persuasion rate is high
     */
    public String getspeach2() {
        return speach2;
    }

    /**
     * Set the first speach of the talking character
     * @param pspeach1 the new speach of the character
     */
    public void setspeach1(String pspeach1) {
        speach1 = pspeach1;
    }

    /**
     * Set the second speach of the talking character
     * @param pspeach2 the new speach of the character
     */
    public void setspeach2(String pspeach2) {
        speach2 = pspeach2;
    }

    /**
     * Display the 2 speaches of the talking
     * @param persuasion, the speaches depend on the persuasion rate of the player
     * @return getspeach1() if the player's persuasion rate is low or getspeach2() 
     * if the player's persuasion rate is high
     */
    public String talk(int persuasion) {
        if (persuasion < 45){
            return getspeach1(); // Depending of the persuasion points
        } else {
            return getspeach2(); // Depending of the persuasion points
        }
    }
}
