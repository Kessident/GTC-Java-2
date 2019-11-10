package com.Windspinks.ExoticMoves;

import com.Windspinks.ExoticMoves.Model.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class Main extends Application {
    private final File INVENTORY_DIRECTORY = new File("src/resources/inventory");
    private final File ASTON_INVENTORY_FILE_LOCATION = new File("src/resources/inventory/aston.dat");
    private final File FERRARI_INVENTORY_FILE_LOCATION = new File("src/resources/inventory/ferrari.dat");
    private final File LAMBO_INVENTORY_FILE_LOCATION = new File("src/resources/inventory/lamborghini.dat");
    private final File MCLAREN_INVENTORY_FILE_LOCATION = new File("src/resources/inventory/mclaren.dat");
    private final File MASERATI_INVENTORY_FILE_LOCATION = new File("src/resources/inventory/maserati.dat");
    ArrayList<Car> inventoryList = new ArrayList<>();
    ArrayList<Car> inventoryFiltered = new ArrayList<>();
    ArrayList<CheckBox> filtersList = new ArrayList<>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        createInitialInventory();
        readInventory();
        VBox outerBox = new VBox();
        Label exoticMovesTitle = new Label("Exotic Moves");
        exoticMovesTitle.setFont(Font.font("Verdana", FontWeight.BOLD, 40));
        outerBox.setAlignment(Pos.TOP_CENTER);
        outerBox.getChildren().add(exoticMovesTitle);
        outerBox.getChildren().add(createFilterBox());

        FlowPane inventoryFlowPane = new FlowPane();
        ScrollPane inventoryScrollPane = new ScrollPane();
        inventoryScrollPane.setContent(inventoryFlowPane);

        Scene scene = new Scene(outerBox, 500, 500);
        scene.getStylesheets().add(getClass().getResource("ExoticMoves.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exotic Moves");
        primaryStage.show();
    }

    private HBox createFilterBox() {
        VBox brandFilterBox = new VBox();
        Text brandFilterTitle = new Text("Filter by brand");
        CheckBox brandAstonCheck = new CheckBox("Aston Martin");
        CheckBox brandFerrariCheck = new CheckBox("Ferrari");
        CheckBox brandLamboCheck = new CheckBox("Lamborghini");
        CheckBox brandMclarenCheck = new CheckBox("McLaren");
        CheckBox brandMaseratiCheck = new CheckBox("Maserati");

        brandFilterBox.getChildren().addAll(brandFilterTitle, brandAstonCheck, brandFerrariCheck, brandLamboCheck, brandMclarenCheck, brandMaseratiCheck);

        VBox colorFilterBox = new VBox();

        VBox isConvFilterBox = new VBox();

        VBox cylinderFilterBox = new VBox();

        VBox priceFilterBox = new VBox();

        Button filterButton = new Button("Filter");
        Button clearFilterButton = new Button("Clear Filters");

        return new HBox(brandFilterBox, colorFilterBox, isConvFilterBox, cylinderFilterBox, priceFilterBox, filterButton, clearFilterButton);
    }

    private void createInitialInventory() {
        if (!INVENTORY_DIRECTORY.exists()) {
            if (!INVENTORY_DIRECTORY.mkdir()) {
                System.out.println("Inventory Folder not created, terminating.");
                System.exit(1);
            }

            if (!ASTON_INVENTORY_FILE_LOCATION.exists()) {
                ArrayList<Car> astonInitInv = new ArrayList<>();
                astonInitInv.add(new Aston("Black", true, 0, new File("/resources/images/BlkAstonConvertible.jpg")));
                astonInitInv.add(new Aston("Blue", false, 0, new File("/resources/images/BluAston.jpg")));
                astonInitInv.add(new Aston("Green", false, 0, new File("/resources/images/GreenAston.jpg")));
                astonInitInv.add(new Aston("Red", true, 0, new File("/resources/images/RedAstonConvertible.jpg")));
                writeInventory(astonInitInv, ASTON_INVENTORY_FILE_LOCATION);
            }
            if (!FERRARI_INVENTORY_FILE_LOCATION.exists()) {
                ArrayList<Car> ferrariInitInv = new ArrayList<>();
                ferrariInitInv.add(new Ferrari("Black", true, 0, new File("/resources/images/BlkFerrariConvertible.jpg")));
                ferrariInitInv.add(new Ferrari("Blue", true, 0, new File("/resources/images/BluFerrariConvertible.jpg")));
                ferrariInitInv.add(new Ferrari("Red", false, 0, new File("/resources/images/RedFerrari.jpg")));
                ferrariInitInv.add(new Ferrari("White", false, 0, new File("/resources/images/WhiteFerrari.jpg")));
                ferrariInitInv.add(new Ferrari("White", true, 0, new File("/resources/images/WhiteFerrConvertible.jpg")));
                ferrariInitInv.add(new Ferrari("Yellow", false, 0, new File("/resources/images/YellowFerrari.jpg")));
                writeInventory(ferrariInitInv, FERRARI_INVENTORY_FILE_LOCATION);
            }
            if (!LAMBO_INVENTORY_FILE_LOCATION.exists()) {
                ArrayList<Car> lamboInitInv = new ArrayList<>();
                lamboInitInv.add(new Lamborghini("Black", false, 0, new File("/resources/images/BlkLambo.jpg")));
                lamboInitInv.add(new Lamborghini("Black", true, 0, new File("/resources/images/BlkLamboConvertible.jpg")));
                lamboInitInv.add(new Lamborghini("Blue", true, 0, new File("/resources/images/BluLamboConvertible.jpg")));
                lamboInitInv.add(new Lamborghini("Green", false, 0, new File("/resources/images/GreenLambo.jpg")));
                lamboInitInv.add(new Lamborghini("White", false, 0, new File("/resources/images/WhiteLambo.jpg")));
                lamboInitInv.add(new Lamborghini("Yellow", false, 0, new File("/resources/images/YellowLambo.jpg")));
                writeInventory(lamboInitInv, LAMBO_INVENTORY_FILE_LOCATION);
            }
            if (!MCLAREN_INVENTORY_FILE_LOCATION.exists()) {
                ArrayList<Car> mclarenInitInv = new ArrayList<>();
                mclarenInitInv.add(new McLaren("Black", false, 0, new File("/resources/images/BlkMcLaren.jpg")));
                mclarenInitInv.add(new McLaren("Blue", false, 0, new File("/resources/images/BluMcLaren.jpg")));
                mclarenInitInv.add(new McLaren("Green", false, 0, new File("/resources/images/GreenMcLaren.jpg")));
                mclarenInitInv.add(new McLaren("Orange", true, 0, new File("/resources/images/OranMcLarConvertible.jpg")));
                mclarenInitInv.add(new McLaren("Red", false, 0, new File("/resources/images/RedMcLaren.jpg")));
                mclarenInitInv.add(new McLaren("Yellow", false, 0, new File("/resources/images/YellowMcLaren.jpg")));
                writeInventory(mclarenInitInv, MCLAREN_INVENTORY_FILE_LOCATION);
            }
            if (!MASERATI_INVENTORY_FILE_LOCATION.exists()) {
                ArrayList<Car> maseratiInitInv = new ArrayList<>();
                maseratiInitInv.add(new Maserati("Black", false, 0, new File("/resources/images/BlkMaserati.jpg")));
                maseratiInitInv.add(new Maserati("Blue", false, 0, new File("/resources/images/BluMaserati.jpg")));
                maseratiInitInv.add(new Maserati("Red", false, 0, new File("/resources/images/RedMaserati.jpg")));
                maseratiInitInv.add(new Maserati("White", true, 0, new File("/resources/images/WhiteMaserConvertible.jpg")));
                writeInventory(maseratiInitInv, MASERATI_INVENTORY_FILE_LOCATION);
            }
        }
    }

    private void writeInventory(ArrayList<Car> list, File file) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeInt(list.size());
            for (Car car : list) {
                oos.writeObject(car);
            }
            oos.close();
        } catch (IOException ignored) {
        }
    }

    private void readInventory() {
        int inventoryItems;
        ObjectInputStream ois;
        try {
            ois = new ObjectInputStream(new FileInputStream(ASTON_INVENTORY_FILE_LOCATION));
            inventoryItems = ois.readInt();
            for (int i = 0; i < inventoryItems; i++) {
                Aston car = (Aston) ois.readObject();
                inventoryList.add(car);
            }
            ois.close();

            ois = new ObjectInputStream(new FileInputStream(FERRARI_INVENTORY_FILE_LOCATION));
            inventoryItems = ois.readInt();
            for (int i = 0; i < inventoryItems; i++) {
                Ferrari car = (Ferrari) ois.readObject();
                inventoryList.add(car);
            }
            ois.close();

            ois = new ObjectInputStream(new FileInputStream(LAMBO_INVENTORY_FILE_LOCATION));
            inventoryItems = ois.readInt();
            for (int i = 0; i < inventoryItems; i++) {
                Lamborghini car = (Lamborghini) ois.readObject();
                inventoryList.add(car);
            }
            ois.close();

            ois = new ObjectInputStream(new FileInputStream(MCLAREN_INVENTORY_FILE_LOCATION));
            inventoryItems = ois.readInt();
            for (int i = 0; i < inventoryItems; i++) {
                McLaren car = (McLaren) ois.readObject();
                inventoryList.add(car);
            }
            ois.close();

            ois = new ObjectInputStream(new FileInputStream(MASERATI_INVENTORY_FILE_LOCATION));
            inventoryItems = ois.readInt();
            for (int i = 0; i < inventoryItems; i++) {
                Maserati car = (Maserati) ois.readObject();
                inventoryList.add(car);
            }
            ois.close();


        } catch (IOException | ClassNotFoundException ignored) {
        }
    }
}
