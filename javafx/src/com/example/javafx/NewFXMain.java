/* Copyright © 2017 Oracle and/or its affiliates. All rights reserved. */

package com.example.javafx;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class NewFXMain extends Application {

    @Override
    public void start(Stage primaryStage) {
        final int APP_HEIGHT = 600;
        final int APP_WIDTH = 860;
        final int UI_Height = 28;
        final Font buttonFont = new Font(UI_Height);

        //Create the background
        Rectangle rect1 = new Rectangle(0, 0, APP_WIDTH, APP_HEIGHT);
        LinearGradient gradient1 = new LinearGradient(0, 1, 0, 0, true, CycleMethod.NO_CYCLE, new Stop[]{
                new Stop(0, Color.BLACK),
                new Stop(.825, Color.LIME),
                new Stop(.875, Color.BLACK),
        });
        rect1.setFill(gradient1);

        //Setup tool name and tagline
        Text toolName = new Text();
        toolName.setFill(Color.WHITE);
        toolName.setFont(Font.font(null, FontWeight.BOLD, 48));
        toolName.setX(0);
        toolName.setY(50);
        toolName.setText("BankTeller2000");

        Text marketingJibberish = new Text();
        marketingJibberish.setFill(Color.LIGHTGRAY);
        marketingJibberish.setFont(Font.font(null, FontWeight.BOLD, 24));
        marketingJibberish.setX(2);
        marketingJibberish.setY(75);
        marketingJibberish.setText("Helping you bring home the bacon");

        //Create the first row of buttons
        HBox buttonContainer1 = new HBox(10);
        buttonContainer1.setLayoutY(APP_HEIGHT * 0.5);
        buttonContainer1.setLayoutX(60);

        TextField ownerSearchBar = new TextField("Account Owner");
        ownerSearchBar.setMinHeight(60);
        ownerSearchBar.setMinWidth(300);
        ownerSearchBar.setFont(buttonFont);
        ownerSearchBar.setMaxSize(140, 20);

        Button btn1 = new Button();
        btn1.setFont(buttonFont);
        btn1.setText("Print Details");

        Button btn2 = new Button();
        btn2.setFont(buttonFont);
        btn2.setText("Close Accounts");

        buttonContainer1.getChildren().addAll(ownerSearchBar, btn1, btn2);

        //Create the second row of buttons
        HBox buttonContainer2 = new HBox(10);
        buttonContainer2.setLayoutY(APP_HEIGHT * 0.65);
        buttonContainer2.setLayoutX(60);

        TextField numberSearchBar = new TextField("Account Number");
        numberSearchBar.setMinHeight(60);
        numberSearchBar.setMinWidth(300);
        numberSearchBar.setFont(buttonFont);
        numberSearchBar.setMaxSize(140, 20);

        Button btn3 = new Button();
        btn3.setFont(buttonFont);
        btn3.setText("Deposit $200");

        Button btn4 = new Button();
        btn4.setFont(buttonFont);
        btn4.setText("Withdraw $200");

        buttonContainer2.getChildren().addAll(numberSearchBar, btn3, btn4);

        //Create the third row of buttons
        HBox buttonContainer3 = new HBox(10);
        buttonContainer3.setLayoutY(APP_HEIGHT * 0.8);
        buttonContainer3.setLayoutX(10);
        buttonContainer3.setMaxWidth(APP_WIDTH);

        Button btn5 = new Button();
        btn5.setFont(buttonFont);
        btn5.setText("Give Bonus");

        Button btn6 = new Button();
        btn6.setFont(buttonFont);
        btn6.setText("Earn Interest");

        Button btn7 = new Button();
        btn7.setFont(buttonFont);
        btn7.setText("Charge Fee");

        Button btn8 = new Button();
        btn8.setFont(buttonFont);
        btn8.setText("Reset Transactions");

        buttonContainer3.getChildren().addAll(btn5, btn6, btn7, btn8);

        //Other setup and display stuff
        Group root = new Group();
        root.getChildren().addAll(rect1, toolName, marketingJibberish, buttonContainer1, buttonContainer2, buttonContainer3);

        primaryStage.setTitle("BankTeller2000");
        primaryStage.setScene(new Scene(root, APP_WIDTH, APP_HEIGHT, Color.BLACK));
        primaryStage.show();

        //Create accounts
        ArrayList<Account> accountList = new ArrayList<>();
        accountList.add(new SavingsAccount("Duke", 100));
        accountList.add(new SavingsAccount("Damien", 20000));
        accountList.add(new SavingsAccount("Jessica", 50000));
        accountList.add(new SavingsAccount("Herbert", 500));
        accountList.add(new CheckingAccount("Duke", 0));
        accountList.add(new CheckingAccount("Jessica", 500));

        //create button controller
        ButtonController buttonController = new ButtonController(accountList, ownerSearchBar, numberSearchBar, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8);
    }

    public static void main(String[] args) {
        launch(args);
    }

}
