package wor;

/**
 * The class KeyLock is a daughter of the class Lock. 
 * This class allows us to add a keylock to a door.
 *
 * @author Group2
 * @version 11/20/2017
 */
public class KeyLock extends Lock
{
    private String nameKey; // The name of the key

    /**
    * Constructor for objects of class KeyLock
    * 
    * @param name The name of the key
    */
    public KeyLock(String name)
    {
        nameKey=name;
    }
    
   /** 
   * Returns the name of the key
   * 
   * @reurn Returns the name of the key
   */
    public String getNameKey(){
        return nameKey;
    }
}