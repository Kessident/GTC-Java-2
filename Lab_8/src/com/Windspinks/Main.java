package com.Windspinks;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Main extends Application {
    //numDays
    //airfare TODO IF
    //carRental TODO IF
    //milesDriven TODO IF private vehicles
    //parking Fees TODO IF
    //taxi charges  TODO IF
    //conference/seminar registration fees TODO IF
    //lodging chargers (per night)
    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(20);
        grid.setVgap(20);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text travelExpenseTitle = new Text("Travel Expense Calculator");
        travelExpenseTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
        grid.add(travelExpenseTitle, 0, 0, 2, 1);


        Label daysLabel = new Label("Days");
        Spinner<Integer> daysInput = new Spinner<>(0, Integer.MAX_VALUE, 0);
        daysInput.setEditable(true);
        HBox daysBox = new HBox(4, daysLabel, daysInput);
        daysBox.setAlignment(Pos.CENTER_LEFT);
        grid.add(daysBox, 0, 1);

        Label airFareLabel = new Label("Cost of Airfare");
        Spinner<Double> airfareInput = new Spinner<>(0, Double.MAX_VALUE, 0.0);
        airfareInput.setEditable(true);
        HBox airfareBox = new HBox(4, airFareLabel, airfareInput);
        airfareBox.setAlignment(Pos.CENTER_LEFT);
        grid.add(airfareBox, 1, 1);

        Label carRentalLabel = new Label("Car Rental Fees");
        Spinner<Double> carRentalInput = new Spinner<>(0, Double.MAX_VALUE, 0.0);
        carRentalInput.setEditable(true);
        HBox carRentalBox = new HBox(4, carRentalLabel, carRentalInput);
        carRentalBox.setAlignment(Pos.CENTER_LEFT);
        grid.add(carRentalBox, 0, 2);

        Label milesDrivenLabel = new Label("Miles Driven (If private car)");
        Spinner<Double> milesDrivenInput = new Spinner<>(0, Double.MAX_VALUE, 0.0);
        milesDrivenInput.setEditable(true);
        HBox milesDrivenBox = new HBox(4, milesDrivenLabel, milesDrivenInput);
        milesDrivenBox.setAlignment(Pos.CENTER_LEFT);
        grid.add(milesDrivenBox, 1, 2);

        Label conFeesLabel = new Label("Conference Registration Fees");
        Spinner<Double> conFeesInput = new Spinner<>(0, Double.MAX_VALUE, 0.0);
        conFeesInput.setEditable(true);
        HBox conFeesBox = new HBox(4, conFeesLabel, conFeesInput);
        conFeesBox.setAlignment(Pos.CENTER_LEFT);
        grid.add(conFeesBox, 0, 3);

        Label parkingLabel = new Label("Parking Fees");
        Spinner<Double> parkingInput = new Spinner<>(0, Double.MAX_VALUE, 0.0);
        parkingInput.setEditable(true);
        HBox parkingBox = new HBox(4, parkingLabel, parkingInput);
        parkingBox.setAlignment(Pos.CENTER_LEFT);
        grid.add(parkingBox, 1, 3);

        Label lodgingLabel = new Label("Lodging Charges (per night)");
        Spinner<Double> lodgingInput = new Spinner<>(0, Double.MAX_VALUE, 0.0);
        lodgingInput.setEditable(true);
        HBox lodgingBox = new HBox(4, lodgingLabel, lodgingInput);
        lodgingBox.setAlignment(Pos.CENTER_LEFT);
        grid.add(lodgingBox, 0, 4);

        Label taxiLabel = new Label("Taxi Charges");
        Spinner<Double> taxiInput = new Spinner<>(0, Double.MAX_VALUE, 0.0);
        taxiInput.setEditable(true);
        HBox taxiBox = new HBox(4, taxiLabel, taxiInput);
        taxiBox.setAlignment(Pos.CENTER_LEFT);
        grid.add(taxiBox, 1, 4);


        Text totalCost = new Text();
        Text allowedExpenses = new Text();
        Text underOrOver = new Text();
        VBox expenseReportBox = new VBox(totalCost, allowedExpenses, underOrOver);
        expenseReportBox.setVisible(false);
        grid.add(expenseReportBox, 0, 6);


        Button submitButton = new Button("Submit");
        submitButton.setOnAction((ActionEvent event) -> {
            final double MEAL_REIMBURSEMENT = 37;
            final double PARKING_REIMBURSEMENT = 10;
            final double TAXI_REIMBURSEMENT = 20;
            final double LODGING_REIMBURSEMENT = 95;
            final double PRIVATE_VEHICLE_REIMBURSEMENT_PER_MILE = 0.27;

            final int DAYS_TRAVELING = daysInput.getValue();
            final double AIRFARE = airfareInput.getValue();
            final double CAR_RENTAL = carRentalInput.getValue();
            final double MILES_DRIVEN = milesDrivenInput.getValue();
            final double CON_REG_FEES = conFeesInput.getValue();
            final double PARKING_FEES = parkingInput.getValue();
            final double LODGING_CHARGES = lodgingInput.getValue();
            final double TAXI_CHARGES = taxiInput.getValue();
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
                expenseReportBox.setVisible(true);
            }
        });
        grid.add(submitButton, 0, 5, 2, 1);


        Scene scene = new Scene(grid);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
