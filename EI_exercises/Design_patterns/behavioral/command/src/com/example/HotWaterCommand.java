package com.example.behavioral.command;

public class HotWaterCommand implements Command {
    private final CoffeeMachine machine;
    public HotWaterCommand(CoffeeMachine machine) { this.machine = machine; }
    @Override public void execute() { machine.dispenseHotWater(); }
}
