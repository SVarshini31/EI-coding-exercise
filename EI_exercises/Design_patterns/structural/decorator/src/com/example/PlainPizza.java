package com.example.structural.decorator;

public class PlainPizza implements Pizza {
    @Override public String getDescription() { return "Plain pizza"; }
    @Override public double getCost() { return 5.00; }
}
