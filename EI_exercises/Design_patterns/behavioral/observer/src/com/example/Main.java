package com.example.behavioral.observer;

public class Main {
    public static void main(String[] args) {
        Product p = new Product("P100", "Bluetooth Speaker", 49.99);
        EmailNotifier e = new EmailNotifier("alice@example.com");
        SmsNotifier s = new SmsNotifier("+919900112233");

        p.addObserver(e); p.addObserver(s);

        System.out.println("Initial price: " + p.getPrice());
        p.updatePrice(39.99);
        p.updatePrice(34.99);
    }
}
