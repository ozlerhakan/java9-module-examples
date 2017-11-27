/* Copyright © 2017 Oracle and/or its affiliates. All rights reserved. */
package com.example.javafx;

public class CheckingAccount extends Account {
    //Fields
    private static String accountType = "Checking Account";


    //Constructor
    public CheckingAccount(String o, double b) {
        super(o, b);
    }


    //Methods
    public void printDetails() {
        System.out.println(accountType + " #" + accountNum);
        super.printDetails();
        System.out.println("");
    }

    public String getAccountType() {
        return accountType;
    }

}
