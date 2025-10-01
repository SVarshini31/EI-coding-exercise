package com.example.structural.decorator;

public class VeggieDecorator extends PizzaDecorator {
    public VeggieDecorator(Pizza pizza) { super(pizza); }
    @Override public String getDescription() { return pizza.getDescription() + " + Veggies"; }
    @Override public double getCost() { return pizza.getCost() + 1.75; }
}
