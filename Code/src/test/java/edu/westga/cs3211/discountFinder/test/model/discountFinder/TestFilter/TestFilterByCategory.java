package edu.westga.cs3211.discountFinder.test.model.discountFinder.TestFilter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.westga.cs3211.discountFinder.model.Category;
import edu.westga.cs3211.discountFinder.model.DiscountFinder;
import edu.westga.cs3211.discountFinder.model.Filter;
import edu.westga.cs3211.discountFinder.model.Item;

class TestFilterByCategory {
    @Test
    void TestFilterForElectronics(){
        DiscountFinder finder = new DiscountFinder();
        Filter filter = new Filter();
        ArrayList<Item> filtered = filter.filterByCategory(finder.getItems(), Category.ELECTRONICS);

        assertEquals(filtered.get(0), finder.getItem(0));
        assertEquals(filtered.get(1), finder.getItem(6));

    }

    @Test
    void TestFilterForClothing() {
        DiscountFinder finder = new DiscountFinder();

        ArrayList<Item> filtered = Filter.filterByCategory(finder.getItems(), Category.CLOTHING);

        assertEquals(filtered.get(0), finder.getItem(1));
        assertEquals(filtered.get(1), finder.getItem(2));
    }

    @Test
    void TestFilterForAppliances() {
        DiscountFinder finder = new DiscountFinder();

        ArrayList<Item> filtered = Filter.filterByCategory(finder.getItems(), Category.APPLIANCES);

        assertEquals(filtered.get(0), finder.getItem(7));
    }

    @Test
    void TestFilterForFood() {
        DiscountFinder finder = new DiscountFinder();

        ArrayList<Item> filtered = Filter.filterByCategory(finder.getItems(), Category.FOOD);

        assertEquals(filtered.get(0), finder.getItem(5));
    }

    @Test
    void TestFilterForOther() {
        DiscountFinder finder = new DiscountFinder();

        ArrayList<Item> filtered = Filter.filterByCategory(finder.getItems(), Category.OTHER);

        assertEquals(filtered.get(0), finder.getItem(3));
        assertEquals(filtered.get(1), finder.getItem(4));  
    }
}
