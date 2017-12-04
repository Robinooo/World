package wor;

import java.util.*;

/**
 * The class Door is used to create a door. A door has a name, can have a lock
 * or a code (not both in the same time). A door can be set as open, or closed. 
 * If it is closed, the door can be opened by a key or a code. 
 *
 * @author Group2
 * @version 11/20/2017
 */
public class Door {

    private KeyLock keyLock = null; // KeyLock of the door
    private CodeLock codeLock = null; // CodeLock of the door
    private String name; //Name of the door
    private boolean openable; //state is either "is openable" or "not openable"

    /**
     * Constructor for objects of class Door At first, the door is closed and
     * have a specific name. ifKeyLock is true then, the door has a key lock,
     * else not. ifCodeLock is true then, the door has a code lock, else not. A
     * door cannot have both a code and a key lock.
     *
     * @param name The name of the door
     */
    public Door(String name) {
        openable = true; // door is open
        this.name = name + "Door";
    }

    /**
     * The setOpenable method modifies the boolean openable. 
     *
     * @param b The boolean to know if a door is openable or not. When the value
     * is true -> the door is openable (can be opened)
     */
    
    public void setOpenable(boolean b) {
        openable = b; // change the value of the boolean openable - true if openable   
    }

    /**
     * The isOpenable method returns the status of the boolean openable.
     *
     * @return the status of the boolean openable - true if is openable
     */
    public boolean isOpenable() {
        return openable; // return the value of the boolean. When the value is true -> the door is openable
    }

    /**
     * The getNameDoor method gets the identifier/name (String) of a door
     *
     * @return name, the name of the door
     */
    public String getNameDoor() {
        return name; // return the name of the door
    }

    /**
     * The getHaveKeyLock method returns a boolean to know if a door have a keyLock
     *
     * @return a boolean. If a door has a keyLock, then return true
     */
    public boolean getHaveKeyLock() {
        if (keyLock == null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * The method addCodeLock adds a code lock to the door
     * 
     * @param codeLock The code lock for the door
     */
    public void addCodeLock(CodeLock codeLock) {
        this.codeLock = codeLock;
        openable = false; // door is close
    }

    /**
     *  The method addKeyLock adds a key lock to the door
     * 
     * @param keyLock The key lock for the door
     */
    public void addKeyLock(KeyLock keyLock) {
        this.keyLock = keyLock;
        openable = false; // door is close
    }

    /**
     * The getHaveCodeLock method returns a boolean to know if a door have a CodeLock
     *
     * @return a boolean. If a door has a CodeLock, then return true
     */
    public boolean getHaveCodeLock() {
        if (codeLock == null) {
            return false; // the door does not have a code lock
        } else {
            return true; // the door has a code lock
        }
    }

    /**
     * Return the code lock
     *
     * @return CodeLock object
     */
    public CodeLock getCodeLock() {
        return codeLock;
    }

    /**
     * Return the key lock
     *
     * @return KeyLock object
     */
    public KeyLock getKeyLock() {
        return keyLock;
    }

    /**
     * The openDoorKey method opens the door using a key
     *
     * @return Returns true if the door is unlocked
     */
    public boolean openDoorKey(String keyName) {

        if (keyLock.getNameKey().equals(keyName)) {
            return true; // the door is unlocked
        } else {
            return false; // the door is locked
        }
    }

    /**
     * The openDoorPass method opens the door using a passcode. If the password
     * given by the player matches with the password of the door, the door is open (return true). 
     * If not, the door remains closed (return false).
     *
     * @return Returns true if the door is unlock
     */
    public boolean openDoorPass(String password) {
        if (codeLock.getPasswd().equals(password)) {
            return true; // passwords are matching : the door is open
        } else {
            return false; // passwords are not matching : the door is still closed
        }
    }

    /**
     * The method openDoor opens the door if it is unlocked or do not have a lock (key or code lock)
     *
     * @return Returns false when a door can't be open. The door still lock. And
     * return true when the door can be passed.
     */
    public boolean openDoor() {
        if (isOpenable()) {
            return true; // the door can be passed
        } else {
            return false; // the door is closed
        }
    }
}
