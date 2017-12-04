package wor;

/**
 * The class Lock is a mother class of CodeLock and KeyLock. This class allows
 * us to create and add a lock to a door.
 *
 * @author Group2
 * @version 11/20/2017
 */
public class Lock {

    protected boolean locked; // true if the door is locked

    /**
     * Constructor for objects of class Lock. At first, a lock is initialize as
     * locked.
     */
    public Lock() {
        locked = true; // The lock is locked
    }

    /**
     * The setLock method modifies the boolean locked. Allows us to change the
     * value of the boolean lock.
     *
     * @param b the value of the lock boolean. True if the door is locked.
     */
    public void setLock(boolean b) {
        locked = b;
    }

    /**
     * The isLocked method returns the status of the boolean isLocked.
     *
     * @return locked : true if the door is effectively locked.
     */
    public boolean isLocked() {
        return locked;
    }
}
