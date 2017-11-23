package wor;

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
    protected ArrayList<Item> listItem;
    private Door door;
    private String description;
    //private ArrayList<Exit> exitRooms; 
    private Icon img;
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

    
    public Room(String proomName, String pdescription, Door pdoor,Icon pimg)
    {
        roomName = proomName;
        description = pdescription;
        chara = null;
        door = pdoor;
        img = pimg;
        //exitRooms = new ArrayList<Exit>();
        listItem= new ArrayList<Item>();
        gaz = false;
        noir = false;
        director = false;
        myHashRoom = new HashMap<String,Room>();

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
     * @return The description of the image.
     */
    public Icon getImage() {
        return img;
    }

    /**
     * @return if the room is in the black
     */
    public boolean getNoir()
    {
        return noir;
    }

         
    /**
     * @return boolean if there is gaz in the room
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
     * @param roomName the roomName to set
     */
    public void setRoomName(String proomName) {
        roomName = proomName;
    }
    /**
     * Set the type of the room, the room is a black room
     * @param pnoir if the boolean is true -> black , false : not black
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
     * Add a character to the room
     * @param pcharacter The character added to the room;
     */
         public void addCharacter (Character pcharacter) 
         {
           chara=pcharacter;
    }

    /**
     * Displays the room description
     * @return the all the informations of a room
     */
    public void displayRoomInformations() {
        System.out.println("Current location : " + roomName);
        System.out.println(description);
        System.out.println(myHashRoom.keySet());
        // System.out.println("Available exits are : ");
        // for(Exit r: exitRooms) {
        // System.out.println(r.getNextRoom().getRoomName());
        // }
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

    // public boolean checkExitInRoomExits(Exit pexit) {
    // for(Exit e : exitRooms) {
    // if(e == pexit) {
    // return true;
    // }
    // }
    // return false;
    // }
    
}
