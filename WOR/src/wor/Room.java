package wor;

import java.awt.Container;
import java.util.*;
import java.util.HashMap;
import javax.swing.*;

/**
 * A "Room" represents one location in the scenery of the game. It is 
 * connected to other rooms. 
 *
 * @author GR2
 * @version 20/11/17
 */
public class Room
{
    // instance variables - replace the example below with your own
    private String roomName;
    private Character chara;
    private Talking talking;
    private Killer killer;
    private Follower follower;
    protected ArrayList<Item> listItem;
    private Door door;
    private String description; 
    private Icon  imgplan;
    private Icon img;
    private JButton bou;
    private JPanel panel;
    
    private boolean noir;
    private boolean gaz;
    private boolean director;
    private HashMap<String,Room> myHashRoom;
    /**
     * Create a room
     *
     * @param proomName The room's name.
     * @param pdescription The room's description.
     * @param pdoor The door of the room
     * @param pimg The name of the image
     */

    
    public Room(String proomName, String pdescription, Door pdoor,Icon pimg, Icon pimgplan)
    {
        roomName = proomName;
        description = pdescription;
        chara = null;
        door = pdoor;
        img = pimg;
        imgplan =pimgplan;
        //exitRooms = new ArrayList<Exit>();
        listItem= new ArrayList<Item>();
        gaz = false;
        noir = false;
        director = false;
        myHashRoom = new HashMap<String,Room>();
        bou = null;
        panel = null;
    }

    /**
     * @return the roomName
     */
    public String getRoomName() {
        return roomName;
    }

    /**
     * @return The description of the room.
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return The image of the room
     */
    public Icon getImage() {
        return img;
    }
    
    
    /**
     * @return The image of the room
     */
    public JButton getButton() {
        return bou;
    }
    
    /**
     * @return The location of the player in the room
     */
       public Icon getImagePlan() {
        return imgplan;
    }

    /**
     * @return if the room is in the black
     */
    public boolean getNoir()
    {
        return noir;
    }

         
    /**
     * @return boolean if there is gas in the room
     */
    public boolean getGaz()
    {
        return gaz;
    }

    /**
     * @return boolean if there is the director in the room
     */
      
    public boolean getDirector()
    {
        return director;
    }

    /**
     * @return the door of the room.
     */
    public Door getDoor() {
        return  door;
    }

    /**
     * Returns the list of items situated in the current room.
     * @return  ArrayList<Item> getItems    
     */
    public ArrayList<Item> getItemsInTheRoom(){
        return listItem;
    }

    
    /**
     * Returns the list of items situated in the current room.
     * @return  ArrayList<Item> getItems    
     */
    public Character getCharaInTheRoom(){
        return  chara;
    }
    
        public Talking getTalkingInTheRoom(){
        return talking ;
    }
        
         public Follower getFollowerInTheRoom(){
        return follower ;
    }
        
        public JPanel getPanel(){
        return panel;}
    
    // /**
    // * @return the exitRoom
    // */
    // public ArrayList<Exit> getExitRoom() {
    // return exitRooms;
    // }

    // /**
    // * Adds an exit to the room
    // */
    // public void addExitRoom(Exit pexitRoom) {
    // exitRooms.add(pexitRoom);
    // }
        
        
    
    /**
     * Adds an item to the item list of the current room.
     *
     * @param pitem Item to be added
     */
    public void addItem(Item pitem) {
        listItem.add(pitem);
    }

    
    
    // /**
    // * @param exitRoom the exitRoom to set
    // */
    // public void setExitRoom(ArrayList<Exit> pExitRoom) {
    // exitRooms =pExitRoom;
           
    // }
    
    
    /**
     * Set the exit into the HashMap "myHashRoom"
     * @param direction The direction given by the user
     * @param proom The curent room of the user
     */
      public void setExit(String direction, Room proom) 
    {
        myHashRoom.put(direction,proom);
    }

    
    /**
     * A method to know if the direction given by the user
     * is present into the HashMap "myHashRoom"
     * return false if not present
     * @param direction The direction given by the user
     * @return false if not present or true if the direction is present
     */
    public boolean containsDirection(String direction)
    {
        return  myHashRoom.containsKey(direction);
    }

    
    /**
     * A method to get the name of the room thanks to the direction.
     * @param key The direction given by the user
     * @return The name of the room
     */
    public Room getRoom (String key)
    {
        return myHashRoom.get(key);
    }

    
    
    /**
     * Set the name of the Room
     * @param proomName the roomName to set
     */
    public void setRoomName(String proomName) {
        roomName = proomName;
    }
    /**
     * Set the type of the room, the room is a black room
     * @param pNoir if the boolean is true -> black , false : not black
     *
     */

    public void setNoir(boolean pNoir)
    {
        noir = pNoir;

    }

    /**
     * Set the type of the room, the room is gaz room
     * @param pnoir if the boolean is true -> black , false : not black
     */
    public void setGaz(boolean pGaz)
    {
        gaz = pGaz;
    }

    /**
     * Set the type of the room, the room is the room of the director
       * @param pDirector if the boolean is true -> there is the director, false : not the director;
     */
         public void setDirector(boolean pDirector)
        {
        director = pDirector;
    }

    /**
     * Add a Talking character to the room
     * @param pTalking The character added to the room;
     */
         public void addCharacter (Talking pTalking) 
         {
           talking=pTalking;
    }
         
    /**
     * Add a Button to the room
     * @param pboug The boutton added to the room;
     */
         public void addButton (JButton pbou) 
         {
           bou=pbou;
    }     
         
  /**
     * Add a Button to the room
     * @param pboug The boutton added to the room;
     */
         public void addPanel (JPanel panelp) 
         {
           panel=panelp;
    }     
                 
 
             /**
     * Add a killer character to the room
     * @param pKiller The character added to the room;
     */
         public void addKiller (Killer pKiller) 
         {
           killer=pKiller;
    }
         
    /**
     * Add a Following character to the room
     * @param pFollowing The character added to the room;
     */
         public void addFollower (Follower pFollower) 
         {
           follower=pFollower;
    }

    /**
     * Set the room description
     * @param s The new description of the room
     */
   
    public void setRoomDescription(String s){
        description = s;
    }
    
    public Item getItem(int indice){
        return listItem.get(indice);
    }
    
    public void setImage (Icon image) {
        img = image;
    }
    
}
