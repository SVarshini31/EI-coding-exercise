package com.example.structural.adapter;

public class Main {
    public static void main(String[] args) {
        OldBillingSystem oldSys = new OldBillingSystem();
        NewPaymentGateway gateway = new NewPaymentGateway();
        PaymentAdapter adapter = new PaymentAdapter(oldSys, gateway);

        adapter.pay(19.99);
    }
}
