package wor;

import java.util.*;
/**
 * The class Character represent a character , with a strng, and his current room. A character can be lier.  
 *
 * @author Group2
 * @version 11/20/2017
 */
public abstract class Character 
{
    protected String name; // The name of the character
    protected Room currentRoom; // The current room of the character
    protected boolean isLier; // If the character is a lier or not (true if is a lier)
    
    /**
     * Constructor for objects of class Character. 
     * At first, a character is not a lier, have a name and is located in a specif room
     * 
     * @param name The name of the character
     * @param currentRoom The current room of a character
     */
    public Character()
    {
        
    }
    
    /**
     * Get the name of the character. 
     * 
     * @return name Returns the name of the character
     */
    public String getName() 
    {
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
    public Room getCurrentRoom()
    {
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
}
