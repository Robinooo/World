package wor;

import javax.swing.*;

/**
 * This class is used to create objects that will be usable by the player during
 * the game.
 *
 * An item can be hidden or not. If the item is hidden, the player will have to
 * explore the room in order to find it (which will make him loose some time). 
 * An item can be used or not. If use is true, the item is usable.
 *
 * @author Group 2
 * @version 11/20/17
 */
public class Item {

    private String name; // the name of the item
    private String description; // a short description of the item
    private boolean use; // the item is usable (or not)
    private boolean hidden; // the item is hidden (or not)
    private int persupoints; // number of persuasion points added the player points
    private Icon imgItem; // the image associated to the item
            
    /**
     * Constructor for objects of class Item. An item is represented by its name, its 
     * description, the number of persuasion points it adds to the player, and an 
     * image. 
     * @param name, the name of the item
     * @param description, the description of the item 
     * @param persupoints, the number of persuasion points it gives to the player 
     * @param pitem, the image representing the item
     */
    public Item(String name, String description, int persupoints, Icon pitem) {
        this.name = name;
        this.description = description;
        this.use = true;
        this.hidden = false; 
        this.imgItem = pitem;
    }

    /**
     * The getName method gets the name of the item.
     * @return name of the item
     */
    public String getName() {
        return name;
    }

    /**
     * The getDescription method gets the description of the item
     * @return the item's description
     */
    public String getDescription() {
        return description;
    }

    /**
     * The getHidden method gets the boolean telling if an item is hidden or not
     * @return the value of the boolean "hidden". True is the item is hidden.
     */
    public boolean getHidden() {
        return hidden;
    }

    /**
     * The setHidden method sets if a boolean is hidden. 
     * @param b, True if the item is hidden.
     */
    public void setHidden(boolean b) {
        hidden = b;
    }

    /**
     * The getUse method gets the boolean if an item is usable or not.
     * @return the value of the boolean use. True if the item is usable.
     */
    public boolean getUse() {
        return use;
    }

    /**
     * The setUse method sets the use boolean : tells the user if an item is 
     * usable or not.
     * @param b. True if the item is usable.
     */
    public void setUse(boolean b) {
        use = b;
    }
    
    /**
     * The getPersupoints method gets the number of persuasion points given by the item.
     * @return persupoints, the number of persuasion points
     */
    public int getPersupoints() {
        return persupoints;
    }      
    
    /**
     * The getImageItem method gets the image associated to the item.
     * @return imgItem, the image associated to the item.
     */
    public Icon getImageItem() {
        return imgItem;
    }
}
