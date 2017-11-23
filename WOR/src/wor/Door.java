package wor;

import java.util.*;

/**
 * The class Door is used to create a door. A door have a name, can have a lock
 * or a code (not both in the same time). A door can also be open or not, if the
 * user have a key or code, or if the door do not have a lock (code or key), or
 * is already unlock.
 *
 * @author Group2
 * @version 11/20/2017
 */
public class Door {

    private KeyLock keyLock; // KeyLock of the door
    private CodeLock codeLock; // CodeLock of the door
    private String name; //Name of the door
    private boolean openable; //state is either "is openable" or "not openable"
    private static HashMap<String, String> doorLock = new HashMap<String, String>(); // A hash to put as a key the door name and as a vaue the key or code associate.

    /**
     * Constructor for objects of class Door At first, the door is close and
     * have a specifi name. ifKeyLock is true then, the door have a key lock,
     * else not. ifCodeLock is true then, the door have a code lock, else not. A
     * door can not have a code and a key lock
     *
     * @param name The name of the door
     * @param ifKeyLock To know if a door have a keyLock
     * @param ifCodeLock To know if a door have a codeLock
     */
    public Door(String name, boolean ifKeyLock, boolean ifCodeLock) {
        openable = true; // door is open
        this.name = name + "Door";
        if (ifKeyLock && ifCodeLock) {
            System.out.println("\nYou can't have a code and a key lock\nYou have to chose\n");
        } else {
            if (ifKeyLock) {
                String foo = "Key" + name; //create a specif name for the key
                keyLock = new KeyLock(foo); //create the KeyLock object
                doorLock.put(name, foo); //put into the hash: the Door'name as a Key and the key's name as a Value
                openable = false;
                // Item key = new Item(foo); //create the key associate to the keyLock
            }

            if (ifCodeLock) {
                String foo = "Code" + name; //create a specif name for the code
                codeLock = new CodeLock(foo); //create the CodeLock object
                doorLock.put(name, foo); //put into the hash: the Door'name as a Key and the code's name as a Value
                openable = false;
                // Item code = new Item(foo); //create the Code associate to the CodeLock
            }
        }
    }

    /**
     * modify the boolean openable
     *
     * @param b The boolean to know if a door is openable or not. When the value
     * is true -> the door is openable (can be open)
     */
    public void setOpenable(boolean b) {
        openable = b; // change the value of the boolean openable - true if openable   
    }

    /**
     * Returns the status of the boolean openable
     *
     * @return Returns the status of the boolean openable - true if is openable
     */
    public boolean isOpenable() {
        return openable; // retrun the value of the boolean.When the value is true -> the door is openable (can be open)
    }

    /**
     * Get the identifier/name (String) of a door
     *
     * @return Returns the name of the door
     */
    public String getNameDoor() {
        return name; // return the name of the door
    }

    /**
     * Return a boolean to know if a door have a keyLock
     *
     * @return Returns A boolean. if a door have a keyLock, return true
     */
    public boolean getHaveKeyLock() {
        if (keyLock == null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Return a boolean to know if a door have a CodeLock
     *
     * @return Returns A boolean. if a door have a CodeLock, return true
     */
    public boolean getHaveCodeLock() {
        if (codeLock == null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Open the door using a key
     *
     * @return Returns true if the door is unlock
     */
    public boolean openDoorKey(String keyName) {
        System.out.println(keyLock.getNameKey());
        System.out.println(keyName);
        
        if(keyLock.getNameKey().equals(keyName)){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Open the door using a passcode The method call returns 'true' if this map
     * maps one or more keys to the specified value.
     *
     * @return Returns true if the door is unlock
     */
    public boolean openDoorPass(String password) {

        if(codeLock.getPasswd().equals(password)){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Open the door if it unlock or do not have a lock (key or code lock)
     *
     * @return Returns false when a door can't be open. The door still lock. And
     * return true when the door can be passed.
     */
    public boolean openDoor() {
        if (isOpenable()) {
            return true;
            //System.out.println("You can pass the door");
        } else {
            return false;
            //System.out.println("The door still lock.\nTry a key or a password.");
        }
    }
}
