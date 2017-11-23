package wor;

/**
 * This class is used to create objects that will be usable by the player during
 * the game.
 *
 * An item can be hidden or not. if the item is hidden, the player will have to
 * look to find it (which will make him loose some time). An item can be use or
 * not. If use is true, the item has already been used and can't be used
 * anymore.
 *
 * @author Group 2
 * @version 11/20/17
 */
public class Item {

    private String name;
    private String description;
    private boolean use;
    private boolean hidden;
    private int persupoints;

    /**
     * Constructor for objects of class Item
     */
    public Item(String name, String description, int persupoints) {
        this.name = name;
        this.use = true;
        this.hidden = false;
    }

    /**
     * @return the item's name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the value of the boolean "hidden"
     */
    public boolean getHidden() {
        return hidden;
    }

    /**
     * Set if a boolean is hidden (false is not hidden)
     *
     * @param b will be the wanted value for hidden (true or false)
     */
    public void setHidden(boolean b) {
        hidden = b;
    }

    /**
     * @return the value of the boolean useful
     */
    public boolean getUse() {
        return use;
    }

    /**
     * Set if a boolean is usefull (false is not usefull)
     *
     * @param b will be the wanted value for useful (true or false)
     */
    public void setUse(boolean b) {
        use = b;
    }
}
