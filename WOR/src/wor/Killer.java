package wor;

import javax.swing.ImageIcon;

/**
 * This class is used to create a killer character, the killer can try to kill
 * the player if they meet during the game.
 *
 * @author Group 2
 * @version 11/20/17
 */
public class Killer extends Character {

    public Sounds s;
    private String speech;

    /**
     * Constructor for objects of class Killer. The killer is represented by a
     * name.
     *
     * @param name, the name of the killer
     */
    public Killer(String n, String s) {
        name = n.toUpperCase();
        speech = s;
    }

    
        /**
     * A getter to know the speech of the killer
     *
     * @return the speech of the killer
     */
    public String getspeech() {
        return speech;
    }
    
    /**
     * If the player meet the killer, the killer will try to kill him as well.
     * The player will lose time and life points, if time or life points goes to
     * 0, the player dies in the process...
     */
    public void kill(Player player1, int bt) {
        if ("barn 2".equals(player1.getCurrentRoom().getRoomName())) {
            if (player1.getCurrentRoom().getNoir()) {
                boolean survival = false;
                s.playSoundSingle("music/combat.wav");
                putMessage("You hear something approaching. It attacks you!", "Ambush");
                if (!player1.getInventory().ItemsList.isEmpty()) {
                    for (int i = 0; i < player1.getInventory().ItemsList.size(); i++) {
                        if (player1.getInventory().ItemsList.get(i).getName().equals("Shield")) {
                            putMessage("You take out your shield in haste.\nThe weapon hits your shield and your attacker runs away.\nYou turn on the light, there is no one in the room.", "Ambush");
                            survival = true;
                            player1.getCurrentRoom().setImage(new ImageIcon(getClass().getResource("/pictures2/grange2.jpg")));
                            player1.getCurrentRoom().setNoir(false);
                            bt = 1;
                            break;
                        }
                    }
                }
                if (!survival) {
                    putMessage("You had nothing to deflect the blade that hit you.\nThe blow touched a vital point. \nYou will not get away this time ...", "Ambush");
                    InterfaceGameOver theEnd = new InterfaceGameOver();
                    bt = 0;
                }
            } else {
                bt = 1;
            }
        }
    }
}
