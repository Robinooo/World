package wor;

/**
 * Talking is a subclass of Character
 *
 * A talking is a character who can talk to us
 *
 * @G2
 * @20/10/17
 */
public class Talking extends Character {

    // instance variables - replace the example below with your own
    protected String speach1; // taux de persuasion bas 
    protected String speach2; // taux de persuasion haut
    private Player player;

    /**
     * Constructor for objects of class Talking Create a person talking
     *
     * @param s1 The first speach of the talking when his rate of persuasion is
     * down
     * @param s2 The second speach of the talking when his rate of persuasion is
     * up
     * @param n The name of the talking
     */
    public Talking(String s1, String s2, String n) {
        name = n;
        speach1 = s1;
        speach2 = s2;
    }

    /**
     * A getter to know the speach1
     *
     * @return the first speach of the character
     */
    public String getspeach1() {
        return speach1;//"testSpeach1";
    }

    /**
     * A getter to know the speach2
     *
     * @return the second speach of the character
     */
    public String getspeach2() {
        return speach2;//"testSpeach2";
    }

    /**
     * Set the speach1 of the talking
     *
     * @param pspeach1 the new speach of the character
     */
    public void setspeach1(String pspeach1) {
        speach1 = pspeach1;
    }

    /**
     * Set the speach1 of the talking
     *
     * @param pspeach2 the new speach of the character
     */
    public void setspeach2(String pspeach2) {
        speach2 = pspeach2;
    }

    /**
     * Display the 2 speaches of the talking
     * @param persuasion corresponds to the persuasion points that the player has gather during the course of the game. 
     */
    public String talk(int persuasion) {
        if (persuasion < 45){
            return getspeach1(); // Depending of the persuasion points
        } else {
            return getspeach2(); // Depending of the persuasion points
        }
    }
}
