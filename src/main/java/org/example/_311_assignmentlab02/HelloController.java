package org.example._311_assignmentlab02;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * Controller class for handling the logic of the LoanCalculator UI.
 */
public class HelloController {

    // Reference to the calculate button in the FXML file
    @FXML
    public Button calculateButton;

    // Reference to the text fields in the FXML file
    @FXML
    public TextField APRTextField; // Annual Interest Rate input
    @FXML
    public TextField numYearsTextField; // Number of years input
    @FXML
    public TextField LoanAmountTextField; // Loan amount input
    @FXML
    public TextField monthlyPayTextField; // Output for monthly payment
    @FXML
    public TextField TotalPayTextField; // Output for total payment

    /**
     * Handles the button click event to calculate loan payments.
     *
     * @param actionEvent The action event triggered by the button click.
     */
    @FXML
    public void CalculateButtonClick(javafx.event.ActionEvent actionEvent) {
        try {
            // Retrieve and parse user inputs
            double annualInterest = Double.parseDouble(APRTextField.getText());
            int numberOfYears = Integer.parseInt(numYearsTextField.getText());
            int loanAmount = Integer.parseInt(LoanAmountTextField.getText());

            // Calculate monthly payment using the formula:
            // Monthly Payment = (P * r) / n
            // Where P is the principal, r is the monthly interest rate, and n is the number of payments per year
            double monthlyInterestRate = (annualInterest / 100) / 12; // Convert annual interest rate to monthly
            double monthlyPay = loanAmount * monthlyInterestRate;
            monthlyPayTextField.setText("$" + String.format("%.2f", monthlyPay));

            // Calculate total payment over the life of the loan
            // Total Payment = Loan Amount + (Monthly Payment * Total Number of Payments)
            // Total Number of Payments = Number of Years * 12 (months per year)
            double totalPayment = loanAmount + (monthlyPay * (numberOfYears * 12));
            TotalPayTextField.setText("$" + String.format("%.2f", totalPayment));
        } catch (NumberFormatException e) {
            // Handle the case where the input values are not valid numbers
            monthlyPayTextField.setText("Invalid input");
            TotalPayTextField.setText("Invalid input");
        }
    }
}
