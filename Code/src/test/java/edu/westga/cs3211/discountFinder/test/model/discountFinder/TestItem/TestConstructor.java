package edu.westga.cs3211.discountFinder.test.model.discountFinder.TestItem;

import org.junit.jupiter.api.Test;

import edu.westga.cs3211.discountFinder.model.Category;
import edu.westga.cs3211.discountFinder.model.Item;
import edu.westga.cs3211.discountFinder.model.Seller;

import static org.junit.jupiter.api.Assertions.*;



class TestConstructor{
    @Test
    void testValidConstruction() {
        Seller seller = new Seller(50, "seller");
        Item item = new Item("name", seller, Category.APPLIANCES);

        assertAll(
            () -> assertEquals("name", item.getName())
        );
    }

    @Test
    void testNullName() {
        Seller seller = new Seller(50, "seller");

        assertThrows(IllegalArgumentException.class, () -> {
            new Item(null, seller, Category.APPLIANCES);
        });
    }

    @Test
    void testEmptyName() {
        Seller seller = new Seller(50, "seller");

        assertThrows(IllegalArgumentException.class, () -> {
            new Item("", seller, Category.APPLIANCES);
        });
    }
    
    @Test
    void testToStringNoFavorited() {
        Seller seller = new Seller(50, "seller");
        Item item = new Item("name", seller, Category.FOOD);

        assertEquals("name at seller in FOOD ", item.toString());
    }

    @Test
    void testToStringFavorite() {
        Seller seller = new Seller(50, "seller");
        seller.setFavorite();
        Item item = new Item("name", seller, Category.FOOD);

        assertEquals("name at seller in FOOD *", item.toString());
    }

}