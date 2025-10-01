package com.example.creational.singleton;

public class PrinterSpooler {
    private static volatile PrinterSpooler instance;
    private PrinterSpooler(){ System.out.println("PrinterSpooler initialized."); }

    public static PrinterSpooler getInstance() {
        if (instance==null) {
            synchronized (PrinterSpooler.class) {
                if (instance==null) instance = new PrinterSpooler();
            }
        }
        return instance;
    }

    public void submitJob(String job) {
        System.out.println("Submitting print job: " + job);
    }
}
