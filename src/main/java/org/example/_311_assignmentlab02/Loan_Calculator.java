package org.example._311_assignmentlab02;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Loan_Calculator extends Application {

    @Override
    public void start(Stage primaryStage) {
        Label lblInterestRate = new Label("Annual Interest Rate:");
        TextField tfInterestRate = new TextField();

        Label lblYears = new Label("Number of Years:");
        TextField tfYears = new TextField();

        Label lblLoanAmount = new Label("Loan Amount:");
        TextField tfLoanAmount = new TextField();

        Label lblMonthlyPayment = new Label("Monthly Payment:");
        TextField tfMonthlyPayment = new TextField();
        tfMonthlyPayment.setEditable(false);




    }
}