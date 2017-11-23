package wor;


/**
 * This class represents the player, who can move, interact with characters and find items on the map.
 *
 * @author (Group 2)
 * @version (20th of November 2017)
 */
public class Player extends Character
{
    private NoteBook note; // the player's notebook
    public Room currentRoom; // the room where the player is currently
    private Inventory inv; // the player's inventory
    private int persuasion; // the number of persuasion points of the player
    private int pointsoflife; // the player's number of points of life
    private int time; // the player's remaining time (a number of minutes)
    /**
     * Constructor for objects of class Player
     */
    public Player(String pname, Room pcurrentRoom, NoteBook pnote, Inventory pinv)
    {
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
     * @return the player's inventory
     */
    public Inventory getInventory (){
        return this.inv;
    }

    /**
     * This method allows the user to get the persuasion points of the player
     * @return the player's persuasion points
     */
    public int getPersuasion(){
        return this.persuasion;
    }

    /**
     * This method allows the user to get the player's points of life
     * @return the player's points of life
     */
    public int getPointsOfLife(){
        return this.pointsoflife;
    }

    /**
     * This method allows the user to get the time that remains to the player
     * @return the player's time remaining (number of minutes)
     */
    public int getTime(){
        return this.time;
    }

    /**
     * This method allows the game to add some persuasion points to the player
     * @param ppersua : an integer representing the number of persuasion points to add to the player
     */
    public void setPersuasion(Integer ppersua){
        this.persuasion = this.persuasion + ppersua;
    }

    /**
     * This method allows the game to add some points of life to the player
     * @param ppoints : an integer representing the number of points of life to add to the player. This integer can be positive or negative.
     */
    public void setPointsOfLife(Integer ppoints){
        this.pointsoflife = this.pointsoflife + ppoints;
         if (this.pointsoflife<= 0) {
            //mort
        }
    }

    /**
     *  This method allows the game to add some points of time to the player
     *  @param ptime : an integer representing the number of minutes to add to the player. This integer can be positive or negative.
     */
    public void setTime(Integer ptime){
        this.time = this.time + ptime;
        if (this.time <= 0) {
            //perdu
        }
    }

    /**
     * This method allows the player to take an item that is present in a room.
     */
    public void takeItem() {
        if (currentRoom.listItem.size() < 0) {
            for (int i = 0; i < currentRoom.listItem.size(); i++) {
                //Inventory.addItem(currentRoom.listItem.get(i));
            }
        }
    }
    /**
     * This method represents the movements of the player in the map : the player can change of room when it is possible.
     * @param direction : north, east... Represents the direction of the movement of the player
     */
    public void move(String direction){
        Room nextRoom = null;
        Room testRoom = null;
        if(currentRoom.containsDirection(direction)) 
        {
            System.out.println("test1");
            testRoom = currentRoom.getRoom(direction);

            // System.out.println(testRoom.getDoor());
            //System.out.println(testRoom.getRoomName());
            if(testRoom.getDoor() != null)
            
            { //if there is a door
                System.out.println("test2");
                if(testRoom.getDoor().isOpenable() == true)
                { //if isOpenable -> true if is openable
                    nextRoom = currentRoom.getRoom(direction);
                    System.out.println("test3bis");
                }
                else 
                { //if openable is false... Try a Key or a Code
                    if(testRoom.getDoor().getHaveCodeLock())
                    { //if it's a code lock
                        System.out.println("test3");
                        for(int i=0; i < inv.ItemsList.size(); i++)
                        {
                            if(testRoom.getDoor().openDoorPass(inv.ItemsList.get(i).getName()))
                            { // Try each object from the inventory -> return true if the door is unlock
                                testRoom.getDoor().setOpenable(true);
                                nextRoom = currentRoom.getRoom(direction);
                            }
                            else {
                                nextRoom = currentRoom;
                            }
                        }
                    }
                    
                    
                  
                    else
                    { System.out.println("test5");
                        for(int i=0; i < inv.ItemsList.size(); i++)
                       {         System.out.println("test6");                  
                            if(testRoom.getDoor().openDoorKey(inv.ItemsList.get(i).getName()))
                            { // Try each object from the inventory -> return true if the door is unlock
                                System.out.println("test7");
                                testRoom.getDoor().setOpenable(true);
                                nextRoom = currentRoom.getRoom(direction);
                            }
                             else {
                                nextRoom = currentRoom;
                                System.out.println("test8");
                            }
                        }
                    }
                }
            }
            else // there is no door
            {
                System.out.println("test4");
                nextRoom = currentRoom.getRoom(direction);
            }

        }
        else {
            nextRoom = currentRoom;
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

     public Room getCurrentRoom(){
        return currentRoom;
    }
}
