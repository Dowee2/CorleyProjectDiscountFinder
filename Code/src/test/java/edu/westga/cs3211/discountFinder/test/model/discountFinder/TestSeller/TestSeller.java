package edu.westga.cs3211.discountFinder.test.model.discountFinder.TestSeller;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import edu.westga.cs3211.discountFinder.model.Seller;

class TestSeller {

    @Test
    void testValidSeller() {
        Seller seller = new Seller(100, "Nike");
        String result = seller.getSellerName();
        int distanceResult = seller.getDistance();
        assertAll(
            () -> assertEquals(distanceResult, seller.getDistance()),
            () -> assertEquals(result, seller.getSellerName())
        );
    }

    @Test
    void testNullName() {
        assertThrows(IllegalArgumentException.class, () -> new Seller(100, null));
    }
    @Test
    void testNegativeDistance() {
        assertThrows(IllegalArgumentException.class, () -> new Seller(-100, "Nike"));
    }

    @Test
    void testEmptyName() {
        assertThrows(IllegalArgumentException.class, () -> new Seller(-100, ""));
    }

    @Test
    void testFavoriteSeller() {
        Seller seller = new Seller(100, "Nike");
        seller.setFavorite();
        assertAll(
            () -> assertEquals("*", seller.getFavorite())
        );
    }
}
