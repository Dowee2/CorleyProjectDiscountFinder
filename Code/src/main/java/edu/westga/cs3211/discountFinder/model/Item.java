package edu.westga.cs3211.discountFinder.model;
/**Item class
 * @author Team 1
 * @version CS 3211
 */
public class Item {

    private Seller seller;
    private String itemName;
    private Category category;

    /**
     * Item constructor
     * 
     * @param name     name of the item
     * @param seller   seller of the item
     * @param category the category of the item
     */

    public Item(String name, Seller seller, Category category) {
        if (name == null) {
            throw new IllegalArgumentException("name cannot be null.");
        }

        if (name.isEmpty()) {
            throw new IllegalArgumentException("name cannot be empty.");
        }

        this.seller = seller;
        this.itemName = name;
        this.category = category;

    }

    /**
     * get the name of the item
     * 
     * @return the name of the item
     */

    public String getName() {
        return this.itemName;
    }
    
    /**default to string for the items
     * @return string  Tostring
     */

    public String toString() {
        return this.itemName + " at " + this.seller.getSellerName() + " in " + this.category.name() + " " + this.seller.getFavorite();
    }
    /**
     * Gets the item Category
     * 
     * @return category the item category
     */
    public Category getCategory() {
        return this.category;
    }

    /**
     * Gets the item's seller
     * 
     * @return seller the item seller
     */
    public Seller getSeller() {
        return this.seller;
    }
}
