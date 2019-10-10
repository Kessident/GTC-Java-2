package com.Windspinks.Snappy;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;


//import javax.swing.event.ChangeEvent;
//import javax.swing.event.ChangeListener;

public class Main extends Application {
    GridPane root = new GridPane();
    Scene scene = new Scene(root);

    Text title = new Text("Welcome and thank you for you interest in applying to Snappy's Car Wash\nPlease enter your information below");
    ImageView snappyLogo = new ImageView(new Image("file:snappy_logo.jpg"));
    HBox titleBox = new HBox(title, snappyLogo);


    Label firstNameLabel = new Label("First Name: ");
    TextField firstNameInput = new TextField();
    Label lastNameLabel = new Label("Last Name: ");
    TextField lastNameInput = new TextField();
    Label addressLabel = new Label("Address: ");
    TextField addressInput = new TextField();
    Label cityLabel = new Label("City: ");
    TextField cityInput = new TextField();
    Label stateLabel = new Label("State: ");
    TextField stateInput = new TextField();
    Label zipCodeLabel = new Label("Zip Code: ");
    TextField zipCodeInput = new TextField();
    Label phoneLabel = new Label("Phone Number: ");
    TextField phoneInput = new TextField();
    Label emailLabel = new Label("Email Address: ");
    TextField emailInput = new TextField();
    Label genderLabel = new Label("Gender: ");
    Label mGenderLabel = new Label("M");
    RadioButton mGenderButton = new RadioButton();
    Label fGenderLabel = new Label("F");
    RadioButton fGenderButton = new RadioButton();
    Label xGenderLabel = new Label("X");
    RadioButton xGenderButton = new RadioButton();
    HBox genderBox = new HBox();
    ToggleGroup genderToggleGroup = new ToggleGroup();
    Label educationLabel = new Label("Education: ");
    ToggleButton hsEducation = new ToggleButton("High School");
    ToggleButton collegeEducation = new ToggleButton("College");
    ToggleButton graduateEducation = new ToggleButton("Graduate");
    VBox educationBox = new VBox(hsEducation, collegeEducation, graduateEducation);

    ToggleButton experienceButton = new ToggleButton("Experience working in a car wash?");

    Button submitButton = new Button("Submit");

    Text errorsText = new Text();


    Text confFName = new Text();
    Text confLName = new Text();
    Text confAddress = new Text();
    Text confCity = new Text();
    Text confState = new Text();
    Text confZIP = new Text();
    Text confPhone = new Text();
    Text confEmail = new Text();
    Text confGender = new Text();
    Text confEducation = new Text();
    Text confExperience = new Text();
    Text confNiceMessage = new Text();
    VBox confBox = new VBox(confFName, confLName, confAddress, confCity, confState, confZIP, confPhone, confEmail, confGender, confEducation, confExperience, confNiceMessage);

    @Override
    public void start(Stage primaryStage) throws Exception {

        snappyLogo.setFitHeight(50);
        snappyLogo.setFitWidth(50);

        //ToggleGroups
        mGenderButton.setToggleGroup(genderToggleGroup);
        mGenderButton.setId("M");
        fGenderButton.setToggleGroup(genderToggleGroup);
        fGenderButton.setId("F");
        xGenderButton.setToggleGroup(genderToggleGroup);
        xGenderButton.setId("X");

        root.add(titleBox, 0, 0, 2, 1);
        root.add(firstNameLabel, 0, 1);
        root.add(firstNameInput, 1, 1);
        root.add(lastNameLabel, 0, 2);
        root.add(lastNameInput, 1, 2);
        root.add(addressLabel, 0, 3);
        root.add(addressInput, 1, 3);
        root.add(cityLabel, 0, 4);
        root.add(cityInput, 1, 4);
        root.add(stateLabel, 0, 5);
        root.add(stateInput, 1, 5);
        stateInput.setTooltip(new Tooltip("2 characters max"));
        root.add(zipCodeLabel, 0, 6);
        root.add(zipCodeInput, 1, 6);
        restrictInputToIntegers(zipCodeInput);
        zipCodeInput.setTooltip(new Tooltip("Digits only, 5-10 digit length"));
        root.add(phoneLabel, 0, 7);
        root.add(phoneInput, 1, 7);
        restrictInputToIntegers(phoneInput);
        phoneInput.setTooltip(new Tooltip("Digits only, 10 digit length"));
        root.add(emailLabel, 0, 8);
        root.add(emailInput, 1, 8);
        emailInput.setTooltip(new Tooltip("Must contain '@' & '.com'"));
        genderBox.getChildren().addAll(mGenderLabel, mGenderButton, fGenderLabel, fGenderButton, xGenderLabel, xGenderButton);
        root.add(genderLabel, 0, 9);
        root.add(genderBox, 1, 9);
        root.add(educationLabel, 0, 10);
        root.add(educationBox, 1, 10);
        root.add(experienceButton, 0, 11, 2, 1);
        root.add(submitButton, 0, 12);

        submitButton.setOnAction(submitButtonPressed);

        errorsText.setVisible(false);
        confBox.setVisible(false);

        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    private EventHandler<ActionEvent> submitButtonPressed = (ActionEvent event) -> {
        boolean errored = false;
        errorsText.setText("");

        if (firstNameInput.getText().isEmpty()) {
            if (!firstNameInput.getStyleClass().contains("invalid-input")) { // Don't add same class multiple times
                firstNameInput.getStyleClass().add("invalid-input");
            }
            errorsText.setText(errorsText.getText() + "Empty First Name\n");
            errored = true;
        } else {
            firstNameInput.getStyleClass().remove("invalid-input");
        }

        if (lastNameInput.getText().isEmpty()) {
            if (!lastNameInput.getStyleClass().contains("invalid-input")) {
                lastNameInput.getStyleClass().add("invalid-input");
            }
            errorsText.setText(errorsText.getText() + "Empty Last Name\n");
            errored = true;
        } else {
            lastNameInput.getStyleClass().remove("invalid-input");
        }

        if (addressInput.getText().isEmpty()) {
            if (!addressInput.getStyleClass().contains("invalid-input")) {
                addressInput.getStyleClass().add("invalid-input");
            }
            errorsText.setText(errorsText.getText() + "Empty Address Name\n");
            errored = true;
        } else {
            addressInput.getStyleClass().remove("invalid-input");
        }

        if (cityInput.getText().isEmpty()) {
            if (!cityInput.getStyleClass().contains("invalid-input")) {
                cityInput.getStyleClass().add("invalid-input");
            }
            errorsText.setText(errorsText.getText() + "Empty City Name\n");
            errored = true;
        } else {
            cityInput.getStyleClass().remove("invalid-input");
        }

        if (stateInput.getText().length() > 2) {
            if (!stateInput.getStyleClass().contains("invalid-input")) {
                stateInput.getStyleClass().add("invalid-input");
            }
            errorsText.setText(errorsText.getText() + "State must be 2 character max\n");
            errored = true;
        } else {
            stateInput.getStyleClass().remove("invalid-input");
        }

        if (zipCodeInput.getText().length() > 10 || zipCodeInput.getText().length() < 5) {
            if (!zipCodeInput.getStyleClass().contains("invalid-input")) {
                zipCodeInput.getStyleClass().add("invalid-input");
            }
            errorsText.setText(errorsText.getText() + "Zip Code must be between 5 and 10 numbers\n");
            errored = true;
        } else {
            zipCodeInput.getStyleClass().remove("invalid-input");
        }

        if (phoneInput.getText().length() != 10) {
            if (!phoneInput.getStyleClass().contains("invalid-input")) {
                phoneInput.getStyleClass().add("invalid-input");
            }
            errorsText.setText(errorsText.getText() + "Phone Number must be 10 numbers\n");
            errored = true;
        } else {
            phoneInput.getStyleClass().remove("invalid-input");
        }

        if (!emailInput.getText().contains("@")) {
            if (!emailInput.getStyleClass().contains("invalid-input")) {
                emailInput.getStyleClass().add("invalid-input");
            }
            errorsText.setText(errorsText.getText() + "Email must contain '@'\n");
            errored = true;
        } else {
            emailInput.getStyleClass().remove("invalid-input");
        }
        if (!emailInput.getText().contains(".com")) {
            if (!emailInput.getStyleClass().contains("invalid-input")) {
                emailInput.getStyleClass().add("invalid-input");
            }
            errorsText.setText(errorsText.getText() + "Email must contain '.com'\n");
            errored = true;
        } else {
            emailInput.getStyleClass().remove("invalid-input");
        }

        if (genderToggleGroup.getSelectedToggle() == null) {
            if (!genderBox.getStyleClass().contains("invalid-input")) {
                genderBox.getStyleClass().add("invalid-input");
            }
            errorsText.setText(errorsText.getText() + "Please select a gender\n");
            errored = true;
        } else {
            genderBox.getStyleClass().remove("invalid-input");
        }

        //
        //Validated everything
        //
        if (errored) {
            if (!errorsText.isVisible()) {
                root.add(errorsText, 0, 13, 2, 1);
                errorsText.setVisible(true);
                root.getScene().getWindow().sizeToScene();
            }
        } else {
            confFName.setText("First Name: " + firstNameInput.getText());
            confLName.setText("Last Name: " + lastNameInput.getText());
            confAddress.setText("Address: " + addressInput.getText());
            confCity.setText("City: " + cityInput.getText());
            confState.setText("State: " + stateInput.getText());
            confZIP.setText("ZIP code: " + zipCodeInput.getText());
            confPhone.setText("Phone: " + phoneInput.getText());
            confEmail.setText("Email: " + emailInput.getText());
            confGender.setText("Gender: " + ((RadioButton) genderToggleGroup.getSelectedToggle()).getId());

            String educationString = "Education: ";
            if (hsEducation.isSelected()) {
                educationString += "\n\tHigh School";
            }
            if (collegeEducation.isSelected()) {
                educationString += "\n\tCollege";
            }
            if (graduateEducation.isSelected()) {
                educationString += "\n\tGraduate";
            }
            confEducation.setText(educationString);

            if (experienceButton.isSelected()) {
                confExperience.setText("Experience Working in a car wash");
            } else {
                confExperience.setVisible(false);
            }

            confNiceMessage.setText("Thank you for applying to Snappy Car Wash, your application has been taken into consideration for the position.\n" +
                "Have a nice day!");

            if (!confBox.isVisible()) {
                root.add(confBox, 0, 13, 2, 1);
                confBox.setVisible(true);
                root.addEventFilter(KeyEvent.ANY, KeyEvent::consume);
                root.addEventFilter(MouseEvent.ANY, MouseEvent::consume);
            }
            root.getScene().getWindow().sizeToScene();
        }
    };

    private void restrictInputToIntegers(TextField textField) {
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d")) {
                textField.setText(newValue.replaceAll("[^\\d.]", ""));
            }
        });
    }
}
