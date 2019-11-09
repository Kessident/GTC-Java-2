package com.Windspinks.ExoticMoves;

import com.Windspinks.ExoticMoves.Model.*;
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

import java.io.*;
import java.util.ArrayList;

public class Main extends Application {
    private final File INVENTORY_FILE_LOCATION = new File("src/resources/inventory.dat");
    ArrayList<Car> inventoryList = new ArrayList<>();

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
            Car blackAstConv = new Aston("Black", true, 0, new File("/resources/images/BlkAstonConvertible.jpg"));
            Car blackFerrariConv = new Ferrari("Black", true, 0, new File("/resources/images/BlkFerrariConvertible.jpg"));
            Car blackLambo = new Lamborghini("Black", false, 0, new File("/resources/images/BlkLambo.jpg"));
            Car blackLamboConv = new Lamborghini("Black", true, 0, new File("/resources/images/BlkLamboConvertible.jpg"));
            Car blackMaserati = new Maserati("Black", false, 0, new File("/resources/images/BlkMaserati.jpg"));
            Car blackMcLaren = new McLaren("Black", false, 0, new File("/resources/images/BlkMcLaren.jpg"));
            Car blueAston = new Aston("Blue", false, 0, new File("/resources/images/BluAston.jpg"));
            Car blueFerrariConv = new Ferrari("Blue", true, 0, new File("/resources/images/BluFerrariConvertible.jpg"));
            Car blueLamboConv = new Lamborghini("Blue", true, 0, new File("/resources/images/BluLamboConvertible.jpg"));
            Car blueMaserati = new Maserati("Blue", false, 0, new File("/resources/images/BluMaserati.jpg"));
            Car blueMcLaren = new McLaren("Blue", false, 0, new File("/resources/images/BluMcLaren.jpg"));
            Car greenAston = new Aston("Green", false, 0, new File("/resources/images/GreenAston.jpg"));
            Car greenLambo = new Lamborghini("Green", false, 0, new File("/resources/images/GreenLambo.jpg"));
            Car greenMcLaren = new McLaren("Green", false, 0, new File("/resources/images/GreenMcLaren.jpg"));
            Car orangeMcLarenConv = new McLaren("Orange", true, 0, new File("/resources/images/OranMcLarConvertible.jpg"));
            Car redAstonConv = new Aston("Red", true, 0, new File("/resources/images/RedAstonConvertible.jpg"));
            Car redFerrari = new Ferrari("Red", false, 0, new File("/resources/images/RedFerrari.jpg"));
            Car redMaserati = new Maserati("Red", false, 0, new File("/resources/images/RedMaserati.jpg"));
            Car redMcLaren = new McLaren("Red", false, 0, new File("/resources/images/RedMcLaren.jpg"));
            Car whiteFerrari = new Ferrari("White", false, 0, new File("/resources/images/WhiteFerrari.jpg"));
            Car whiteFerrariConv = new Ferrari("White", true, 0, new File("/resources/images/WhiteFerrConvertible.jpg"));
            Car whiteLambo = new Lamborghini("White", false, 0, new File("/resources/images/WhiteLambo.jpg"));
            Car whiteMaseratiConv = new Maserati("White", true, 0, new File("/resources/images/WhiteMaserConvertible.jpg"));
            Car yellowFerrari = new Ferrari("Yellow", false, 0, new File("/resources/images/YellowFerrari.jpg"));
            Car yellowLambo = new Lamborghini("Yellow", false, 0, new File("/resources/images/YellowLambo.jpg"));
            Car yellowMcLaren = new McLaren("Yellow", false, 0, new File("/resources/images/YellowMcLaren.jpg"));

            try {
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(INVENTORY_FILE_LOCATION));
                oos.writeInt(26);
                oos.writeObject(blackAstConv);
                oos.writeObject(blackFerrariConv);
                oos.writeObject(blackLambo);
                oos.writeObject(blackLamboConv);
                oos.writeObject(blackMaserati);
                oos.writeObject(blackMcLaren);
                oos.writeObject(blueAston);
                oos.writeObject(blueFerrariConv);
                oos.writeObject(blueLamboConv);
                oos.writeObject(blueMaserati);
                oos.writeObject(blueMcLaren);
                oos.writeObject(greenAston);
                oos.writeObject(greenLambo);
                oos.writeObject(greenMcLaren);
                oos.writeObject(orangeMcLarenConv);
                oos.writeObject(redAstonConv);
                oos.writeObject(redFerrari);
                oos.writeObject(redMaserati);
                oos.writeObject(redMcLaren);
                oos.writeObject(whiteFerrari);
                oos.writeObject(whiteFerrariConv);
                oos.writeObject(whiteLambo);
                oos.writeObject(whiteMaseratiConv);
                oos.writeObject(yellowFerrari);
                oos.writeObject(yellowLambo);
                oos.writeObject(yellowMcLaren);
                oos.close();
            } catch (IOException ignored) {
            }

        }
    }
}
