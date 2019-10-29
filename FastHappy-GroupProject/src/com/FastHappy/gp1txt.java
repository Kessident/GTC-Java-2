package com.FastHappy;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @author thece
 */
public class gp1txt extends Application {


    Image burger = new Image("mooburger.jpg");


    ImageView im1 = new ImageView(burger);

    @Override
    public void start(Stage primaryStage) {
        //entrees
        Label entree = new Label("Entrees");
        Label msg1 = new Label("Moo Burger order amount: ");

        //item descriptions

        Label desc1 = new Label("Our famous Moo burger is 100% pure angus beef"
            + " topped with cheese, onions tomato and lettuce ");


        im1.setFitHeight(100);
        im1.setFitWidth(100);


        Button btn = new Button("Place order");


        final Spinner<Integer> spinner1 = new Spinner<>();
        final int initialValue = 50;

        // Value factory.
        SpinnerValueFactory<Integer> vf1 =
            new SpinnerValueFactory.IntegerSpinnerValueFactory(0, initialValue);


        spinner1.setValueFactory(vf1);


        VBox hb1 = new VBox(im1, msg1, spinner1, desc1);


        hb1.getStyleClass().add("menuItem");

        FlowPane vb = new FlowPane(hb1);

        vb.setPadding(new Insets(10, 10, 10, 10));
        vb.setVgap(10);
        vb.setHgap(10);

        vb.setPadding(new Insets(10));
        vb.setStyle("-fx-background-color: turquoise");

        Scene scene = new Scene(vb, 750, 750);
        scene.getStylesheets().add(getClass().getResource("FastHappy.css").toExternalForm());

        primaryStage.setTitle("HappyFood");
        primaryStage.setScene(scene);
        primaryStage.show();


    }


}
