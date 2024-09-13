package org.example._311_assignmentlab02;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.awt.event.ActionEvent;

public class HelloController{
    @FXML
    public Button calculateButton;
    @FXML
    public TextField APRTextField;
    @FXML
    public TextField numYearsTextField;
    @FXML
    public TextField LoanAmountTextField;
    @FXML
    public TextField monthlyPayTextField;
    @FXML
    public TextField TotalPayTextField;

    @FXML
    public void CalculateButtonClick(javafx.event.ActionEvent actionEvent) {
        // Store the values that are entered into the interest rate, num years, and loan amt textboxes
        double annualInterest = Double.parseDouble(APRTextField.getText());
        int numberOfYears = Integer.parseInt(numYearsTextField.getText());
        int loanAmount = Integer.parseInt(LoanAmountTextField.getText());

        // Calculate monthly pay using formula: Monthly Payment = (P * r) / n
        double monthlyPay = loanAmount * ((annualInterest / 100) / 12);
        monthlyPayTextField.setText("$" + monthlyPay);

        // Total payment = loan amount + the monthly pay across total num of months (12 * numYears)
        double totalPayment = loanAmount + (monthlyPay * (numberOfYears * 12));
        TotalPayTextField.setText("$" + totalPayment);
    }
}