package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.event.ActionListener;

/**
 * @author windspinks
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {


        /*
        Label userInputLabel = new Label("Anything you type here: ");
        TextField userInputField = new TextField();
        Label userOutputLabel = new Label("Will appear here: ");
        TextField userOutputField = new TextField();

        Label btnLabel = new Label("After clicking ");
        Button btn = new Button();
        btn.setText("this button");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String textInField = userInputField.getText();
                userOutputField.setText(textInField);
            }
        });

        HBox userInputHBox = new HBox();
        userInputHBox.getChildren().addAll(userInputLabel, userInputField);
        HBox userOutputHBox = new HBox();
        userOutputHBox.getChildren().addAll(userOutputLabel, userOutputField);
        HBox btnHBox = new HBox();
        btnHBox.getChildren().addAll(btnLabel, btn);

        VBox root = new VBox();
        root.getChildren().addAll(userInputHBox, userOutputHBox, btnHBox);
*/
        Label beatlesLabel = new Label("Choose Your Favourite Beatle");
        RadioButton johnRadio = new RadioButton("John");
        RadioButton paulRadio = new RadioButton("Paul");
        RadioButton georgeRadio = new RadioButton("George");
        RadioButton ringoRadio = new RadioButton("Ringo");
        ToggleGroup beatlesRadioButtons = new ToggleGroup();
        johnRadio.setToggleGroup(beatlesRadioButtons);
        paulRadio.setToggleGroup(beatlesRadioButtons);
        georgeRadio.setToggleGroup(beatlesRadioButtons);
        ringoRadio.setToggleGroup(beatlesRadioButtons);
        TextField favouriteBeatleTextField = new TextField();


        EventHandler<ActionEvent> beatlesRadioEventHandler = event -> {
            RadioButton sourceButton = (RadioButton) event.getSource();
            String favBeatle = sourceButton.getText();
            favouriteBeatleTextField.setText("Your favourite Beatle is " + favBeatle);
        };
        johnRadio.setOnAction(beatlesRadioEventHandler);
        paulRadio.setOnAction(beatlesRadioEventHandler);
        georgeRadio.setOnAction(beatlesRadioEventHandler);
        ringoRadio.setOnAction(beatlesRadioEventHandler);


        //
        //Adding Controls to Scenes
        //
        HBox radioButtonsBox = new HBox();
        radioButtonsBox.getChildren().addAll(johnRadio, paulRadio, georgeRadio, ringoRadio);
        VBox root = new VBox();
        root.getChildren().addAll(beatlesLabel, radioButtonsBox, favouriteBeatleTextField);
        Scene scene = new Scene(root);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
