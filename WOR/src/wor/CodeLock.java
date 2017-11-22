package wor;

/**
 * The class CodeLock is a daughter of the class Lock. This class allows us to
 * add a codelock to a door.
 *
 * @author Group2
 * @version 11/20/2017
 */
public class CodeLock extends Lock {

    private String code; //The code of the CodeLock

    /**
     * Constructor for objects of class CodeLock
     *
     * @param newCode The password of the code
     */
    public CodeLock(String newCode) {
        code = newCode;//fffff
    }

    /**
     * Returns the password
     *
     * @return Return the password of the CodeLock
     */
    public String getPasswd() {
        return code;
    }
}
