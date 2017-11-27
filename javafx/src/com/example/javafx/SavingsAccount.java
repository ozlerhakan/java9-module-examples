/* Copyright © 2017 Oracle and/or its affiliates. All rights reserved. */
package com.example.javafx;

public class SavingsAccount extends Account {
    //Fields
    private static String accountType = "Savings Account";
    private static double interestRate = 0.02;


    //Constructor
    public SavingsAccount(String o, double b) {
        super(o, b);
    }

    //Methods
    public void printDetails() {
        System.out.println(accountType + " #" + accountNum);
        super.printDetails();
        System.out.println("Interest Rate: " + interestRate);
        System.out.println("");
    }

    public void earnInterest() {
        balance = balance * (1 + interestRate / 12);
        System.out.println("Interest: $" + balance * (interestRate / 12));
        printDetails();
    }

    public String getAccountType() {
        return accountType;
    }

}
