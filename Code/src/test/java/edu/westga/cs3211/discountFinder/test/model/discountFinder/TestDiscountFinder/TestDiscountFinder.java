package edu.westga.cs3211.discountFinder.test.model.discountFinder.TestDiscountFinder;

import org.junit.jupiter.api.Test;


import edu.westga.cs3211.discountFinder.model.DiscountFinder;

import static org.junit.jupiter.api.Assertions.*;



class TestConstructor{
    @Test
    void testValidConstruction() {
        DiscountFinder disc = new DiscountFinder();
        assertEquals(8, disc.size());
    }

}