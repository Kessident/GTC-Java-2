package com.Windspinks.CellPhones;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Main extends Application {

    private final double _300MINUTES = 45.00;
    private final double _800MINUTES = 65.00;
    private final double _1500MINUTES = 99.00;
    private final double MODEL_100_PRICE = 29.95;
    private final double MODEL_110_PRICE = 49.95;
    private final double MODEL_2000_PRICE = 99.95;
    private final double SALES_TAX = 0.06;
    private final double VOICE_MAIL = 5.0;
    private final double TEXTING = 10.00;

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox root = new VBox();
        Scene scene = new Scene(root);
        Text finalPriceText = new Text();
        finalPriceText.setVisible(false);


        //
        //Minutes Boxes
        //
        VBox minutesPlanBox = new VBox();
//        minutesPlanBox.setSpacing(5);
//        minutesPlanBox.setPadding(new Insets(10));
        Text minutesText = new Text("Minutes Plans");
        ToggleGroup minutesToggleGroup = new ToggleGroup();

        HBox threeMinutesBox = new HBox();
        ToggleButton threeMinutesButton = new ToggleButton("300 minutes: $45.00");
        threeMinutesButton.setId("300Minutes");
        threeMinutesButton.setToggleGroup(minutesToggleGroup);
        threeMinutesBox.getChildren().addAll(threeMinutesButton);

        HBox eightMinutesBox = new HBox();
        ToggleButton eightMinutesButton = new ToggleButton("800 minutes: $65.00");
        eightMinutesButton.setId("800Minutes");
        eightMinutesButton.setToggleGroup(minutesToggleGroup);
        eightMinutesBox.getChildren().addAll(eightMinutesButton);

        HBox fifteenMinutesBox = new HBox();
        ToggleButton fifteenMinutesButton = new ToggleButton("1500 minutes: $99.00");
        fifteenMinutesButton.setId("1500Minutes");
        fifteenMinutesButton.setToggleGroup(minutesToggleGroup);
        fifteenMinutesBox.getChildren().addAll(fifteenMinutesButton);

        minutesPlanBox.getChildren().addAll(minutesText, threeMinutesBox, eightMinutesBox, fifteenMinutesBox);
        root.getChildren().add(minutesPlanBox);

        //
        //Phone Boxes
        //
        VBox phonesBox = new VBox();
        Text phonesText = new Text("Phones");

        ToggleGroup phonesToggleGroup = new ToggleGroup();

        HBox model100Box = new HBox();
        ToggleButton model100Button = new ToggleButton("Model 100: $29.95");
        model100Button.setId("Model100");
        model100Button.setToggleGroup(phonesToggleGroup);
        model100Box.getChildren().addAll(model100Button);

        HBox model110Box = new HBox();
        ToggleButton model110Button = new ToggleButton("Model 110: $49.95");
        model100Button.setId("Model110");
        model110Button.setToggleGroup(phonesToggleGroup);
        model110Box.getChildren().addAll(model110Button);

        HBox model200Box = new HBox();
        ToggleButton model200Button = new ToggleButton("Model 200: $99.95");
        model100Button.setId("Model200");
        model200Button.setToggleGroup(phonesToggleGroup);
        model200Box.getChildren().addAll(model200Button);

        phonesBox.getChildren().addAll(phonesText, model100Box, model110Box, model200Box);
        root.getChildren().add(phonesBox);

        ToggleButton voiceMailButton = new ToggleButton("Voice mail: $5");
        voiceMailButton.setId("VoiceMail");
        ToggleButton textingButton = new ToggleButton("Text messaging: $10");
        textingButton.setId("Texting");
        root.getChildren().addAll(voiceMailButton, textingButton);

        EventHandler<ActionEvent> onButtonPress = (ActionEvent event) -> {
            double finalPrice = 0;
            ToggleButton minutesButton = (ToggleButton) minutesToggleGroup.getSelectedToggle();
            ToggleButton phoneButton = (ToggleButton) phonesToggleGroup.getSelectedToggle();
            if (minutesButton != null) {
                String buttonText = minutesButton.getText();
                finalPrice += Double.parseDouble(buttonText.substring(buttonText.indexOf('$') + 1));
            }
            if (phoneButton != null) {
                String buttonText = phoneButton.getText();
                finalPrice += Double.parseDouble(buttonText.substring(buttonText.indexOf('$') + 1));
            }
            if (voiceMailButton.isSelected())
                finalPrice += 5;
            if (textingButton.isSelected())
                finalPrice += 10;

            finalPriceText.setText(String.format("Total Price monthly: $%.2f", finalPrice));
            if (!finalPriceText.isVisible()) {
                finalPriceText.setVisible(true);
            }
            primaryStage.sizeToScene();
        };

        threeMinutesButton.setOnAction(onButtonPress);
        eightMinutesButton.setOnAction(onButtonPress);
        fifteenMinutesButton.setOnAction(onButtonPress);
        model100Button.setOnAction(onButtonPress);
        model110Button.setOnAction(onButtonPress);
        model200Button.setOnAction(onButtonPress);
        voiceMailButton.setOnAction(onButtonPress);
        textingButton.setOnAction(onButtonPress);

        root.getChildren().add(finalPriceText);


        scene.getStylesheets().add(getClass().getResource("../application.css").toExternalForm());
        primaryStage.setTitle("Cell Solutions");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


}
