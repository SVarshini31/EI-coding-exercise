package com.example.behavioral.observer;

public interface PriceObserver {
    void onPriceChanged(String productId, String productName, double oldPrice, double newPrice);
}
