package wor;

import java.util.*;
import javax.swing.JOptionPane;

/**
 * The class Character represent a character , with a strng, and his current
 * room.
 *
 * @author Group2
 * @version 11/20/2017
 */
public abstract class Character {

    protected String name; // The name of the character
    protected Room currentRoom; // The current room of the character

    /**
     * Constructor for objects of class Character.
     */
    public Character() {

    }

    /**
     * Get the name of the character.
     *
     * @return name Returns the name of the character
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the character.
     *
     * @param pName The name of the character
     */
    public void setName(String pName) {
        name = pName;
    }

    /**
     * Get the current room of the character.
     *
     * @return Returns the current room of the character
     */
    public Room getCurrentRoom() {
        return currentRoom;
    }

    /**
     * Set the name of the character.
     *
     * @param pcurrentRoom The current room of the character
     */
    public void setCurrentRoom(Room pcurrentRoom) {
        currentRoom = pcurrentRoom;
    }
    
     /**
     * A method to print a message
     * @param message1 The message you want to print
     * @param message2 The name of the pop-up (or window)
     */
    protected void putMessage(String message1, String message2) {
        JOptionPane.showMessageDialog(null,
                message1,
                message2,
                JOptionPane.INFORMATION_MESSAGE);
    }
}
