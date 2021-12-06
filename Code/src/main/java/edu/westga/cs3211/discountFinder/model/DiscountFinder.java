package edu.westga.cs3211.discountFinder.model;

/**Discount Finder class
 * @author Team 1
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
     * get the index of the item
     * 
     * @param index the place in the list
     * @return the item index
     */
    public Item getItem(int index) {
        return this.items.get(index);
    }

}
