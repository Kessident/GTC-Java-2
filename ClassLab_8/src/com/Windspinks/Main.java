package com.Windspinks;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    /*
    Name: Jackson (3 months old)   Description: Very cuddly and lovable.  This pup is a steal for the price!   Price: $399
    Name: Furbie(4 months old)   Description: A playful handful. Grab him quick! He won't stay for long.   Price: $250
    Name: Lassiter (3.5 months old)   Description: Have you ever seen anything so cute?   Price: $500
     */
    ToggleGroup pupsToggleGroup = new ToggleGroup();

    ImageView jacksonView = new ImageView(new Image("file:pups/qt1.jpg"));
    RadioButton jacksonButton = new RadioButton();
    HBox jacksonBox = new HBox(jacksonButton, jacksonView);

    ImageView furbieView = new ImageView(new Image("file:pups/qt2.gif"));
    RadioButton furbieButton = new RadioButton();
    HBox furbieBox = new HBox(furbieButton, furbieView);

    ImageView lassiterView = new ImageView(new Image("file:pups/qt4.jpg"));
    RadioButton lassiterButton = new RadioButton();
    HBox lassiterBox = new HBox(lassiterButton, lassiterView);

    HBox pupsBox = new HBox(jacksonBox, furbieBox, lassiterBox);
    TextArea pupsDescription = new TextArea();

    VBox parentContainer = new VBox();


    @Override

    public void start(Stage primaryStage) throws Exception {
        parentContainer.getChildren().addAll(pupsBox, pupsDescription);
        //Set ButtonGroup
        jacksonButton.setToggleGroup(pupsToggleGroup);
        furbieButton.setToggleGroup(pupsToggleGroup);
        lassiterButton.setToggleGroup(pupsToggleGroup);
        //Image IDs
        jacksonButton.setId("Jackson");
        furbieButton.setId("Furbie");
        lassiterButton.setId("Lassiter");
        //Initial Image Heights
        jacksonView.setFitHeight(100);
        jacksonView.setFitWidth(100);
        furbieView.setFitHeight(100);
        furbieView.setFitWidth(100);
        lassiterView.setFitHeight(100);
        lassiterView.setFitWidth(100);
        //Set Event Handler
        jacksonButton.setOnAction(new ImageButtonHandler());
        furbieButton.setOnAction(new ImageButtonHandler());
        lassiterButton.setOnAction(new ImageButtonHandler());

        //Padding
        pupsBox.setPadding(new Insets(10));
        pupsBox.setSpacing(20);
        pupsBox.setAlignment(Pos.CENTER);

        Scene root = new Scene(parentContainer, 500, 350);
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(root);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    private class ImageButtonHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            RadioButton buttonClicked = (RadioButton) event.getSource();
            switch (buttonClicked.getId()) {
                case "Jackson":
                    pupsDescription.setText("Name: Jackson (3 months old)\nDescription: Very cuddly and lovable.  This pup is a steal for the price!\nPrice: $399");
                    pupsBox.setStyle("-fx-background-color: red");
                    jacksonView.setFitWidth(150);
                    jacksonView.setFitHeight(150);
                    furbieView.setFitHeight(100);
                    furbieView.setFitWidth(100);
                    lassiterView.setFitHeight(100);
                    lassiterView.setFitWidth(100);
                    break;
                case "Furbie":
                    pupsDescription.setText("Name: Furbie(4 months old)\nDescription: A playful handful. Grab him quick! He won't stay for long.\nPrice: $250");
                    pupsBox.setStyle("-fx-background-color: blue");
                    jacksonView.setFitHeight(100);
                    jacksonView.setFitWidth(100);
                    furbieView.setFitHeight(150);
                    furbieView.setFitWidth(150);
                    lassiterView.setFitHeight(100);
                    lassiterView.setFitWidth(100);
                    break;
                case "Lassiter":
                    pupsDescription.setText("Name: Lassiter (3.5 months old)\nDescription: Have you ever seen anything so cute?\nPrice: $500");
                    pupsBox.setStyle("-fx-background-color: green");
                    jacksonView.setFitHeight(100);
                    jacksonView.setFitWidth(100);
                    furbieView.setFitHeight(100);
                    furbieView.setFitWidth(100);
                    lassiterView.setFitHeight(150);
                    lassiterView.setFitWidth(150);
                    break;
                default:
            }
        }
    }
}
