package com.Windspinks.ExoticMoves;

import com.Windspinks.ExoticMoves.Model.Aston;
import com.Windspinks.ExoticMoves.Model.Car;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.File;

public class Main extends Application {
    private final File INVENTORY_FILE_LOCATION = new File("src/resources/inventory.dat");

    @Override
    public void start(Stage primaryStage) {
        VBox outerBox = new VBox();
        Label exoticMovesTitle = new Label("Exotic Moves");
        exoticMovesTitle.setFont(Font.font("Verdana", FontWeight.BOLD, 40));
        exoticMovesTitle.setAlignment(Pos.CENTER);

        FlowPane inventoryFlowPane = new FlowPane();
        ScrollPane inventoryScrollPane = new ScrollPane();
        inventoryScrollPane.setContent(inventoryFlowPane);

        outerBox.getChildren().add(exoticMovesTitle);
        Scene scene = new Scene(outerBox, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exotic Moves");
        primaryStage.show();
    }

    private void createInitialInventory() {
        if (!INVENTORY_FILE_LOCATION.exists()) {
            Car BlackAstConv = new Aston("Black", true, 0);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
