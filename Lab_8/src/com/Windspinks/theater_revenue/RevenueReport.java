package com.Windspinks.theater_revenue;

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

import java.text.DecimalFormat;

public class RevenueReport extends Application {
    private final double BOX_OFFICE_PERCENTAGE = 0.20;

    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();

        Text titleText = new Text("Theatre Revenue Calculator");
        titleText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
        grid.add(titleText, 0, 0, 2, 1);

        grid.setAlignment(Pos.CENTER);
        grid.setHgap(20);
        grid.setVgap(20);
        grid.setPadding(new Insets(25, 25, 25, 25));
        Scene scene = new Scene(grid);
        scene.getStylesheets().add(getClass().getResource("../application.css").toExternalForm());


        Label adultPriceLabel = new Label("Price per\nAdult ticket");
        TextField adultPriceInput = new TextField("0.0");
        restrictInputToDoubles(adultPriceInput);
        setToZeroIfEmpty(adultPriceInput);
        HBox adultPriceBox = new HBox(4, adultPriceLabel, adultPriceInput);
        grid.add(adultPriceBox, 0, 2);

        Label adultTicketLabel = new Label("Adult tickets\nSold");
        TextField adultTicketInput = new TextField("0");
        restrictInputToIntegers(adultTicketInput);
        setToZeroIfEmpty(adultTicketInput);
        HBox adultTicketBox = new HBox(4, adultTicketLabel, adultTicketInput);
        grid.add(adultTicketBox, 0, 3);

        Label childPriceLabel = new Label("Price per\nChild ticket");
        TextField childPriceInput = new TextField("0.0");
        restrictInputToDoubles(childPriceInput);
        setToZeroIfEmpty(childPriceInput);
        HBox childPriceBox = new HBox(4, childPriceLabel, childPriceInput);
        grid.add(childPriceBox, 1, 2);

        Label childTicketLabel = new Label("Child tickets\nSold");
        TextField childTicketInput = new TextField("0");
        restrictInputToIntegers(childTicketInput);
        setToZeroIfEmpty(childTicketInput);
        HBox childTicketBox = new HBox(4, childTicketLabel, childTicketInput);
        grid.add(childTicketBox, 1, 3);
        //Price per adult ticket
        //Number

        //Price per child ticket
        //Number

        Text grossRevenueAdultText = new Text();
        Text netRevenueAdultText = new Text();
        Text grossRevenueChildText = new Text();
        Text netRevenueChildText = new Text();
        Text totalGrossRevenueText = new Text();
        Text totalNetRevenueText = new Text();
        Button submitButton = new Button("Submit");
        grid.add(submitButton, 0, 4);
        submitButton.setOnAction((ActionEvent event) -> {
            final double ADULT_TICKET_PRICE = Double.parseDouble(adultPriceInput.getText());
            final double ADULT_TICKETS_SOLD = Double.parseDouble(adultTicketInput.getText());
            final double CHILD_TICKET_PRICE = Double.parseDouble(childPriceInput.getText());
            final double CHILD_TICKETS_SOLD = Double.parseDouble(childTicketInput.getText());

            double grossRevenueAdult = ADULT_TICKET_PRICE * ADULT_TICKETS_SOLD;
            double netRevenueAdult = grossRevenueAdult * BOX_OFFICE_PERCENTAGE;
            double grossRevenueChild = CHILD_TICKET_PRICE * CHILD_TICKETS_SOLD;
            double netRevenueChild = grossRevenueChild * BOX_OFFICE_PERCENTAGE;
            double totalGrossRevenue = grossRevenueAdult + grossRevenueChild;
            double totalNetRevenue = netRevenueAdult + netRevenueChild;

            DecimalFormat df = new DecimalFormat("#.##");
            grossRevenueAdultText.setText("Gross revenue for Adult tickets: $" + df.format(grossRevenueAdult));
            netRevenueAdultText.setText("Net revenue for Adult tickets: $" + df.format(netRevenueAdult));
            grossRevenueChildText.setText("Gross revenue for Child tickets: $" + df.format(grossRevenueChild));
            netRevenueChildText.setText("Gross revenue for Child tickets: $" + df.format(netRevenueChild));
            totalGrossRevenueText.setText("Total gross revenue: $" + df.format(totalGrossRevenue));
            totalNetRevenueText.setText("Total net revenue: $" + df.format(totalNetRevenue));

            VBox revenueBox = new VBox(grossRevenueAdultText, netRevenueAdultText, grossRevenueChildText, netRevenueChildText, totalGrossRevenueText, totalNetRevenueText);
            grid.add(revenueBox, 0, 5, 2, 1);
            primaryStage.sizeToScene();
        });

        primaryStage.setTitle("Theater Revenue");
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
}
