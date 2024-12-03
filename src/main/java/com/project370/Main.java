package com.project370;

public class Main {
    public static void main(String[] args) {
    
    try {
        Pizza order = new PizzaBuilder()
            .setCrust("Deep Dish")
            .setCheese(true)
            .setTopping1("Onions")
            .setTopping2("Extra Cheese")
            .build();

        System.out.println("Pizza Order Summary:");
        System.out.println("Crust: " + order.getCrust());
        System.out.println("Cheese: " + (order.getCheese()));
        System.out.println("Topping 1: " + order.getTopping1());
        System.out.println("Topping 2: " + order.getTopping2());
    } catch (IllegalArgumentException e) {
        System.err.println(e.getMessage());
    }
    }
 }
        
    

