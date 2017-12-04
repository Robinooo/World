package wor;

/**
 * The class CodeLock is a daughter of the class Lock. This class allows us to
 * add a codelock to a door.
 *
 * @author Group2
 * @version 11/20/2017
 */
public class CodeLock extends Lock {

    private String code; // The code of the CodeLock
    private String name; // The name of the CodeLock

    /**
     * Constructor for objects of class CodeLock
     *
     * @param newCode The password of the code
     */
    public CodeLock(String name, String code) {
        this.name = name;
        this.code = code;
    }

    /**
     * Returns the password
     *
     * @return Return the password of the CodeLock
     */
    public String getPasswd() {
        return code;
    }

    /**
     * Retur the name of the code lock
     *
     * @return The name of the code lock
     */
    public String getName() {
        return name;
    }
}
