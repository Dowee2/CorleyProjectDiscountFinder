package edu.westga.cs3211.discountFinder.model;
/**Seller class 
 * 
 * @author Team 1
 * @version CS 3211
 */
public class Seller {

    private int distance;
    private String sellerName;
   
    public Seller(int distance, String sellerName) {
        if (sellerName == null) {
            throw new IllegalArgumentException("Name can not be null");
        }
        if (sellerName.isEmpty()) {
            throw new IllegalArgumentException("Name can not be empty");
        }
        if (distance < 0) {
            throw new IllegalArgumentException("Distance can not be negative");
        }
        this.distance = distance;
        this.sellerName = sellerName;
    }
  
    public int getDistance() {
        return this.distance;
    }

    public String getSellerName() {
        return this.sellerName;
    }
}