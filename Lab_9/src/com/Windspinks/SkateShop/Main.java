package com.Windspinks.SkateShop;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class Main extends Application {

    private final double SALES_TAX = 0.06;
    private final String GRIP_TAPE_DESCRIPTION = "Grip Tape: $10";
    private final String GRIP_TAPE_ID = "GripTape";
    private final String BEARINGS_DESCRIPTION = "Bearings: $30";
    private final String BEARINGS_ID = "Bearings";
    private final String RISER_PADS_DESCRIPTION = "Riser Pads: $2";
    private final String RISER_PADS_ID = "RiserPads";
    private final String NUTS_KIT_DESCRIPTION = "Nuts & Bolts Kit: $3";
    private final String NUTS_KIT_ID = "NutsKit";

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox root = new VBox();
        root.setSpacing(10);
        Scene scene = new Scene(root);


        GridPane radioSelectsPane = new GridPane();
        root.getChildren().add(radioSelectsPane);


        VBox decksBox = mainItemCreator("Decks.txt");
        radioSelectsPane.add(decksBox, 0, 0);
        VBox assembliesBox = mainItemCreator("Truck Assemblies.txt");
        radioSelectsPane.add(assembliesBox, 1, 0);
        VBox wheelsBox = mainItemCreator("Wheels.txt");
        radioSelectsPane.add(wheelsBox, 2, 0);

        //
        //Misc Items
        //
        root.getChildren().add(miscItemCreator(GRIP_TAPE_DESCRIPTION, GRIP_TAPE_ID));
        root.getChildren().add(miscItemCreator(BEARINGS_DESCRIPTION, BEARINGS_ID));
        root.getChildren().add(miscItemCreator(RISER_PADS_DESCRIPTION, RISER_PADS_ID));
        root.getChildren().add(miscItemCreator(NUTS_KIT_DESCRIPTION, NUTS_KIT_ID));

        Text subtotalText = new Text();
        Text salesTaxText = new Text();
        Text grandTotalText = new Text();
        VBox pricingBox = new VBox(subtotalText, salesTaxText, grandTotalText);
        pricingBox.setVisible(false);

        Button submitButton = new Button("Submit");
        submitButton.setOnAction((ActionEvent event) -> {
            RadioButton decksSelectedButton = (RadioButton) ((RadioButton) scene.lookup("#MasterThrasher")).getToggleGroup().getSelectedToggle();
            RadioButton assembliesSelectedButton = (RadioButton) ((RadioButton) scene.lookup("#775InAxle")).getToggleGroup().getSelectedToggle();
            RadioButton wheelsSelectedButton = (RadioButton) ((RadioButton) scene.lookup("#51mmWheels")).getToggleGroup().getSelectedToggle();

            int decksPrice = 0;
            int assembliesPrice = 0;
            int wheelsPrice = 0;
            if (decksSelectedButton != null) {
                Label decksLabel = (Label) decksSelectedButton.getParent().getChildrenUnmodifiable().get(1);
                String decksText = decksLabel.getText();
                decksPrice += Integer.parseInt(decksText.substring(decksText.indexOf('$') + 1));
            }
            if (assembliesSelectedButton != null) {
                Label assembliesLabel = (Label) assembliesSelectedButton.getParent().getChildrenUnmodifiable().get(1);
                String assembliesText = assembliesLabel.getText();
                assembliesPrice += Integer.parseInt(assembliesText.substring(assembliesText.indexOf('$') + 1));
            }
            if (wheelsSelectedButton != null) {
                Label wheelsLabel = (Label) wheelsSelectedButton.getParent().getChildrenUnmodifiable().get(1);
                String wheelsText = wheelsLabel.getText();
                wheelsPrice += Integer.parseInt(wheelsText.substring(wheelsText.indexOf('$') + 1));
            }

            Spinner gripTapeSpinner = (Spinner) scene.lookup("#" + GRIP_TAPE_ID);
            int gripTapePrice = 10 * (Integer) gripTapeSpinner.getValue();
            Spinner bearingsSpinner = (Spinner) scene.lookup("#" + BEARINGS_ID);
            int bearingsPrice = 30 * (Integer) bearingsSpinner.getValue();
            Spinner riserPadsSpinner = (Spinner) scene.lookup("#" + RISER_PADS_ID);
            int riserPadsPrice = 2 * (Integer) riserPadsSpinner.getValue();
            Spinner nutsKitSpinner = (Spinner) scene.lookup("#" + NUTS_KIT_ID);
            int nutsKitPrice = 3 * (Integer) nutsKitSpinner.getValue();

            int subtotal = decksPrice + assembliesPrice + wheelsPrice + gripTapePrice + bearingsPrice + riserPadsPrice + nutsKitPrice;
            double salesTax = subtotal * SALES_TAX;
            double grandTotal = subtotal + salesTax;

            subtotalText.setText(String.format("Subtotal: $%d", subtotal));
            salesTaxText.setText(String.format("Sales Tax: $%.2f", salesTax));
            grandTotalText.setText(String.format("Grand total: $%.2f", grandTotal));

            if (!pricingBox.isVisible()) {
                root.getChildren().add(pricingBox);
                pricingBox.setVisible(true);
                primaryStage.sizeToScene();
            }

        });
        root.getChildren().add(submitButton);


        scene.getStylesheets().add(getClass().getResource("../application.css").toExternalForm());
        primaryStage.setTitle("The Skate Shop");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    private VBox mainItemCreator(String fileLoc) throws IOException {
        File itemFileLoc = new File(fileLoc);
        Scanner scn = new Scanner(itemFileLoc);
        Text text = new Text(scn.nextLine());

        VBox returnBox = new VBox();
        returnBox.setSpacing(5);
        returnBox.setPadding(new Insets(10));
        returnBox.getChildren().add(text);
        ToggleGroup toggleGroup = new ToggleGroup();


        while (scn.hasNextLine()) {
            String item = scn.nextLine();
            String itemDescription = item.split(",")[0];
            String itemID = item.split(",")[1];
            RadioButton radioButton = new RadioButton();
            radioButton.setToggleGroup(toggleGroup);
            radioButton.setId(itemID);
            Label label = new Label(itemDescription);
            label.setLabelFor(radioButton);
            HBox itemBox = new HBox(radioButton, label);
            returnBox.getChildren().add(itemBox);
        }

        scn.close();

        return returnBox;
    }

    private HBox miscItemCreator(String labelDescription, String spinnerID) {
        Spinner spinner = new Spinner(0, Integer.MAX_VALUE, 0);
        spinner.setId(spinnerID);
        Label label = new Label(labelDescription);
        label.setLabelFor(spinner);

        HBox returnBox = new HBox(label, spinner);
        returnBox.setAlignment(Pos.CENTER_LEFT);
//        returnBox.setSpacing(10);
        return returnBox;
    }
}
