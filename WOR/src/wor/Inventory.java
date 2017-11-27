package wor;

import java.util.ArrayList;

/**
 * The class Inventory allows to manage the player's inventory.
 *
 * @author Group 2 - DEGUISE Martin FRICOT Robin DOUMENGE Diane LIEVRE Clémence
 * DUBUISSON Guillaume ROUJOU Lucas
 * @version 20/11/2017
 *
 */
public class Inventory {

    /**
     * Declaration : ArrayList<Item> ItemsList; Inventory inv;
     */
    public ArrayList<Item> ItemsList;
    //public Inventory inv;

    /**
     * Constructor for objects of class Inventory : created a Inventory
     *
     */
    public Inventory() {
        ItemsList = new ArrayList<Item>();
    }

    /**
     * add a Items in the inventory
     *
     * @param Item Item to add to inventory.
     *
     */
    public void addItems(Item newItem) {
        ItemsList.add(newItem);
        System.out.println("Item ajouté à l'inventaire.");
    }

    /**
     * display Items present in the inventory
     *
     * @param : ArrayList <Item> ItemsList : the list of items
     * @return : boolean false is the list of items is empty, true if the item
     * is in the list
     */
    public boolean displayItems(ArrayList<Item> ItemsList) {
        if (ItemsList.isEmpty()) {
            System.out.println("Aucun items dans l'inventaire.");
            return false;
        } else {
            System.out.println("Items dans l'inventaire : ");
            for (int i = 0; i < ItemsList.size(); i++) {
                System.out.println(ItemsList.get(i).getName());
            }
            return true;

        }
    }
    
    
    public boolean displayItemsImg(ArrayList<Item> ItemsList) {
        if (ItemsList.isEmpty()) {
            System.out.println("Aucun items dans l'inventaire.");
            return false;
        } else {
            System.out.println("Items dans l'inventaire : ");
            for (int i = 0; i < ItemsList.size(); i++) {
                ItemsList.get(i).getImageItem();
                
            }
            return true;

        }
    }

    /**
     * remove an Items from the inventory
     *
     * @param Item Item to remove to inventory.
     */
    public void removeItems(Item usedItem) {
        ItemsList.remove(usedItem);
        System.out.println("Item supprimé de l'inventaire.");
    }
}
