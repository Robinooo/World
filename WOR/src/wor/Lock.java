package wor;


/**
 * The class Lock is a mother class of CodeLock and KeyLock. 
 * This class allows us to add a lock to a door.
 *
 * @author Group2
 * @version 11/20/2017
 */
public class Lock
{
   protected boolean locked;

   /**
   * Constructor for objects of class Lock. At first, a lock is locked. 
   */
   public Lock()
   {
    locked=true; // The lock is locked
   }
    
   /** 
   * Modify the boolean locked (user decision)
   * 
   * @param b A boolean to modify the lock boolean. A lock is unloked when the boolean is false
   */
   public void setLock(boolean b) {
	locked=b;
   }
   
   /** 
   * Returns the status of the boolean isLocked
   * 
   * @return The boolean of lock state is return. True when the lock is locked. False when the lock is unlocked. 
   */
   public boolean isLocked() {
	return locked;
   }   
}
