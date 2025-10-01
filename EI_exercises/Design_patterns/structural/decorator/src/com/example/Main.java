package com.example.structural.decorator;

public class Main {
    public static void main(String[] args) {
        Pizza base = new PlainPizza();
        Pizza withCheese = new CheeseDecorator(base);
        Pizza deluxe = new VeggieDecorator(withCheese);

        System.out.println(deluxe.getDescription() + " costs $" + deluxe.getCost());
    }
}
