package com.Windspinks;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class RadioButtons extends Application {

    private ToggleGroup toggleGroup = new ToggleGroup();

    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();

        toggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {
                if (toggleGroup.getSelectedToggle() != null) {
                    gridPane.setStyle("-fx-background-color: " + toggleGroup.getSelectedToggle().getUserData());
                }
            }
        });

        gridPane.add(createABox("yellow"), 0, 0);
        gridPane.add(createABox("white"), 1, 0);
        gridPane.add(createABox("purple"), 0, 1);
        gridPane.add(createABox("black"), 1, 1);

        primaryStage.setScene(new Scene(gridPane));
        primaryStage.setTitle("Colour Changing Radio Buttons");
        primaryStage.show();
    }

    private HBox createABox(String colour) {
        RadioButton colourButton = new RadioButton();
        colourButton.setUserData(colour);
        colourButton.setToggleGroup(toggleGroup);
        HBox returnMeBox = new HBox(colourButton);
        returnMeBox.setMinHeight(100);
        returnMeBox.setMinWidth(100);
        returnMeBox.setAlignment(Pos.CENTER);

        return returnMeBox;
    }
}