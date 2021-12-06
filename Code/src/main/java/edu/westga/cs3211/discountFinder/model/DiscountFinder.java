package edu.westga.cs3211.discountFinder.model;

/**Discount Finder class
 * 
 */
import java.util.ArrayList;

public class DiscountFinder {

    private ArrayList<Item> items;
    private CreateDiscountList generatedList;

    /**
     * Instantitates the list
     * 
     */
    public DiscountFinder() {
        this.generatedList = new CreateDiscountList();
        this.items = this.generatedList.returnItemList();
    }

    /**
     * gets the items in the list
     * 
     * @return the items in the list
     */

    public ArrayList<Item> getItems() {
        return this.items;

    }

    /**
     * Adds and Item to the list
     * 
     * @param item the item in the list
     */

    public void addItem(Item item) {
        this.items.add(item);
    }

    /**
     * get the index of the item
     * 
     * @param index the place in the list
     * @return the item index
     */
    public Item getItem(int index) {
        return this.items.get(index);
    }

    /**
     * get the size of the list
     * 
     * @return the size of the list
     */
    public int size() {
        return this.items.size();
    }

}
