package com.example.behavioral.observer;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Product {
    private final String id;
    private final String name;
    private volatile double price;
    private final List<PriceObserver> observers = new CopyOnWriteArrayList<>();

    public Product(String id, String name, double price) {
        if (id==null||name==null) throw new IllegalArgumentException("id/name null");
        this.id = id; this.name = name; this.price = price;
    }
    public String getId(){return id;}
    public String getName(){return name;}
    public double getPrice(){return price;}

    public void addObserver(PriceObserver o){ observers.add(o); }
    public void removeObserver(PriceObserver o){ observers.remove(o); }

    public void updatePrice(double newPrice){
        double old = this.price;
        if (Double.compare(old, newPrice)==0) return;
        this.price = newPrice;
        for (PriceObserver o : observers) {
            try { o.onPriceChanged(id, name, old, newPrice); }
            catch (Throwable t) { System.err.println("Observer failed: "+t.getMessage()); }
        }
    }
}
