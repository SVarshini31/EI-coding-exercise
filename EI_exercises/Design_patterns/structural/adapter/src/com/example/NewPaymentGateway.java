package com.example.structural.adapter;

public class NewPaymentGateway {
    public String generatePaymentToken(double amount) {
        // in reality this would call external gateway; here we simulate token creation
        return "TOKEN-" + System.currentTimeMillis() + "-" + ((int)(amount*100));
    }
}
