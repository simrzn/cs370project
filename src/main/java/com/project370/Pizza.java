package com.project370;

public class Pizza implements PizzaAttributes {
    
    private String crust;
    private boolean cheese;
    private String topping1;
    private String topping2;

    //Constructor
    public Pizza(String crust, boolean cheese, String topping1, String topping2){
        this.crust = crust;
        this.cheese = cheese;
        this.topping1 = topping1;
        this.topping2 = topping2;
    }
    
    //Getters
    public String getCrust(){
        return crust;
    }

    public boolean getCheese(){
        return cheese;
    }

    public String getTopping1(){
        return topping1;
    }

    public String getTopping2(){
        return topping2;
    }
}


