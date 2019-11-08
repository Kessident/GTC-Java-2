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

    public static void main(String[] args) {
        launch(args);
    }

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
            Car blackAstConv = new Aston("Black", true, 0);
            Car blackFerrariConv = new Aston("Black", true, 0);
            Car blackLambo = new Aston("Black", false, 0);
            Car blackLamboConv = new Aston("Black", true, 0);
            Car blackMaserati = new Aston("Black", false, 0);
            Car blackMcLaren = new Aston("Black", false, 0);
            Car blueAston = new Aston("Blue", false, 0);
            Car blueFerrariConv = new Aston("Blue", true, 0);
            Car blueLamboConv = new Aston("Blue", true, 0);
            Car blueMaserati = new Aston("Blue", false, 0);
            Car blueMcLaren = new Aston("Blue", false, 0);
            Car greenAston = new Aston("Green", false, 0);
            Car greenLambo = new Aston("Green", false, 0);
            Car greenMcLaren = new Aston("Green", false, 0);
            Car orangeMcLarenConv = new Aston("Orange", true, 0);
            Car redAstonConv = new Aston("Red1", true, 0);
            Car redFerrari = new Aston("Red", false, 0);
            Car redMaserati = new Aston("Red", false, 0);
            Car redMcLaren = new Aston("Red", false, 0);
            Car whiteFerrari = new Aston("White", false, 0);
            Car whiteFerrariConv = new Aston("White", true, 0);
            Car whiteLambo = new Aston("White", false, 0);
            Car whiteMaseratiConv = new Aston("White", true, 0);
            Car yellowFerrari = new Aston("Yellow", false, 0);
            Car yellowLambo = new Aston("Yellow", false, 0);
            Car yellowMcLaren = new Aston("Yellow", false, 0);
        }
    }
}
