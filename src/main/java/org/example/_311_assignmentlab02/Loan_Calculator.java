package org.example._311_assignmentlab02;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Loan_Calculator extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create labels and text fields for user input and output
        Label lblInterestRate = new Label("Annual Interest Rate:");
        TextField tfInterestRate = new TextField();
        tfInterestRate.setPromptText("Enter APR");

        Label lblYears = new Label("Number of Years:");
        TextField tfYears = new TextField();
        tfYears.setPromptText("Enter Number of Years");

        Label lblLoanAmount = new Label("Loan Amount:");
        TextField tfLoanAmount = new TextField();
        tfLoanAmount.setPromptText("Enter Amount");

        Label lblMonthlyPayment = new Label("Monthly Payment:");
        TextField tfMonthlyPayment = new TextField();
        tfMonthlyPayment.setEditable(false);

        Label lblTotalPayment = new Label("Total Payment:");
        TextField tfTotalPayment = new TextField();
        tfTotalPayment.setEditable(false);

        // Create the calculate button
        Button btnCalculate = new Button("Calculate");
        btnCalculate.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 14px;");

        // Create a GridPane layout and configure its properties
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20));
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setAlignment(Pos.CENTER);

        // Add nodes to the grid pane with margins for better spacing
        addNodeWithMargin(gridPane, lblInterestRate, 0, 0);
        addNodeWithMargin(gridPane, tfInterestRate, 1, 0);
        addNodeWithMargin(gridPane, lblYears, 0, 1);
        addNodeWithMargin(gridPane, tfYears, 1, 1);
        addNodeWithMargin(gridPane, lblLoanAmount, 0, 2);
        addNodeWithMargin(gridPane, tfLoanAmount, 1, 2);
        addNodeWithMargin(gridPane, lblMonthlyPayment, 0, 3);
        addNodeWithMargin(gridPane, tfMonthlyPayment, 1, 3);
        addNodeWithMargin(gridPane, lblTotalPayment, 0, 4);
        addNodeWithMargin(gridPane, tfTotalPayment, 1, 4);
        addNodeWithMargin(gridPane, btnCalculate, 1, 5);

        // Create a scene and set it on the primary stage
        Scene scene = new Scene(gridPane, 450, 300);
        primaryStage.setTitle("Loan Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Set action for the calculate button
        btnCalculate.setOnAction(e -> {
            try {
                // Parse input values
                double interestRate = Double.parseDouble(tfInterestRate.getText());
                int years = Integer.parseInt(tfYears.getText());
                double loanAmount = Double.parseDouble(tfLoanAmount.getText());

                // Calculate monthly interest rate and payments
                double monthlyInterestRate = interestRate / 1200;
                double monthlyPayment = loanAmount * monthlyInterestRate /
                        (1 - 1 / Math.pow(1 + monthlyInterestRate, years * 12));
                double totalPayment = monthlyPayment * years * 12;

                // Display results
                tfMonthlyPayment.setText(String.format("$%.2f", monthlyPayment));
                tfTotalPayment.setText(String.format("$%.2f", totalPayment));
            } catch (NumberFormatException ex) {
                // Handle invalid input
                showError("Invalid input. Please enter numeric values.");
            }
        });
    }

    /**
     * Adds a node to the grid pane with a margin for better spacing.
     *
     * @param gridPane The GridPane to add the node to.
     * @param node     The node to be added.
     * @param colIndex The column index of the node.
     * @param rowIndex The row index of the node.
     */
    private void addNodeWithMargin(GridPane gridPane, javafx.scene.Node node, int colIndex, int rowIndex) {
        GridPane.setMargin(node, new Insets(5, 10, 5, 10)); // Add margins around the node
        gridPane.add(node, colIndex, rowIndex);
    }

    /**
     * Shows an error alert dialog with the specified message.
     *
     * @param message The error message to display.
     */
    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Input Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
