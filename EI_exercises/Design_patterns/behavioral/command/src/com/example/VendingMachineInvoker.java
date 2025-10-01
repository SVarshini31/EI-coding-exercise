package com.example.behavioral.command;

import java.util.HashMap;
import java.util.Map;

public class VendingMachineInvoker {
    private final Map<String, Command> buttons = new HashMap<>();
    public void setCommand(String button, Command cmd) { buttons.put(button, cmd); }
    public void pressButton(String button) {
        Command cmd = buttons.get(button);
        if (cmd != null) cmd.execute();
        else System.out.println("Invalid selection: " + button);
    }
}
