package com.Windspinks.Classwork.Lesson_9;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Lesson_9_Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox bigBox = new VBox();
        Scene scene = new Scene(bigBox, 350, 350);

        ToggleGroup radioButtons = new ToggleGroup();
        RadioButton colourSelectPink = new RadioButton("Pink");
        RadioButton colourSelectBlue = new RadioButton("Blue");
        RadioButton colourSelectWhite = new RadioButton("White");
        colourSelectPink.setToggleGroup(radioButtons);
        colourSelectBlue.setToggleGroup(radioButtons);
        colourSelectWhite.setToggleGroup(radioButtons);

        HBox buttonsBox = new HBox(colourSelectPink, colourSelectBlue, colourSelectWhite);
        TextArea textArea = new TextArea();

        bigBox.getChildren().addAll(buttonsBox, textArea);


        primaryStage.setTitle("Classwork Lesson 9");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
