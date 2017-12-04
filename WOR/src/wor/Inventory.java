package wor;

import java.util.ArrayList;

/**
 * The class Inventory allows to manage the player's inventory. The inventory
 * contains all the items of the player, that he found in the different rooms.
 *
 * @author Group 2 - DEGUISE Martin FRICOT Robin DOUMENGE Diane LIEVRE Clémence
 * DUBUISSON Guillaume ROUJOU Lucas
 * @version 20/11/2017
 *
 */
public class Inventory {

    public ArrayList<Item> ItemsList; // The array containing all the items of the player

    /**
     * Constructor for objects of class Inventory. An inventory in nothing more
     * than an array, containing all the items the player found in the room he
     * visited.
     */
    public Inventory() {
        ItemsList = new ArrayList<Item>();
    }

    /**
     * The addItems method adds a new item in the inventory.
     *
     * @param Item, the item to add to inventory.
     */
    public void addItems(Item newItem) {
        ItemsList.add(newItem); // add an Item into the inventory (ArrayList)
    }

    /**
     * The displayItems method displays the items contained in the inventory
     *
     * @param ItemsList : the list of items
     * @return boolean false is the list of items is empty, true if the item is
     * in the list
     */
    public boolean displayItems(ArrayList<Item> ItemsList) {
        if (ItemsList.isEmpty()) {
            return false; // the inventory is empty (nothing on the list)
        } else {
            return true; // there is items in the inventory
        }
    }

    /**
     * The displayItemsImg method allows the user to display the images
     * associated to the items.
     *
     * @param ItemsList
     * @return true si la liste contient des items
     */
    public boolean displayItemsImg(ArrayList<Item> ItemsList) {
        if (ItemsList.isEmpty()) {
            return false; // la liste des items est vide
        } else {
            for (int i = 0; i < ItemsList.size(); i++) {
                ItemsList.get(i).getImageItem(); // affiche les images associées aux items
            }
            return true; // la liste des items n'est pas vide
        }
    }

    /**
     * The removeItems method removes an item from the inventory.
     *
     * @param usedItem, the item to remove from inventory.
     */
    public void removeItems(Item usedItem) {
        ItemsList.remove(usedItem); // remove the item from the ArrayList
    }
}
