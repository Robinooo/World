package wor;

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
    public Player(String pname, Room pcurrentRoom, NoteBook pnote, Inventory pinv) {
        name = pname;
        note = pnote;
        currentRoom = pcurrentRoom;
        inv = pinv;
        persuasion = 0;
        pointsoflife = 100;
        time = 120;
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
    public void setTime(Integer ptime) {
        this.time = this.time + ptime;
        if (this.time <= 0) {
            //perdu
        }
    }

    /**
     * This method allows the player to take an item that is present in a room, add it to his 
     * inventory and update his number of persuasion points by adding the points associated to 
     * the item he is picking up
     */
    public void takeItem() {
        if (currentRoom.listItem.size() > 0) {
            for (int i = 0; i < currentRoom.listItem.size(); i++) {
                //inv.addObject(currentRoom.listItem.get(i));
                 inv.addItems(currentRoom.getItem(i));
                 setPersuasion(currentRoom.getItem(i).getPersupoints()); // add the persuasion points associated with the item to the player
            }
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
            if (testRoom.getDoor() != null) { //if there is a door
                System.out.println("There is a door in the Room");
                if (testRoom.getDoor().isOpenable() == true) { //if isOpenable -> true if is openable
                    nextRoom = currentRoom.getRoom(direction);
                    System.out.println("The door is openable");
                } else { //if openable is false... Try a Key or a Code
                    System.out.println("The door is not openable. There is a key or a code to use");
                    if (testRoom.getDoor().getHaveCodeLock()) { //if it's a code lock
                        System.out.println("It's a code lock");
                        for (int i = 0; i < inv.ItemsList.size(); i++) {
                            boolean test = testRoom.getDoor().openDoorPass(inv.ItemsList.get(i).getName());
                            System.out.println("\nThe boolean of codeLock:" + test + "\n");
                            if (test) { // Try each object from the inventory -> return true if the door is unlock
                                testRoom.getDoor().setOpenable(true);
                                nextRoom = currentRoom.getRoom(direction);
                                System.out.println("On est rentré dans la room");
                            } else {
                                nextRoom = currentRoom;
                                System.out.println("We don't have the Code -> We can't enter into the room");
                            }
                        }
                    } else {
                        System.out.println("It's a keyLock");
                        for (int i = 0; i < inv.ItemsList.size(); i++) {
                            boolean test = testRoom.getDoor().openDoorKey(inv.ItemsList.get(i).getName());
                            System.out.println("\nThe boolean of keyLock:" + test + "\n");
                            if (test) { // Try each object from the inventory -> return true if the door is unlock
                                System.out.println("The door is unlock. We can enter into the room");
                                testRoom.getDoor().setOpenable(true);
                                nextRoom = currentRoom.getRoom(direction);
                            } else {
                                nextRoom = currentRoom;
                                System.out.println("We don't have the key to enter into the room");
                            }
                        }
                    }
                }
            } else // there is no door
            {
                System.out.println("There is no door in this room");
                nextRoom = currentRoom.getRoom(direction);
            }
        } else {
            nextRoom = currentRoom;
            System.out.println("This direction doesn't exist...");
        }
        // System.out.println("You are " + currentRoom.getDescription());
        // System.out.print("Exits: ");
        // currentRoom.displayRoomInformations(); 
        // System.out.println();
        //System.out.println(nextRoom.getRoomName());
        currentRoom = nextRoom;
        System.out.println(currentRoom.getRoomName());

        // public void move (Exit pexit){
        // if(currentRoom.checkExitInRoomExits(pexit){
        // setCurrentRoom(pexit.getNextRoom());
        // }
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void explore() {
        if (currentRoom.getItemsInTheRoom() == null) {
            setTime(5);
        } else if (currentRoom.listItem.size() > 0) {
            for (int i = 0; i < currentRoom.listItem.size(); i++) {
                if (currentRoom.listItem.get(i).getHidden()) {
                    setTime(10);
                } else {
                    setTime(5);
                }
            }

        }
    }

    public void speak() {
        if (currentRoom.getCharaInTheRoom() == null) {
            //btSpeak.setEnabled(false);
            // World.zoneTexte.append("There is no character to talk to here, maybe think about talking to yourself");
            System.out.println("There is no one to talk to here, you think about talking to yourself and loose 5 minutes of your precious time");
            setTime(5);
        } else {
            currentRoom.getTalkingInTheRoom().talk(persuasion);
            setTime(5);
        }

    }

    // on perd 5 minutes de temps des qu'on explore si il y pas d'item ou si un item n'est pas caché 
    // on perds 10 minutes si un item est caché
}
