package com.Windspinks;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class RadioButtons extends Application {

    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();

        ToggleGroup toggleGroup = new ToggleGroup();
        RadioButton yellowBtn = new RadioButton();
        RadioButton whiteBtn = new RadioButton();
        RadioButton purpleBtn = new RadioButton();
        RadioButton blackBtn = new RadioButton();
        yellowBtn.setToggleGroup(toggleGroup);
        yellowBtn.setUserData("yellow");
        whiteBtn.setToggleGroup(toggleGroup);
        whiteBtn.setUserData("white");
        purpleBtn.setToggleGroup(toggleGroup);
        purpleBtn.setUserData("purple");
        blackBtn.setToggleGroup(toggleGroup);
        blackBtn.setUserData("black");
        HBox yellowBox = new HBox(yellowBtn);

        toggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {
                if (toggleGroup.getSelectedToggle() != null) {
                    gridPane.setStyle("-fx-background-color: " + toggleGroup.getSelectedToggle().getUserData());
                }
            }
        });

        yellowBox.setMinHeight(100);
        yellowBox.setMinWidth(100);
        yellowBox.setAlignment(Pos.CENTER);
        HBox whiteBox = new HBox(whiteBtn);
        whiteBox.setMinHeight(100);
        whiteBox.setMinWidth(100);
        whiteBox.setAlignment(Pos.CENTER);
        HBox purpleBox = new HBox(purpleBtn);
        purpleBox.setMinHeight(100);
        purpleBox.setMinWidth(100);
        purpleBox.setAlignment(Pos.CENTER);
        HBox blackBox = new HBox(blackBtn);
        blackBox.setMinHeight(100);
        blackBox.setMinWidth(100);
        blackBox.setAlignment(Pos.CENTER);


        gridPane.add(yellowBox, 0, 0);
        gridPane.add(whiteBox, 1, 0);
        gridPane.add(purpleBox, 0, 1);
        gridPane.add(blackBox, 1, 1);

        primaryStage.setScene(new Scene(gridPane));
        primaryStage.setTitle("Colour Changing Radio Buttons");
        primaryStage.show();
    }
}
