package edu.westga.cs3211.discountFinder.test.model.discountFinder.TestFilter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.westga.cs3211.discountFinder.model.DiscountFinder;
import edu.westga.cs3211.discountFinder.model.DistanceEnum;
import edu.westga.cs3211.discountFinder.model.Filter;
import edu.westga.cs3211.discountFinder.model.Item;

public class TestFilterByDistance {
    
    @Test
    void TestItemsWithinTenMilesAway() {
        DiscountFinder finder = new DiscountFinder();

        ArrayList<Item> filtered = Filter.filterByDistance(finder.getItems(),DistanceEnum.Ten);


        assertEquals(filtered.size(), 2);
        assertEquals(filtered.get(0), finder.getItem(4));
        assertEquals(filtered.get(1), finder.getItem(5));
    }

    @Test
    void TestItemWithinTwentyMilesAway() {
        DiscountFinder finder = new DiscountFinder();

        ArrayList<Item> filtered = Filter.filterByDistance(finder.getItems(),DistanceEnum.Twenty);


        assertEquals(filtered.size(), 2);
        assertEquals(filtered.get(0), finder.getItem(4));
        assertEquals(filtered.get(1), finder.getItem(5));
    }

    @Test
    void TestItemWithinThirtyMilesAway() {
        DiscountFinder finder = new DiscountFinder();

        ArrayList<Item> filtered = Filter.filterByDistance(finder.getItems(),DistanceEnum.Thirty);


        assertEquals(filtered.size(), 4);
        assertEquals(filtered.get(0), finder.getItem(0));
        assertEquals(filtered.get(1), finder.getItem(1));
        assertEquals(filtered.get(2), finder.getItem(4));
        assertEquals(filtered.get(3), finder.getItem(5));
    }

    @Test
    void testOverDistance() {
        DiscountFinder finder = new DiscountFinder();

        ArrayList<Item> filtered = Filter.filterByDistance(finder.getItems(),DistanceEnum.OverThirty);


        assertEquals(filtered.size(), 4);
    }
}
