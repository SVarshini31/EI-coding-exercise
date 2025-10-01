package com.example.creational.singleton;

public class Main {
    public static void main(String[] args) {
        PrinterSpooler s1 = PrinterSpooler.getInstance();
        PrinterSpooler s2 = PrinterSpooler.getInstance();
        System.out.println("Same instance? " + (s1==s2));
        s1.submitJob("Report.pdf");
    }
}
