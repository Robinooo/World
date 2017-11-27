package wor;

import java.util.ArrayList;

/**
 * The notebook gives all the informations about the gameplay to the player.
 *
 * @author Group2
 * @version 20/11/17
 */
public class NoteBook {

    private static String pnote;

    /**
     * Constructor for objects of class NoteBook
     */
    public NoteBook() {
        pnote = "";
    }

    /**
     * This method allows the user to add text in the notebook.
     */
    public void addText(String note) {
            pnote = pnote + note + "\n";
    }

    /**
     * This methods allows the user to get all the text from the notebook.
     * 
     * @return pnote
     */
    public String getText() {
        return ("NoteBook : \n" + pnote);
    }
}
