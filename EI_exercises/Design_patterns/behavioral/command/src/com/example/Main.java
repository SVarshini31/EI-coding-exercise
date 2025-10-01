package com.example.behavioral.command;

public class Main {
    public static void main(String[] args) {
        CoffeeMachine m = new CoffeeMachine();
        VendingMachineInvoker inv = new VendingMachineInvoker();
        inv.setCommand("1", new EspressoCommand(m));
        inv.setCommand("2", new CappuccinoCommand(m));
        inv.setCommand("3", new HotWaterCommand(m));

        System.out.println("=== Coffee Vending Machine Demo ===");
        inv.pressButton("1");
        inv.pressButton("2");
        inv.pressButton("3");
        inv.pressButton("4");
    }
}
