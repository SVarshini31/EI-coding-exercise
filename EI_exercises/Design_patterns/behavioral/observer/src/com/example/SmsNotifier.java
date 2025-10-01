package com.example.behavioral.observer;

public class SmsNotifier implements PriceObserver {
    private final String phone;
    public SmsNotifier(String phone){ this.phone = phone; }
    @Override public void onPriceChanged(String productId, String productName, double oldPrice, double newPrice) {
        System.out.println("SMS to " + phone + ": " + productName + " now " + newPrice);
    }
}
