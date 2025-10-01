package com.example.behavioral.command;

public class CappuccinoCommand implements Command {
    private final CoffeeMachine machine;
    public CappuccinoCommand(CoffeeMachine machine) { this.machine = machine; }
    @Override public void execute() { machine.makeCappuccino(); }
}
