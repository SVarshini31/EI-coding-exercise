package com.example.behavioral.command;

public class EspressoCommand implements Command {
    private final CoffeeMachine machine;
    public EspressoCommand(CoffeeMachine machine) { this.machine = machine; }
    @Override public void execute() { machine.makeEspresso(); }
}
