package wor;

import java.util.*;
import java.util.HashMap;
import javax.swing.*;

/**
 * The Room class represents one location in the scenery of the game. It is
 * connected to other rooms.
 *
 * @author GR2
 * @version 20/11/17
 */
public class Room {

    // instance variables - replace the example below with your own
    private String roomName; // the name of the room
    private Character chara; // the character present in the room
    private Talking talking; // the talking character present in the room
    private Killer killer; // the killer present in the room
    private Follower follower; // the follower present in the room
    protected ArrayList<Item> listItem; // the list of item of the player
    private Door door; // the door of the room
    private String description; // the description of the room
    private Icon imgplan; // the image of the map
    private Icon img; // the image associated to the room
    private JButton bou; // button
    private JPanel panel;

    private boolean noir; // if the room is dark
    private boolean gaz; // if the room is full of gaz
    private boolean director; // if the director is in the room
    private HashMap<String, Room> myHashRoom; // the HashMap representing the map

    /**
     * The constructor of the room. A room is represented by the a name, a
     * description, a door, an image and the image of the plan
     *
     * @param proomName The room's name.
     * @param pdescription The room's description.
     * @param pdoor The door of the room
     * @param pimg The name of the image
     */
    public Room(String proomName, String pdescription, Door pdoor, Icon pimg, Icon pimgplan) {
        roomName = proomName;
        description = pdescription;
        chara = null; // at the beginning, there is no character in the room
        door = pdoor;
        img = pimg;
        imgplan = pimgplan;
        listItem = new ArrayList<Item>();
        gaz = false; // at the beginning,there is no gas in the room
        noir = false; // at the beginning, the room is not dark
        director = false; // at the beginning, the director is not in the room
        myHashRoom = new HashMap<String, Room>();
        bou = null;
        panel = null;
    }

    /**
     * The getRoomName method gets the name of the room
     *
     * @return roomName, the name of the room
     */
    public String getRoomName() {
        return roomName;
    }

    /**
     * The getDescription method gets the description of the room
     *
     * @return The description of the room.
     */
    public String getDescription() {
        return description;
    }

    /**
     * The getImage method get the image associated to the room
     *
     * @return img, the image of the room
     */
    public Icon getImage() {
        return img;
    }

    /**
     * The getButton method, gets the buttons
     *
     * @return bou, the buttons specific to the room
     */
    public JButton getButton() {
        return bou;
    }

    /**
     * The getImagePlan method gets the player location in the map
     *
     * @return imgPlan
     */
    public Icon getImagePlan() {
        return imgplan;
    }

    /**
     * The getNoir method gets the boolean, to know if the room is dark or not
     *
     * @return noir, True if the room is dark
     */
    public boolean getNoir() {
        return noir;
    }

    /**
     * The getGaz method gets the boolean to know if the room is full of gas or
     * not
     *
     * @return gaz, true if the room is full of gas
     */
    public boolean getGaz() {
        return gaz;
    }

    /**
     * The getDirector method gets the boolean telling if the director is in the
     * room or not
     *
     * @return director, true if the director is in the room
     */
    public boolean getDirector() {
        return director;
    }

    /**
     * The getDoor method gets the doors of the room
     *
     * @return the door of the room.
     */
    public Door getDoor() {
        return door;
    }

    /**
     * The getItemsInTheRoom returns the list of items situated in the current
     * room.
     *
     * @return listItem
     */
    public ArrayList<Item> getItemsInTheRoom() {
        return listItem;
    }

    /**
     * Returns the talking character present in the room
     *
     * @return talking
     */
    public Talking getTalkingInTheRoom() {
        return talking;
    }

    /**
     * Returns the follower present in the room
     *
     * @return follower
     */
    public Follower getFollowerInTheRoom() {
        return follower;
    }

    /**
     * Returns the panel
     *
     * @return panel
     */
    public JPanel getPanel() {
        return panel;
    }

    /**
     * Adds an item to the item list of the current room.
     *
     * @param pitem Item to be added
     */
    public void addItem(Item pitem) {
        listItem.add(pitem);
    }

    /**
     * Set the exit into the HashMap "myHashRoom"
     *
     * @param direction The direction given by the user
     * @param proom The current room of the user
     */
    public void setExit(String direction, Room proom) {
        myHashRoom.put(direction, proom);
    }

    /**
     * A method to know if the direction given by the user is present into the
     * HashMap "myHashRoom" return false if not present
     *
     * @param direction The direction given by the user
     * @return false if not present or true if the direction is present
     */
    public boolean containsDirection(String direction) {
        return myHashRoom.containsKey(direction);
    }

    /**
     * A method to get the name of the room thanks to the direction.
     *
     * @param key The direction given by the user
     * @return The name of the room
     */
    public Room getRoom(String key) {
        return myHashRoom.get(key);
    }

    /**
     * Set the name of the Room
     *
     * @param proomName the roomName to set
     */
    public void setRoomName(String proomName) {
        roomName = proomName;
    }

    /**
     * Set the type of the room, the room is a black room
     *
     * @param pNoir if the boolean is true -> black , false : not black
     *
     */
    public void setNoir(boolean pNoir) {
        noir = pNoir;
    }

    /**
     * Set the type of the room, the room is gas room
     *
     * @param pGaz true if the room is full of gas
     */
    public void setGaz(boolean pGaz) {
        gaz = pGaz;
    }

    /**
     * Set the type of the room, the room is the room of the director
     *
     * @param pDirector if the boolean is true -> there is the director, false :
     * not the director;
     */
    public void setDirector(boolean pDirector) {
        director = pDirector;
    }

    /**
     * Add a Talking character to the room
     *
     * @param pTalking The character added to the room;
     */
    public void addCharacter(Talking pTalking) {
        talking = pTalking;
    }

    /**
     * Add a Button to the room
     *
     * @param pbou The boutton added to the room;
     */
    public void addButton(JButton pbou) {
        bou = pbou;
    }

    /**
     * Add a Button to the room
     *
     * @param panelp The panel;
     */
    public void addPanel(JPanel panelp) {
        panel = panelp;
    }

    /**
     * Add a killer character to the room
     *
     * @param pKiller The character added to the room;
     */
    public void addKiller(Killer pKiller) {
        killer = pKiller;
    }

    /**
     * Add a Following character to the room
     *
     * @param pFollower The follower added to the room;
     */
    public void addFollower(Follower pFollower) {
        follower = pFollower;
    }

    /**
     * Set the room description
     *
     * @param s The new description of the room
     */
    public void setRoomDescription(String s) {
        description = s;
    }

    /**
     * Gets the items present in the room
     *
     * @param indice
     * @return the list of item in the room
     */
    public Item getItem(int indice) {
        return listItem.get(indice);
    }

    /**
     * Sets the image of the room
     *
     * @param image, the new image of the room
     */
    public void setImage(Icon image) {
        img = image;
    }
}
