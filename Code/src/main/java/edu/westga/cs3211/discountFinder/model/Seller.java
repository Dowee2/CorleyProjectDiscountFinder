package edu.westga.cs3211.discountFinder.model;
/**Seller class 
 * @author Team 1
 * @version CS 3211
 */
public class Seller {

    private int distance;
    private String sellerName;
   
    public Seller(int distance, String sellerName) {
        if (distance < 0) {
            throw new IllegalArgumentException("Distance can not be negative");
        }
        if (sellerName == null) {
            throw new IllegalArgumentException("Name can not be null");
        }
        if (sellerName.isEmpty()) {
            throw new IllegalArgumentException("Name can not be empty");
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

    public int calculateDistance(int distance) {
        int result = 0;
        result = this.getDistance() - distance;
        return Math.abs(result);
    }
}
