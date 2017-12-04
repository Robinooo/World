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
    private int persuasionBar; // the number of persuasion points of the player
    private int lifeBar; // the player's number of points of life
    private int timeBar; // the player's remaining time (a number of minutes)
    private JFrame frame; // The frame for the code dialog box
    private JLabel label;
    private Icon icon;
    private Sounds s;

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

    /**
     * This method allows the player to take an item that is present in a room,
     * add it to his inventory and update his number of persuasion points by
     * adding the points associated to the item he is picking up
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
        Room testRoom = null; // Room to try the door of a room 

        setTime(1);
        if (currentRoom.containsDirection(direction)) {
            testRoom = currentRoom.getRoom(direction);
            boolean haveKey = false;
            if (testRoom.getDoor() != null) {
                if (testRoom.getDoor().isOpenable() == true) { //if isOpenable -> true if is openable
                    s.playSoundSingle("music/porte_verrou.wav");
                    nextRoom = currentRoom.getRoom(direction);
                    haveKey = true;
                } else {
                    if (testRoom.getDoor().getHaveCodeLock()) { // Door have a code lock
                        if (!inv.ItemsList.isEmpty()) {
                            for (int i = 0; i < inv.ItemsList.size(); i++) {
                                if (testRoom.getDoor().getCodeLock().getName().equals(inv.ItemsList.get(i).getName())) {
                                    String testCodeDoor = dialogCodeInput();
                                    if (testRoom.getDoor().openDoorPass(testCodeDoor)) { // Try the code in the room -> return true if the door is unlock
                                        testRoom.getDoor().setOpenable(true);
                                        nextRoom = currentRoom.getRoom(direction);
                                        haveKey = true;
                                        setTime(2);
                                        break;
                                    }
                                }
                            }
                        }
                    } else { // Door have a key Lock
                        if (!inv.ItemsList.isEmpty()) {
                            for (int i = 0; i < inv.ItemsList.size(); i++) {
                                if (testRoom.getDoor().openDoorKey(inv.ItemsList.get(i).getName())) {
                                    testRoom.getDoor().setOpenable(true);
                                    nextRoom = currentRoom.getRoom(direction);
                                    setTime(2);
                                    haveKey = true;
                                    break;
                                }
                            }
                        }
                    }
                }
                if (!haveKey) {
                    nextRoom = currentRoom;
                    putMessageDoor();
                }
            } else // there is no door
            {
                nextRoom = currentRoom.getRoom(direction);
            }
        } else {
            nextRoom = currentRoom;
            putMessageDoor();
        }
        currentRoom = nextRoom;
    }

    /**
     *
     * @return
     */
    public Room getCurrentRoom() {
        return currentRoom;
    }

    /**
     *
     * @param zoneTexte
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

    public void speak(JTextArea zoneTexte) {
        if (currentRoom.getTalkingInTheRoom() == null) {
            setTime(2);
            zoneTexte.setText("There is no one to talk to here, you think about talking to yourself and loose 5 minutes of your precious time \n");
        } else if (currentRoom.getFollowerInTheRoom() != null) {
            setTime(2);
            zoneTexte.setText(currentRoom.getFollowerInTheRoom().getspeach() + "\n");
            note.addText(currentRoom.getFollowerInTheRoom().getName() + " : " + currentRoom.getFollowerInTheRoom().getspeach() + "\n");
        } else {
            setTime(2);
            zoneTexte.setText(currentRoom.getTalkingInTheRoom().talk(persuasionBar) + "\n");
            note.addText(currentRoom.getTalkingInTheRoom().getName() + " : " + currentRoom.getTalkingInTheRoom().talk(persuasionBar) + "\n");
        }
    }

    /**
     *
     * @return
     */
    public int getPersuasion() {
        return persuasionBar;
    }

    /**
     *
     * @param ppersua
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
     *
     * @return
     */
    public int getLife() {
        return lifeBar;
    }

    /**
     *
     * @param plife
     */
    public void setLife(Integer plife) {
        lifeBar = lifeBar - plife;
    }

    /**
     *
     * @return
     */
    public int getTime() {
        return timeBar;
    }

    /**
     *
     * @param ptime
     */
    public void setTime(int ptime) {
        timeBar = timeBar - ptime;
    }

    /**
     * Sets the text displayed at the bottom of the frame.
     */
    void setLabel(String newText) {
        label.setText(newText);
    }

    /**
     * Print a message to say a door is close
     */
    public void putMessageDoor() {
        JOptionPane.showMessageDialog(frame,
                "Sorry, but this door is close\n and you don't have the key or the code",
                "Door",
                JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     *
     * @return
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
