package edu.westga.cs3211.discountFinder.model;
/**Pre-generated discount list class
 * @author Team 1
 * @version CS 3211
 */
import java.util.ArrayList;

/**Creates the discount list
 * @author Team 1
 */

public class CreateDiscountList {
    private ArrayList<Item> itemList;

    public CreateDiscountList() {
        this.itemList = new ArrayList<Item>();
        Seller dell = new Seller(25, "Dell");
        Seller nike = new Seller(50, "Nike");
        Seller amazon = new Seller(100, "Amazon");
        Seller walmart = new Seller(10, "Walmart");
        Seller adamandeve = new Seller(42069, "Adam and Eve");

        Item item1 = new Item("Dell Laptop", dell, Category.ELECTRONICS);
        Item item2 = new Item("Socks", dell, Category.CLOTHING);
        Item item3 = new Item("Huraches", nike, Category.CLOTHING);
        Item item4 = new Item("Dice Box", amazon, Category.OTHER);
        Item item5 = new Item("Pokemon Cards", walmart, Category.OTHER);
        Item item6 = new Item("Cheezits", walmart, Category.FOOD);
        Item item7 = new Item("Delta 8 Pen", amazon, Category.ELECTRONICS);
        Item item8 = new Item("Bleep Bleep Bleep", adamandeve, Category.APPLIANCES);
        this.itemList.add(item1);
        this.itemList.add(item2);
        this.itemList.add(item3);
        this.itemList.add(item4);
        this.itemList.add(item5);
        this.itemList.add(item6);
        this.itemList.add(item7);
        this.itemList.add(item8);
    }
    /**Gets the list that was pre-generated in the constructor.
     * 
     * @return the list of items pre-generated
     */
    public ArrayList<Item> returnItemList() {
        return this.itemList;
    }
}
