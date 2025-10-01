package com.example.creational.factory;

public class Main {
    public static void main(String[] args) {
        Vehicle v1 = VehicleFactory.create("car"); v1.drive();
        Vehicle v2 = VehicleFactory.create("bike"); v2.drive();
        Vehicle v3 = VehicleFactory.create("truck"); v3.drive();
    }
}
