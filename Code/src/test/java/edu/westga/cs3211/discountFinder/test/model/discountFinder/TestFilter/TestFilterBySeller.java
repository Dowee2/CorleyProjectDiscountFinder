package edu.westga.cs3211.discountFinder.test.model.discountFinder.TestFilter;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.westga.cs3211.discountFinder.model.DiscountFinder;
import edu.westga.cs3211.discountFinder.model.Filter;
import edu.westga.cs3211.discountFinder.model.Item;

public class TestFilterBySeller {
    
    @Test
    void TestNoItemMatches() {
        DiscountFinder finder = new DiscountFinder();

        ArrayList<Item> filtered = Filter.filterBySeller(finder.getItems(), "publix");

        assertEquals(filtered.size(), 0);

    }

    @Test
    void TestOneItemMatches() {
        DiscountFinder finder = new DiscountFinder();

        ArrayList<Item> filtered = Filter.filterBySeller(finder.getItems(), "Adam");

        assertEquals(filtered.size(), 1);
        assertEquals(filtered.get(0), finder.getItem(7));
    }

    @Test
    void TestTwoItemMatches() {
        DiscountFinder finder = new DiscountFinder();

        ArrayList<Item> filtered = Filter.filterBySeller(finder.getItems(), "Del");

        assertEquals(filtered.size(), 2);
        assertEquals(filtered.get(0), finder.getItem(0));
        assertEquals(filtered.get(1), finder.getItem(1));
    }
}
