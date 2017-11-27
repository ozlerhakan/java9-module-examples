/* Copyright © 2017 Oracle and/or its affiliates. All rights reserved. */
package com.example.javafx;

public abstract class Account {
    //Fields
    protected String accountOwner;
    protected double balance;
    protected int accountNum;
    protected int transactions = 0;
    protected static int nextAccountNum = 0;

    //Constructor
    public Account(String o, double b) {
        accountOwner = o;
        balance = b;
        setAccountNumber();
        System.out.println("New Account:");
        printDetails();
    }


    //Methods
    public void printDetails() {
        System.out.println("Account Owner: " + accountOwner);
        System.out.println("Balance: $" + balance);
        System.out.println("Transactions: " + transactions);
    }

    public void deposit(double x) {
        if (x > 0) {
            balance = balance + x;
            System.out.println("Deposit: $" + x);
            transactions++;
        } else {
            System.out.println("Cannot deposit negative amount: " + x);
        }
        printDetails();
    }

    public void withdraw(double x) {
        if (x > 0 && (balance - x > 0)) {
            balance = balance - x;
            System.out.println("Withdraw: $" + x);
            transactions++;
        } else if (x < 0) {
            System.out.println("Cannot withdraw negative amount: " + x);
        } else if (balance - x < 0) {
            System.out.println("Cannot withdraw $" + x + " from $" + balance + " account");
            System.out.println("Balance cannot go negative.");
        }
        printDetails();
    }

    public void resetTransactions() {
        transactions = 0;
        System.out.println("Resetting Transactions to 0");
        printDetails();
    }

    private void setAccountNumber() {
        accountNum = nextAccountNum;
        nextAccountNum++;
    }

    //Getter Methods, used to get the values of fields
    public String getAccountOwner() {
        return accountOwner;
    }

    public double getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountNum;
    }

    public int getTransactions() {
        return transactions;
    }

    public abstract String getAccountType();
}
