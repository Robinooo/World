package wor;

/**
 * Talking is a subclass of Character. A talking character is a character that
 * speak to the player. It has two different speeches, depending on the
 * persuasion points of the player.
 *
 * @author G2
 * @version 20/10/17
 */
public class Talking extends Character {

    private String speech1; // low persuasion points
    private String speech2; // high persuasion points

    /**
     * Constructor for objects of class Talking Create a person talking. A
     * talking character is represented by its name and its two speeches.
     *
     * @param s1 The first speech of the talking when his rate of persuasion is
     * low
     * @param s2 The second speech of the talking when his rate of persuasion is
     * high
     * @param n The name of the talking character
     */
    public Talking(String s1, String s2, String n) {
        name = n.toUpperCase();
        speech1 = s1;
        speech2 = s2;
    }

    /**
     * A getter to know the speech1
     *
     * @return the first speech of the character, when the player's persuasion
     * rate is low
     */
    public String getspeech1() {
        return speech1;
    }

    /**
     * A getter to know the speech2
     *
     * @return the second speech of the character, when the player's persuasion
     * rate is high
     */
    public String getspeech2() {
        return speech2;
    }

    /**
     * Set the first speech of the talking character
     *
     * @param pspeach1 the new speech of the character
     */
    public void setspeach1(String pspeech1) {
        speech1 = pspeech1;
    }

    /**
     * Set the second speech of the talking character
     *
     * @param pspeach2 the new speech of the character
     */
    public void setspeech2(String pspeech2) {
        speech2 = pspeech2;
    }

    /**
     * Display the 2 speeches of the talking
     *
     * @param persuasion, the speeches depend on the persuasion rate of the
     * player
     * @return getspeech1() if the player's persuasion rate is low or
     * getspeech2() if the player's persuasion rate is high
     */
    public String talk(int persuasion) {
        if (persuasion < 45) {
            return getspeech1(); // Depending of the persuasion points
        } else {
            return getspeech2(); // Depending of the persuasion points
        }
    }
}
