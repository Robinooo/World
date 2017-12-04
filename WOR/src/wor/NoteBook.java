package wor;

import java.util.ArrayList;

/**
 * The notebook gives all the informations about the gameplay to the player. In
 * a notebook the player can see what happened during the game : all the items
 * he found, and all the characters he talked with. He can find the description
 * of the items and the speaches of the characters.
 *
 * @author Group2
 * @version 20/11/17
 */
public class NoteBook {

    private static String pnote; // the text in the notebook

    /**
     * Constructor for objects of class NoteBook. There is only a String in this
     * notebook.
     */
    public NoteBook() {
        pnote = ""; // the notebook is initialized as empty.
    }

    /**
     * This method allows the user to add text in the notebook. A text is added
     * after the text that is already present in the notebook, with a line break
     * between the two.
     *
     * @param note, the note to add to the notebook
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
        return ("NoteBook : \n" + pnote + " \n");
    }
}
