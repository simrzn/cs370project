package com.project370;

public class PizzaBuilder {
    private String crust;
    private boolean cheese;
    private String topping1;
    private String topping2;

    // Setter methods
    public PizzaBuilder setCrust(String crust) {
        this.crust = crust;
        return this;
    }

    public PizzaBuilder setCheese(boolean cheese) {
        this.cheese = cheese;
        return this;
    }

    public PizzaBuilder setTopping1(String topping1) {
        this.topping1 = topping1;
        return this;
    }

    public PizzaBuilder setTopping2(String topping2) {
        this.topping2 = topping2;
        return this;
    }

    // Validate 
    private boolean validate() {
        return isValidCrust(crust) && isValidTopping(topping1) && isValidTopping(topping2);
    }

    // Validation helper methods
    private boolean isValidCrust(String crust) {
        String[] crustOptions = {"Thin", "Stuffed", "Hand Tossed", "Deep Dish", "Flatbread", "Pan"};
        for (String option : crustOptions) {
            if (option.equalsIgnoreCase(crust)) {
                return true;
            }
        }
        return false;
    }

    private boolean isValidTopping(String topping) {
        if (topping == null) {
            return true;
        }
        String[] toppingOptions = {"Pepperoni", "Green Peppers", "Extra Cheese", "Black Olives", "Onions", "Jalapenos", "Pineapple", "Ham"};
        for (String option : toppingOptions) {
            if (option.equalsIgnoreCase(topping)) {
                return true;
            }
        }
        return false;
    }

    // Build method that validates before creating a Pizza
    public Pizza build() {
        if (!validate()) {
            throw new IllegalStateException("Invalid pizza configuration!");
        }
        return new Pizza(crust, cheese, topping1, topping2);
    }

}

