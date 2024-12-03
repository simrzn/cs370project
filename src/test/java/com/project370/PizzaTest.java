package com.project370;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PizzaTest {
 
    @Test
    public void testValidPizzaCreation() {
        Pizza pizza = new PizzaBuilder()
                .setCrust("Deep Dish")
                .setCheese(true)
                .setTopping1("Onions")
                .setTopping2("Extra Cheese")
                .build();

        // Assert
        assertEquals("Deep Dish", pizza.getCrust());
        assertTrue(pizza.getCheese());
        assertEquals("Onions", pizza.getTopping1());
        assertEquals("Extra Cheese", pizza.getTopping2());
    }

    @Test
    public void testInvalidCrustThrowsException() {
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            new PizzaBuilder()
                .setCrust("Invalid Crust")
                .setCheese(true)
                .setTopping1("Onions")
                .setTopping2("Extra Cheese")
                .build();
        });
        assertEquals("Invalid pizza configuration!", exception.getMessage());
    }

    @Test
    public void testInvalidToppingThrowsException() {
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            new PizzaBuilder()
                .setCrust("Thin")
                .setCheese(true)
                .setTopping1("Invalid Topping")
                .setTopping2("Extra Cheese")
                .build();
        });

        // Assert
        assertEquals("Invalid pizza configuration!", exception.getMessage());
    }

    @Test
    public void testNullToppingsAreValid() {
        Pizza pizza = new PizzaBuilder()
                .setCrust("Flatbread")
                .setCheese(true)
                .setTopping1(null)
                .setTopping2(null)
                .build();

        // Assert
        assertEquals("Flatbread", pizza.getCrust());
        assertTrue(pizza.getCheese());
        assertNull(pizza.getTopping1());
        assertNull(pizza.getTopping2());
    }

    @Test
    public void testValidToppingLowercase() {
        Pizza pizza = new PizzaBuilder()
                .setCrust("Deep Dish")
                .setCheese(true)
                .setTopping1("onions")
                .setTopping2("extra cheese")
                .build();

        // Assert
        assertEquals("extra cheese", pizza.getTopping2());
        assertEquals("onions", pizza.getTopping1());
        }


    @Test
    public void testInvalidToppings() {
        try {
            new PizzaBuilder()
                .setCrust("Deep Dish")
                .setTopping1("Onions")
                .setTopping2("Ice Cream") // Invalid topping
                .build();
            //fail("Expected IllegalStateException to be thrown");  // Fail the test if exception isn't thrown
        } catch (IllegalStateException e) {
            // Assert: Verify that the exception message contains the expected error
            assertTrue(e.getMessage().contains("Invalid pizza configuration"));
        }
    }
        
}