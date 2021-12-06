package edu.westga.cs3211.discountFinder.model;

import java.util.ArrayList;

/**
 * filer class
 * @author Team 1
 */
public final class Filter {
    
    public static ArrayList<Item> filterByCategory(ArrayList<Item> list, Category category) {
        ArrayList<Item> filteredList = new ArrayList<>();
        for (Item item : list) {
            if (item.getCategory() == category) {
                filteredList.add(item);
            }
        }
        return filteredList;
    }

    public static ArrayList<Item> filterBySeller(ArrayList<Item> list, String seller) {
        ArrayList<Item> filteredList = new ArrayList<>();
        for (Item item : list) {
            if (item.getSeller().getSellerName().toLowerCase().contains(seller.toLowerCase())) {
                filteredList.add(item);
            }
        }
        return filteredList;
    }

    public static ArrayList<Item> filterByName(ArrayList<Item> list, String name) {
        ArrayList<Item> filteredList = new ArrayList<>();
        for (Item item : list) {
            if (item.getName().toLowerCase().startsWith(name.toLowerCase())) {
                filteredList.add(item);
            }
        }
        return filteredList;
    }

    public static ArrayList<Item> filterByDistance(ArrayList<Item> list, DistanceEnum distanceto) {
        ArrayList<Item> filteredList = new ArrayList<>();
        for (Item item : list) {

            switch (distanceto) {
                case Ten:
                    if (item.getSeller().getDistance() <= 10) {
                        filteredList.add(item);
                    }
                    break;
                
                case Twenty:
                    if (item.getSeller().getDistance() <= 20) {
                        filteredList.add(item);
                    }
                    break;
                
                case Thirty:
                    if (item.getSeller().getDistance() <= 30) {
                        filteredList.add(item);
                    }
                    break;
            
                default:
                    if (item.getSeller().getDistance() > 30) {
                        filteredList.add(item);
                    }
                    break;
            }
        }
        return filteredList;
    }


}
