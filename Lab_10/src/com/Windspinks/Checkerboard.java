package com.Windspinks;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Checkerboard extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox mainContainer = new VBox();
        GridPane checkerboard = new GridPane();
        Text infoText = new Text("Enter a number and press submit for an 'n x n' checkerboard to appear below: ");
        TextField numberInput = new TextField();
        restrictInputToIntegers(numberInput);
        Button submitButton = new Button("submit");

        submitButton.setOnAction((ActionEvent event) -> {
            final int HARD_CAP = 15;
            checkerboard.getChildren().clear();
            boolean makeBlack;


            int n = 0;
            try {
                if (!numberInput.getText().isEmpty())
                    n = Integer.parseInt(numberInput.getText());
            } catch (NumberFormatException ex) {
                //Stop trying to put in massive numbers
                n = HARD_CAP;
            }

            //15 hard Upper Limit
            n = n > HARD_CAP ? HARD_CAP : n;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    makeBlack = false;
                    TextField newCell = new TextField();
                    newCell.setEditable(false);

                    if (i % 2 == 0) {
                        if (j % 2 == 0) {
                            makeBlack = true;
                        }
                    } else {
                        if (j % 2 == 1) {
                            makeBlack = true;
                        }
                    }
                    if (makeBlack)
                        newCell.getStyleClass().add("black-cell");
                    else
                        newCell.getStyleClass().add("white-cell");
                    checkerboard.add(newCell, j, i);
                }
            }
            primaryStage.sizeToScene();
        });

        mainContainer.getChildren().addAll(infoText, numberInput, submitButton, checkerboard);

        Scene scene = new Scene(mainContainer);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Checkerboard");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void restrictInputToIntegers(TextField textField) {
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d+")) {
                textField.setText(newValue.replaceAll("[^\\d]", ""));

                if (!textField.getStyleClass().contains("invalid-input")) {
                    textField.getStyleClass().add("invalid-input");
                }
            } else {
                textField.getStyleClass().remove("invalid-input");
            }
        });
    }
}