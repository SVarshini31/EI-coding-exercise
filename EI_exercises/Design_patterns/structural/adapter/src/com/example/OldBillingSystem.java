package com.example.structural.adapter;

public class OldBillingSystem {
    // expects payment via legacy method (e.g., token string)
    public void charge(String legacyPaymentToken, double amount) {
        System.out.println("Old system charging token: " + legacyPaymentToken + " for amount: " + amount);
    }
}
