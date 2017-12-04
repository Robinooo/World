package wor;

import javax.swing.*;
import java.awt.*;

/**
 * This class represents the player, who can move, interact with characters and
 * find items on the map.
 *
 * @author (Group 2)
 * @version (20th of November 2017)
 */
public class Player extends Character {

    //private int PersuasionBar = 200;//persuasion default value is always set on 100
    private NoteBook note; // the player's notebook
    private Room currentRoom; // the room where the player is currently
    private Inventory inv; // the player's inventory
    private int persuasionBar; // the number of persuasion points of the player
    private int lifeBar; // the player's number of points of life
    private int timeBar; // the player's remaining time (a number of minutes)
    private JFrame frame; // The frame for the code dialog box
    private JLabel label;
    private Icon icon;

    /**
     * Constructor for objects of class Player
     */
    public Player(String pname, Room pcurrentRoom, NoteBook pnote, Inventory pinv, int pper, int ppoints, int ptime) {
        name = pname;
        note = pnote;
        currentRoom = pcurrentRoom;
        inv = pinv;
        persuasionBar = pper;
        lifeBar = ppoints;
        timeBar = ptime;
    }

    /**
     * This methods allows the user to get the inventory of the player
     *
     * @return the player's inventory
     */
    public Inventory getInventory() {
        return this.inv;
    }

//    /**
//     * This method allows the user to get the persuasion points of the player
//     *
//     * @return the player's persuasion points
//     */
//    public int getPersuasion2() {
//        return this.persuasion;
//    }
//
//    /**
//     * This method allows the user to get the player's points of life
//     *
//     * @return the player's points of life
//     */
//    public int getPointsOfLife() {
//        return this.pointsoflife;
//    }
//
//    /**
//     * This method allows the user to get the time that remains to the player
//     *
//     * @return the player's time remaining (number of minutes)
//     */
//    public int getTime() {
//        return this.timeBar;
//    }
//
//    /**
//     * This method allows the game to add some persuasion points to the player
//     *
//     * @param ppersua : an integer representing the number of persuasion points
//     * to add to the player
//     */
//    public void setPersuasion2(Integer ppersua) {
//        this.persuasion = this.persuasion + ppersua;
//    }
//
//    /**
//     * This method allows the game to add some points of life to the player
//     *
//     * @param ppoints : an integer representing the number of points of life to
//     * add to the player. This integer can be positive or negative.
//     */
//    public void setPointsOfLife(Integer ppoints) {
//        this.pointsoflife = this.pointsoflife + ppoints;
//        if (this.pointsoflife <= 0) {
//            //mort
//        }
//    }
//
//    /**
//     * This method allows the game to add some points of time to the player
//     *
//     * @param ptime : an integer representing the number of minutes to add to
//     * the player. This integer can be positive or negative.
//     */
//    public void setTime(Integer ptime){
//        this.time = this.time - ptime;
//        if (this.time <= 0) {
//            //perdu
//        }
//    }

    /**
     * This method allows the player to take an item that is present in a room, add it to his 
     * inventory and update his number of persuasion points by adding the points associated to 
     * the item he is picking up
     */
    public void takeItem(JTextArea zoneTexte) {
        zoneTexte.setText("");
        if (currentRoom.listItem.size() > 0) {
            for (int i = 0; i < currentRoom.listItem.size(); i++) {
                inv.addItems(currentRoom.getItem(i));
                setPersuasion(currentRoom.getItem(i).getPersupoints()); // add the persuasion points associated with the item to the player

                zoneTexte.append(currentRoom.getItem(i).getDescription() + "\n ");
                note.addText(currentRoom.getItem(i).getDescription() + "\n");
                currentRoom.listItem.remove(i);
                i--;
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

        setTime(1);
        if (currentRoom.containsDirection(direction)) {
            testRoom = currentRoom.getRoom(direction);
            if (testRoom.getDoor() != null) {
                if (testRoom.getDoor().isOpenable() == true) { //if isOpenable -> true if is openable
                    nextRoom = currentRoom.getRoom(direction);
                } else {
                    if (testRoom.getDoor().getHaveCodeLock()) { // Door have a code lock
                        if (!inv.ItemsList.isEmpty()) {
                            String testCodeDoor = dialogCodeInput();
                            boolean test = testRoom.getDoor().openDoorPass(testCodeDoor);
                            if (test) { // Try each object from the inventory -> return true if the door is unlock
                                testRoom.getDoor().setOpenable(true);
                                nextRoom = currentRoom.getRoom(direction);
                                setTime(2);
                            } else {
                                nextRoom = currentRoom;
                            }
                        } else {
                            nextRoom = currentRoom;
                        }
                    } 
                    else { // Door have a key Lock
                        if (!inv.ItemsList.isEmpty()) {
                            for (int i = 0; i < inv.ItemsList.size(); i++) {
                                boolean test = testRoom.getDoor().openDoorKey(inv.ItemsList.get(i).getName());
                                if (test) {
                                    testRoom.getDoor().setOpenable(true);
                                    nextRoom = currentRoom.getRoom(direction);
                                    setTime(2);
                                    break;
                                } else {
                                    nextRoom = currentRoom;
                                }
                            }
                        } else {
                            nextRoom = currentRoom;
                        }
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

    public void explore(JTextArea zoneTexte) {

        if (currentRoom.listItem.size() > 0) {
            zoneTexte.setText(currentRoom.listItem.size() + " items in the room.");
            for (int i = 0; i < currentRoom.listItem.size(); i++) {
                if (currentRoom.listItem.get(i).getHidden()) {
                    //setTime(10);
                    setTime(4);

                } else {
                    //setTime(5);
                    setTime(2);

                }
            }
        } else {
            //setTime(5);
            setTime(2);

            zoneTexte.setText("There is no items here, you have lost precious time exploring for nothing \n");
        }
        // on perd 5 minutes de temps des qu'on explore si il y pas d'item ou si un item n'est pas caché 
        // on perds 10 minutes si un item est caché

    }

    public void speak(JTextArea zoneTexte) {
        if (currentRoom.getTalkingInTheRoom() == null) {
            setTime(2);
            zoneTexte.setText("There is no one to talk to here, you think about talking to yourself and loose 5 minutes of your precious time \n");
        } 
        else if (currentRoom.getFollowerInTheRoom() != null) {
            setTime(2);
            zoneTexte.setText(currentRoom.getFollowerInTheRoom().follow2(persuasionBar) + "\n"); 
            note.addText(currentRoom.getFollowerInTheRoom().getName() + " : " + currentRoom.getFollowerInTheRoom().follow2(persuasionBar) + "\n");
        }
        else {
            //setTime(5);
            setTime(2);
            zoneTexte.setText(currentRoom.getTalkingInTheRoom().talk(persuasionBar) + "\n");
            note.addText(currentRoom.getTalkingInTheRoom().getName() + " : " + currentRoom.getTalkingInTheRoom().talk(persuasionBar) + "\n");
        } 

        
        
        
    }

    public int getPersuasion() {
        return persuasionBar;
    }

    public void setPersuasion(Integer ppersua) {
        persuasionBar = persuasionBar + ppersua;
    }

    /**
     * This method allow to add 10 points to the Persuasion bar of the player
     */
    public void add10Persuasion() {
        if (persuasionBar >= 90) {
            setPersuasion(100);
        } else {
            setPersuasion(persuasionBar + 10);
        }
    }

    /**
     * This method allow to delete 10 points to the Persuasion bar of the player
     */
    public void del10Persuasion() {
        if (persuasionBar <= 10) {
            setPersuasion(0);
        } else {
            setPersuasion(persuasionBar - 10);
        }
    }

    public int getLife() {
        return lifeBar;
    }

    public void setLife(Integer plife) {
        lifeBar = lifeBar - plife;
    }

    public int getTime() {
        return timeBar;
    }

    /**
     * setter for the Persuasion attribute
     *
     * @param k Persuasion value between 0 and 100
     */
//    public void setPersuasion(int k){
//        if(k <= 100 && k >= 0){
//        PersuasionBar=k;
//        }
//    }
    public void setTime(Integer ptime) {
        timeBar = timeBar - ptime;
    }

    /**
     * Sets the text displayed at the bottom of the frame.
     */
    void setLabel(String newText) {
        label.setText(newText);
    }

    private String dialogCodeInput() {
        //System.out.println("Test");
        String s = (String) JOptionPane.showInputDialog(
                frame,
                "Enter your code:\n",
                "Code Dialog",
                JOptionPane.PLAIN_MESSAGE,
                icon,
                null,
                "");

        //If a string was returned, say so.
        if ((s != null) && (s.length() > 0)) {
            return s;
        }
        else{
            System.out.println("Enter your code please");
            return "";
        }
    }
}
