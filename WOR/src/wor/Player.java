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

    //private int PersuasionBar = 200;//persuasion default value is always set on 100
    private NoteBook note; // the player's notebook
    private Room currentRoom; // the room where the player is currently
    private Inventory inv; // the player's inventory
    private Inventory inv2; // the player's inventory
    private int persuasionBar; // the number of persuasion points of the player
    private int lifeBar; // the player's number of points of life
    private float timeBar; // the player's remaining time (a number of minutes)
    private boolean follow = false; // A boolean to know if the Follower charcacter follow us. true if she is followinf us
    private JFrame frame; // The frame for the code dialog box
    private Icon icon;
    private Sounds s;

    /**
     * Constructor for objects of class Player
     * @param pname the name of the player
     * @param pcurrentRoom the current room of the player
     * @param pnote the notebook of the player
     * @param pinv the inventory of the player
     * @param pper the point of persuasion of the player
     * @param ppoints the point of life of the player
     * @param ptime the point of time of the player
     * @param pinv2 a second inventory with all the items
     */
    public Player(String pname, Room pcurrentRoom, NoteBook pnote, Inventory pinv, int pper, int ppoints, int ptime, Inventory pinv2) {
        name = pname;
        note = pnote;
        currentRoom = pcurrentRoom;
        inv = pinv;
        persuasionBar = pper;
        lifeBar = ppoints;
        timeBar = ptime;
        inv2 = pinv2;
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
     * Method to return the inventory of the player
     * @return The inventory
     */
    public Inventory getInventory2() {
        return this.inv2;
    }

    /**
     * This method allows the player to take an item that is present in a room,
     * add it to his inventory and update his number of persuasion points by
     * adding the points associated to the item he is picking up
     * 
     * 
     * @param zoneTexte the text area where the text is display 
     */
    public void takeItem(JTextArea zoneTexte) {
        zoneTexte.setText("");
        if (currentRoom.listItem.size() > 0) {
            for (int i = 0; i < currentRoom.listItem.size(); i++) {
                inv.addItems(currentRoom.getItem(i));
                setPersuasion(currentRoom.getItem(i).getPersupoints()); // add the persuasion points associated with the item to the player
                //setPersuasion(5);
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
        setTime(1);
        if (currentRoom.containsDirection(direction)) { // If the direction exist
            if (currentRoom.getRoom(direction).getDoor() != null) { // There is a door 
                if (currentRoom.getRoom(direction).getDoor().isOpenable() == true) { //if isOpenable -> true if is openable
                    s.playSoundSingle("music/porte_verrou.wav");
                    nextRoom = currentRoom.getRoom(direction);
                } else {
                    if (currentRoom.getRoom(direction).getDoor().getHaveCodeLock()) { // Door have a code lock
                        nextRoom = tryToOpenDoorPass(currentRoom.getRoom(direction), direction);
                    } else { // Door have a key Lock
                        nextRoom = tryToOpenDoorLock(currentRoom.getRoom(direction), direction);
                    }
                }
            } else { // there is no door
                nextRoom = currentRoom.getRoom(direction);
            }
        } else {
            nextRoom = currentRoom;
            putMessage("Sorry,you can't go in this direction", "Impossible way");
        }
        currentRoom = nextRoom;
    }

    /**
     * A methode that return the new room if you have the rigth key for the
     * right door
     *
     * @param testRoom A parameter to try the room
     * @param direction The direction that want to go the user
     * @return Return the new room of the user
     */
    private Room tryToOpenDoorLock(Room testRoom, String direction) {
        if (!inv.ItemsList.isEmpty()) {
            for (int i = 0; i < inv.ItemsList.size(); i++) {
                if (testRoom.getDoor().openDoorKey(inv.ItemsList.get(i).getName())) {
                    testRoom.getDoor().setOpenable(true);
                    s.playSoundSingle("music/porte_verrou.wav");
                    setTime(2);
                    return currentRoom.getRoom(direction);
                }
            }
        }
        putMessage("Sorry, but this door is close\n and you don't have the key or the code", "Door");
        return currentRoom;
    }

    /**
     * A methode that return the new room if you have the rigth password for the
     * right door
     *
     * @param testRoom A parameter to try the room
     * @param direction The direction that want to go the user
     * @return Return the new room of the user
     */
    private Room tryToOpenDoorPass(Room testRoom, String direction) {
        if (!inv.ItemsList.isEmpty()) {
            for (int i = 0; i < inv.ItemsList.size(); i++) {
                if (testRoom.getDoor().getCodeLock().getName().equals(inv.ItemsList.get(i).getName())) {
                    String testCodeDoor = dialogCodeInput();
                    if (testRoom.getDoor().openDoorPass(testCodeDoor)) { // Try the code in the room -> return true if the door is unlock
                        testRoom.getDoor().setOpenable(true);
                        s.playSoundSingle("music/porte_verrou.wav");
                        setTime(2);
                        return currentRoom.getRoom(direction);
                    }
                }
            }
        }
        putMessage("Sorry, but this door is close\n and you don't have the key or the code", "Door");
        return currentRoom;
    }

    /**
     * A method to return the current room of the player
     * @return Current room of the player
     */
    public Room getCurrentRoom() {
        return currentRoom;
    }

    /**
     * Method to change the value of the boolean follow
     *
     * @param bool Boolean to say if the player is follow or not (true : player
     * follow)
     */
    public void setFollow(boolean bool) {
        follow = bool;
    }

    /**
     * A getter method to know if the player is follow or not (true : player
     * follow)
     *
     * @return The Boolean that say if the player is follow or not (true :
     * player follow)
     */
    public boolean getFollow() {
        return follow;
    }

    /**
     *
     * @param zoneTexte The area text where the text is displayed
     */
    public void explore(JTextArea zoneTexte) {
        if (currentRoom.listItem.size() > 0) {
            zoneTexte.setText(currentRoom.listItem.size() + " items in the room.");
            for (int i = 0; i < currentRoom.listItem.size(); i++) {
                if (currentRoom.listItem.get(i).getHidden()) {
                    setTime(4);
                } else {
                    setTime(2);
                }
            }
        } else {
            setTime(2);
            zoneTexte.setText("There is no items here, you have lost precious time exploring for nothing \n");
        }
        // on perd 5 minutes de temps des qu'on explore si il y pas d'item ou si un item n'est pas caché 
        // on perds 10 minutes si un item est caché
    }

    /**
     * A method to speak with a character 
     * @param zoneTexte The specif area of click by the user of the game
     */
    public void speak(JTextArea zoneTexte) {
        if (currentRoom.getTalkingInTheRoom() != null) {
            setTime(2);
            zoneTexte.setText(currentRoom.getTalkingInTheRoom().getName() + " : " + currentRoom.getTalkingInTheRoom().talk(persuasionBar) + "\n");
            note.addText(currentRoom.getTalkingInTheRoom().getName() + " : " + currentRoom.getTalkingInTheRoom().talk(persuasionBar) + "\n");
        } else if (currentRoom.getFollowerInTheRoom() != null) {
            setTime(2);
            zoneTexte.setText(currentRoom.getFollowerInTheRoom().getName() + " : " +currentRoom.getFollowerInTheRoom().getspeech() + "\n");
            note.addText(currentRoom.getFollowerInTheRoom().getName() + " : " + currentRoom.getFollowerInTheRoom().getspeech() + "\n");
        } else if (currentRoom.getKillerInTheRoom() != null) {
            setTime(2);
            zoneTexte.setText(currentRoom.getKillerInTheRoom().getName() + " : " + currentRoom.getKillerInTheRoom().getspeech() + "\n");
            note.addText(currentRoom.getKillerInTheRoom().getName() + " : " + currentRoom.getKillerInTheRoom().getspeech() + "\n");
        } else {
            setTime(2);
            zoneTexte.setText("There is no one to talk to here, you think about talking to yourself and loose 5 minutes of your precious time \n");
        }
    }

    /**
     * A method to return the persuasion of the player
     * @return the persuasion of the player
     */
    public int getPersuasion() {
        return persuasionBar;
    }

    /**
     * Modifer for the persiasion of the player
     * @param ppersua point of persuasion of the player
     */
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

    /**
     * A method to return the life point of the player
     * @return the life point of the player
     */
    public int getLife() {
        return lifeBar;
    }

    /**
     * Modifier of the life point of the player
     * @param plife point of life who are modified
     */
    public void setLife(Integer plife) {
        lifeBar = lifeBar - plife;
    }

    /**
     * A method to return the time of the player
     * @return the time of the player
     */
    public float getTime() {
        return timeBar;
    }

    /**
     * A modifier of the time of the player
     * @param ptime modified the time of the player
     */
    public void setTime(int ptime) {
        float temp = ptime;
        if (follow == true) {
            timeBar = timeBar - (temp / 2);
        } else {
            timeBar = timeBar - temp;
        }
        System.out.println(timeBar);
    }

    /**
     * A method to put a specifi message when the user of the game want to open
     * a door closed by a password.
     * @return A message
     */
    private String dialogCodeInput() {
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
        } else {
            System.out.println("Enter your code please");
            return "";
        }
    }
}
