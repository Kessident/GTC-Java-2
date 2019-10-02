package com.Windspinks.Classwork.Lesson_9;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Lesson_9_Main extends Application {
    VBox bigBox = new VBox();
    Scene scene = new Scene(bigBox);

    ToggleGroup radioButtons = new ToggleGroup();

    RadioButton radioYellow = new RadioButton("Yellow");
    RadioButton radioWhite = new RadioButton("White");
    RadioButton radioPurple = new RadioButton("Purple");
    RadioButton radioBlack = new RadioButton("Black");

    HBox buttonsBox = new HBox(radioYellow, radioWhite, radioPurple, radioBlack);

    TextArea textArea = new TextArea();

    Image catFingerImage = new Image("https://ih1.redbubble.net/image.184395520.1161/st%2Csmall%2C215x235-pad%2C210x230%2Cf8f8f8.u2.jpg");
    ImageView catFingerImageView = new ImageView(catFingerImage);

    @Override
    public void start(Stage primaryStage) throws Exception {
        EventHandler<ActionEvent> colourHandler = (ActionEvent event) -> {
            RadioButton buttonClicked = (RadioButton) event.getSource();
            textArea.setText(buttonClicked.getId());
            String cssStyle = "-fx-background-color: " + buttonClicked.getId();
            bigBox.setStyle(cssStyle);
        };

        //Setup Radio Buttons
        radioYellow.setId("Yellow");
        radioYellow.setToggleGroup(radioButtons);
        radioYellow.setOnAction(colourHandler);
        radioWhite.setId("White");
        radioWhite.setToggleGroup(radioButtons);
        radioWhite.setOnAction(colourHandler);
        radioPurple.setId("Purple");
        radioPurple.setToggleGroup(radioButtons);
        radioPurple.setOnAction(colourHandler);
        radioBlack.setId("Black");
        radioBlack.setToggleGroup(radioButtons);
        radioBlack.setOnAction(colourHandler);

        //Buttons Box
        buttonsBox.setPadding(new Insets(20, 40, 40, 40));
        buttonsBox.setSpacing(20);

        //Image View
        catFingerImageView.setFitHeight(250);
        catFingerImageView.setFitWidth(250);
        catFingerImageView.autosize();

        
        bigBox.getChildren().addAll(buttonsBox, textArea, catFingerImageView);
        bigBox.setPadding(new Insets(10));


        primaryStage.setTitle("Classwork Lesson 9");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private class ColourHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            RadioButton buttonClicked = (RadioButton) event.getSource();
            textArea.setText(buttonClicked.getId());
        }
    }
}
