package com.example.structural.adapter;

public class PaymentAdapter {
    private final OldBillingSystem oldSystem;
    private final NewPaymentGateway newGateway;

    public PaymentAdapter(OldBillingSystem oldSystem, NewPaymentGateway newGateway) {
        this.oldSystem = oldSystem; this.newGateway = newGateway;
    }

    public void pay(double amount) {
        String token = newGateway.generatePaymentToken(amount);
        oldSystem.charge(token, amount);
    }
}
