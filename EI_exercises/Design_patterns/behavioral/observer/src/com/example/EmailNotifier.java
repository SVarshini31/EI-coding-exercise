package com.example.behavioral.observer;

public class EmailNotifier implements PriceObserver {
    private final String email;
    public EmailNotifier(String email){ this.email = email; }
    @Override public void onPriceChanged(String productId, String productName, double oldPrice, double newPrice) {
        System.out.println("EMAIL to " + email + ": " + productName + " price changed from " + oldPrice + " to " + newPrice);
    }
}
