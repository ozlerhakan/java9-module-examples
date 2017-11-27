/* Copyright © 2017 Oracle and/or its affiliates. All rights reserved. */
package com.example.javafx;

import java.util.ArrayList;
import java.util.function.Predicate;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ButtonController {

    ArrayList<Account> accountList = new ArrayList<>();
    TextField ownerSearchBar;
    TextField numberSearchBar;
    Button printDetail;
    Button closeAccount;
    Button deposit200;
    Button withdraw200;
    Button giveBonus;
    Button earnInterest;
    Button chargeFee;
    Button resetTransactions;
    Predicate<Account> matchAccountOwner = null;  //Replace null
    Predicate<Account> matchAccountNumber = null; //Replace null


    public ButtonController(ArrayList list, TextField o, TextField n, Button b1, Button b2, Button b3, Button b4, Button b5, Button b6, Button b7, Button b8) {
        accountList = list;
        ownerSearchBar = o;
        numberSearchBar = n;
        printDetail = b1;
        closeAccount = b2;
        deposit200 = b3;
        withdraw200 = b4;
        giveBonus = b5;
        earnInterest = b6;
        chargeFee = b7;
        resetTransactions = b8;
        interactions();
    }

    //Which method do you call when a button is pressed?
    private void interactions() {

        closeAccount.setOnMousePressed(e -> button2Pressed());
        deposit200.setOnMousePressed(e -> button3Pressed());


        earnInterest.setOnMousePressed(e -> button6Pressed());


    }

    //Print details for each account belonging to the specified owner.
    private void button1Pressed() {


    }

    //Close each account belonging to the specified owner.
    private void button2Pressed() {
        accountList.stream()
                .filter(a -> a.getAccountOwner().equals(ownerSearchBar.getText()))
                .forEach(a -> {
                    System.out.println("CLOSING");
                    a.printDetails();
                });
        accountList.removeIf(a -> a.getAccountOwner().equals(ownerSearchBar.getText()));
    }

    //Deposit $200 into the specified account.
    private void button3Pressed() {
        accountList.stream()
                .filter(a -> String.valueOf(a.getAccountNumber()).equals(numberSearchBar.getText()))
                .forEach(a -> a.deposit(200));
    }

    //Withdraw $200 from the specified account.
    private void button4Pressed() {


    }

    //Deposit a bonus $20 for each savings account with a balance of at least $20,000.
    private void button5Pressed() {


    }

    //Earn interest for each savings account.
    private void button6Pressed() {
        accountList.stream()
                .filter(a -> a.getAccountType().equals("Savings Account"))
                .forEach(a -> ((SavingsAccount) a).earnInterest());
    }

    //Charge a $35 fee for each checking account with fewer than 1 transactions.
    private void button7Pressed() {


    }

    //Reset all transactions to 0.
    private void button8Pressed() {


    }

}
