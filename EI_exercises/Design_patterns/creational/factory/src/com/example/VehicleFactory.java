package com.example.creational.factory;

public class VehicleFactory {
    public static Vehicle create(String type) {
        if (type==null) throw new IllegalArgumentException("type null");
        return switch(type.toLowerCase()) {
            case "car" -> new Car();
            case "bike" -> new Bike();
            case "truck" -> new Truck();
            default -> throw new IllegalArgumentException("Unknown vehicle type: " + type);
        };
    }
}
