package com.Windspinks.travel_expenses;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class ExpenseReport extends Application {
    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        Scene scene = new Scene(grid);
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(20);
        grid.setVgap(20);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text travelExpenseTitle = new Text("Travel Expense Calculator");
        travelExpenseTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
        grid.add(travelExpenseTitle, 0, 0, 2, 1);


        Label daysLabel = new Label("Days");
        TextField daysInput = new TextField("0");
        restrictInputToIntegers(daysInput);
        setToZeroIfEmpty(daysInput);
        daysInput.setEditable(true);
        HBox daysBox = new HBox(4, daysLabel, daysInput);
        daysBox.setAlignment(Pos.CENTER_LEFT);
        grid.add(daysBox, 0, 1);

        Label airFareLabel = new Label("Cost of Airfare");
        TextField airfareInput = new TextField("0.0");
        restrictInputToDoubles(airfareInput);
        setToZeroIfEmpty(airfareInput);
        HBox airfareBox = new HBox(4, airFareLabel, airfareInput);
        airfareBox.setAlignment(Pos.CENTER_LEFT);
        grid.add(airfareBox, 1, 1);

        Label carRentalLabel = new Label("Car Rental Fees");
        TextField carRentalInput = new TextField("0.0");
        restrictInputToDoubles(carRentalInput);
        setToZeroIfEmpty(carRentalInput);
        HBox carRentalBox = new HBox(4, carRentalLabel, carRentalInput);
        carRentalBox.setAlignment(Pos.CENTER_LEFT);
        grid.add(carRentalBox, 0, 2);

        Label milesDrivenLabel = new Label("Miles Driven (If private car)");
        TextField milesDrivenInput = new TextField("0.0");
        restrictInputToDoubles(milesDrivenInput);
        setToZeroIfEmpty(milesDrivenInput);
        HBox milesDrivenBox = new HBox(4, milesDrivenLabel, milesDrivenInput);
        milesDrivenBox.setAlignment(Pos.CENTER_LEFT);
        grid.add(milesDrivenBox, 1, 2);

        Label conFeesLabel = new Label("Conference Registration Fees");
        TextField conFeesInput = new TextField("0.0");
        restrictInputToDoubles(conFeesInput);
        setToZeroIfEmpty(conFeesInput);
        HBox conFeesBox = new HBox(4, conFeesLabel, conFeesInput);
        conFeesBox.setAlignment(Pos.CENTER_LEFT);
        grid.add(conFeesBox, 0, 3);

        Label parkingLabel = new Label("Parking Fees");
        TextField parkingInput = new TextField("0.0");
        restrictInputToDoubles(parkingInput);
        setToZeroIfEmpty(parkingInput);
        HBox parkingBox = new HBox(4, parkingLabel, parkingInput);
        parkingBox.setAlignment(Pos.CENTER_LEFT);
        grid.add(parkingBox, 1, 3);

        Label lodgingLabel = new Label("Lodging Charges (per night)");
        TextField lodgingInput = new TextField("0.0");
        restrictInputToDoubles(lodgingInput);
        setToZeroIfEmpty(lodgingInput);
        HBox lodgingBox = new HBox(4, lodgingLabel, lodgingInput);
        lodgingBox.setAlignment(Pos.CENTER_LEFT);
        grid.add(lodgingBox, 0, 4);

        Label taxiLabel = new Label("Taxi Charges");
        TextField taxiInput = new TextField("0.0");
        restrictInputToDoubles(taxiInput);
        setToZeroIfEmpty(taxiInput);
        HBox taxiBox = new HBox(4, taxiLabel, taxiInput);
        taxiBox.setAlignment(Pos.CENTER_LEFT);
        grid.add(taxiBox, 1, 4);


        Text totalCost = new Text();
        Text allowedExpenses = new Text();
        Text underOrOver = new Text();
        VBox expenseReportBox = new VBox(totalCost, allowedExpenses, underOrOver);
        expenseReportBox.setVisible(false);


        Button submitButton = new Button("Submit");
        submitButton.setOnAction((ActionEvent event) -> {
            final double MEAL_REIMBURSEMENT = 37;
            final double PARKING_REIMBURSEMENT = 10;
            final double TAXI_REIMBURSEMENT = 20;
            final double LODGING_REIMBURSEMENT = 95;
            final double PRIVATE_VEHICLE_REIMBURSEMENT_PER_MILE = 0.27;

            final int DAYS_TRAVELING = Integer.parseInt(daysInput.getText());
            final double AIRFARE = Double.parseDouble(airfareInput.getText());
            final double CAR_RENTAL = Double.parseDouble(carRentalInput.getText());
            final double MILES_DRIVEN = Double.parseDouble(milesDrivenInput.getText());
            final double CON_REG_FEES = Double.parseDouble(conFeesInput.getText());
            final double PARKING_FEES = Double.parseDouble(parkingInput.getText());
            final double LODGING_CHARGES = Double.parseDouble(lodgingInput.getText());
            final double TAXI_CHARGES = Double.parseDouble(taxiInput.getText());
            final double TOTAL_EXPENSES = AIRFARE + CAR_RENTAL + CON_REG_FEES + PARKING_FEES + LODGING_CHARGES + TAXI_CHARGES;

            double mealReimbursement = DAYS_TRAVELING * MEAL_REIMBURSEMENT;
            double maxParkingReimbursement = DAYS_TRAVELING * PARKING_REIMBURSEMENT;
            double maxTaxiReimbursement = DAYS_TRAVELING * TAXI_REIMBURSEMENT;
            double maxLodgingReimbursement = DAYS_TRAVELING * LODGING_REIMBURSEMENT;
            double maxPrivateMilesReimbursement = MILES_DRIVEN * PRIVATE_VEHICLE_REIMBURSEMENT_PER_MILE;
            double totalExpensesCovered = 0;

            totalExpensesCovered += mealReimbursement;
            totalExpensesCovered += maxParkingReimbursement > PARKING_FEES ? PARKING_FEES : maxParkingReimbursement;
            totalExpensesCovered += maxTaxiReimbursement > TAXI_CHARGES ? TAXI_CHARGES : maxTaxiReimbursement;
            totalExpensesCovered += maxLodgingReimbursement > LODGING_CHARGES ? LODGING_CHARGES : maxLodgingReimbursement;
            totalExpensesCovered += maxPrivateMilesReimbursement;

            totalCost.setText("Total Expenses: $" + TOTAL_EXPENSES);
            allowedExpenses.setText("Total Expenses Reimbursed: $" + totalExpensesCovered);
            if (totalExpensesCovered > TOTAL_EXPENSES) { //Spent Less than Covered
                underOrOver.setText("You saved: $" + (totalExpensesCovered - TOTAL_EXPENSES));
            } else { //Oops
                underOrOver.setText("You must pay for: $" + (TOTAL_EXPENSES - totalExpensesCovered));
            }

            if (!expenseReportBox.isVisible()) {
                grid.add(expenseReportBox, 0, 6);
                expenseReportBox.setVisible(true);
                primaryStage.sizeToScene();
            }
        });
        grid.add(submitButton, 0, 5, 2, 1);


        scene.getStylesheets().add(getClass().getResource("../application.css").toExternalForm());
        primaryStage.setTitle("Expense Report");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void restrictInputToDoubles(TextField textField) {
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("[0-9]+(\\.)?+([0-9]{1,2})?")) {
                textField.setText(newValue.replaceAll("[^\\d.]", ""));
            }
        });
    }

    private void restrictInputToIntegers(TextField textField) {
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d")) {
                textField.setText(newValue.replaceAll("[^\\d.]", ""));
            }
        });
    }

    private void setToZeroIfEmpty(TextField textField) {
        textField.focusedProperty().addListener((obs, oldVal, newVal) -> {
            if (textField.getText().isEmpty()) {
                textField.setText("0");
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
