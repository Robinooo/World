package wor;

import javax.swing.*;

/**
 * This class represents the player, who can move, interact with characters and
 * find items on the map.
 *
 * @author (Group 2)
 * @version (20th of November 2017)
 */
public class Player extends Character {

    private NoteBook note; // the player's notebook
    private Room currentRoom; // the room where the player is currently
    private Inventory inv; // the player's inventory
    private int persuasion; // the number of persuasion points of the player
    private int pointsoflife; // the player's number of points of life
    private int time; // the player's remaining time (a number of minutes)

    /**
     * Constructor for objects of class Player
     */
    public Player(String pname, Room pcurrentRoom, NoteBook pnote, Inventory pinv, int pper, int ppoints, int ptime) {
        name = pname;
        note = pnote;
        currentRoom = pcurrentRoom;
        inv = pinv;
        persuasion = pper;
        pointsoflife = ppoints;
        time = ptime;
    }

    /**
     * This methods allows the user to get the inventory of the player
     *
     * @return the player's inventory
     */
    public Inventory getInventory() {
        return this.inv;
    }

    /**
     * This method allows the user to get the persuasion points of the player
     *
     * @return the player's persuasion points
     */
    public int getPersuasion() {
        return this.persuasion;
    }

    /**
     * This method allows the user to get the player's points of life
     *
     * @return the player's points of life
     */
    public int getPointsOfLife() {
        return this.pointsoflife;
    }

    /**
     * This method allows the user to get the time that remains to the player
     *
     * @return the player's time remaining (number of minutes)
     */
    public int getTime() {
        return this.time;
    }

    /**
     * This method allows the game to add some persuasion points to the player
     *
     * @param ppersua : an integer representing the number of persuasion points
     * to add to the player
     */
    public void setPersuasion(Integer ppersua) {
        this.persuasion = this.persuasion + ppersua;
    }

    /**
     * This method allows the game to add some points of life to the player
     *
     * @param ppoints : an integer representing the number of points of life to
     * add to the player. This integer can be positive or negative.
     */
    public void setPointsOfLife(Integer ppoints) {
        this.pointsoflife = this.pointsoflife + ppoints;
        if (this.pointsoflife <= 0) {
            //mort
        }
    }

    /**
     * This method allows the game to add some points of time to the player
     *
     * @param ptime : an integer representing the number of minutes to add to
     * the player. This integer can be positive or negative.
     */
    public void setTime(Integer ptime){
        this.time = this.time - ptime;
        if (this.time <= 0) {
            //perdu
        }
    }

    /**
     * This method allows the player to take an item that is present in a room, add it to his 
     * inventory and update his number of persuasion points by adding the points associated to 
     * the item he is picking up
     */
    public void takeItem(JTextArea zoneTexte) {
        zoneTexte.setText("");
        if (currentRoom.listItem.size() > 0) {
            for (int i = 0; i < currentRoom.listItem.size(); i++) {
                //inv.addObject(currentRoom.listItem.get(i));
                 inv.addItems(currentRoom.getItem(i));
                 setPersuasion(currentRoom.getItem(i).getPersupoints()); // add the persuasion points associated with the item to the player
                 zoneTexte.append(currentRoom.getItem(i).getDescription() + "\n ");
                 note.addText(currentRoom.getItem(i).getDescription());
                 currentRoom.listItem.remove(i);
//                 if (i > 0) {
                     i--;
//                 }
            }
            inv.displayItems(inv.ItemsList);
        }
    }

    /**
     * This method represents the movements of the player in the map : the
     * player can change of room when it is possible.
     *
     * @param direction : north, east... Represents the direction of the
     * movement of the player
     */
    public void move(String direction) {

        Room nextRoom = null;
        Room testRoom = null; // Room to try the door of a room 

        if (currentRoom.containsDirection(direction)) {
            testRoom = currentRoom.getRoom(direction);
            if (testRoom.getDoor() != null) {
                if (testRoom.getDoor().isOpenable() == true) { //if isOpenable -> true if is openable
                    nextRoom = currentRoom.getRoom(direction);
                } 
                else {
                    if (testRoom.getDoor().getHaveCodeLock()) {
                        for (int i = 0; i < inv.ItemsList.size(); i++) {
                            boolean test = testRoom.getDoor().openDoorPass(inv.ItemsList.get(i).getName());
                            if (test) { // Try each object from the inventory -> return true if the door is unlock
                                testRoom.getDoor().setOpenable(true);
                                nextRoom = currentRoom.getRoom(direction);
                            } else {
                                nextRoom = currentRoom;
                            }
                        }
                    } 
                    else {
                        System.out.println("1");
                        if (!inv.ItemsList.isEmpty()) {
                        for (int i = 0; i < inv.ItemsList.size(); i++) {
                            System.out.println("2");
                            boolean test = testRoom.getDoor().openDoorKey(inv.ItemsList.get(i).getName());
                            if (test) {
                                System.out.println("3");
                                testRoom.getDoor().setOpenable(true);
                                nextRoom = currentRoom.getRoom(direction);
                            } 
                            else {
                                System.out.println("4");
                                nextRoom = currentRoom;
                            }
                            System.out.println("5");
                        }} else { nextRoom = currentRoom; }
                        System.out.println("6");
                    }
                }
            } else // there is no door
            {
                nextRoom = currentRoom.getRoom(direction);
            }
        } else {
            nextRoom = currentRoom;
        }
        currentRoom = nextRoom;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }
     
     public void explore(JTextArea zoneTexte){
         
         
         if(currentRoom.listItem.size() > 0 ){
             zoneTexte.setText(currentRoom.listItem.size()+" items in the room.");
                for(int i=0; i < currentRoom.listItem.size(); i++) 
                {
                    if (currentRoom.listItem.get(i).getHidden()) {
                    setTime(10);
                    }
                    else {
                    setTime(5);
                    }
                }
            } else {                    
             setTime(10);
             zoneTexte.setText("There is no items here, you have lost precious time exploring for nothing \n");
         }
    // on perd 5 minutes de temps des qu'on explore si il y pas d'item ou si un item n'est pas caché 
    // on perds 10 minutes si un item est caché
        }

    public void speak(JTextArea zoneTexte) {
        if (currentRoom.getTalkingInTheRoom() == null) {
            setTime(5);
            zoneTexte.setText("There is no one to talk to here, you think about talking to yourself and loose 5 minutes \n of your precious time \n");
           
        } else {
             setTime(5);
            zoneTexte.setText(currentRoom.getTalkingInTheRoom().talk(persuasion)  + "\n");
        }

    }
}

     
