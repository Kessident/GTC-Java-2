package com.Windspinks.ExoticMoves;

import com.Windspinks.ExoticMoves.Model.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Main extends Application {
    private static Stage pStage;
    private final File INVENTORY_DIRECTORY = new File("src/resources/inventory");
    private final File ASTON_INVENTORY_FILE_LOCATION = new File("src/resources/inventory/aston.dat");
    private final File FERRARI_INVENTORY_FILE_LOCATION = new File("src/resources/inventory/ferrari.dat");
    private final File LAMBO_INVENTORY_FILE_LOCATION = new File("src/resources/inventory/lamborghini.dat");
    private final File MCLAREN_INVENTORY_FILE_LOCATION = new File("src/resources/inventory/mclaren.dat");
    private final File MASERATI_INVENTORY_FILE_LOCATION = new File("src/resources/inventory/maserati.dat");
    private Set<Car> inventoryList = new HashSet<>();
    private Set<Car> inventoryFiltered = new HashSet<>();
    private ArrayList<CheckBox> filtersList = new ArrayList<>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        pStage = primaryStage;
        createInitialInventory();
        readInventory();
        VBox outerBox = new VBox();
        Scene scene = new Scene(outerBox);
        Label exoticMovesTitle = new Label("Exotic Moves");
        exoticMovesTitle.setId("ExoticMovesTitle");
        outerBox.setAlignment(Pos.TOP_CENTER);
        outerBox.getChildren().add(exoticMovesTitle);
        outerBox.getChildren().add(createFilterBox());

        FlowPane inventoryFlowPane = new FlowPane();
        inventoryFlowPane.setId("InventoryPane");
        populatePaneWithCarCards(inventoryFlowPane, inventoryList);

        ScrollPane inventoryScrollPane = new ScrollPane();
        inventoryScrollPane.setContent(inventoryFlowPane);
        inventoryScrollPane.setFitToWidth(true);

        outerBox.getChildren().add(inventoryScrollPane);

        scene.getStylesheets().add(getClass().getResource("ExoticMoves.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exotic Moves");
        primaryStage.show();
    }

    private void populatePaneWithCarCards(FlowPane pane, Set<Car> inventorySet) {
        pane.getChildren().clear();

        for (Car car : inventorySet) {
            ImageView carImage = new ImageView(new Image(car.getImageFile().getAbsolutePath()));
            carImage.setFitHeight(150);
            carImage.setFitWidth(200);
            carImage.setOnMouseClicked((MouseEvent event) -> {
                Scene scene = getPStage().getScene();
                Parent inventoryView = scene.getRoot();

                Text brandText = new Text("Brand: " + car.getBrand().name());
                ImageView carImageLarge = new ImageView(new Image(car.getImageFile().getAbsolutePath()));
                Text priceText = new Text("$" + car.getPrice() + "K");
                Text colorText = new Text("Color: " + car.getColor().name());
                Text convText = new Text("Convertible: " + (car.isConvertible() ? "Yes" : "No"));
                Text cylinderText = new Text("# of Cylinders: " + car.getNumCylinders());
                Text sixtySpeedText = new Text("0-60: " + car.getZeroToSixty() + " seconds");
                Button purchaseButton = new Button("Purchase");

                Button backButton = new Button("Back");
                backButton.setOnAction((ActionEvent aeEvent) -> scene.setRoot(inventoryView));


                VBox detailView = new VBox(brandText, carImageLarge, priceText, colorText, convText, cylinderText, sixtySpeedText, purchaseButton, backButton);
                detailView.setAlignment(Pos.CENTER);

                purchaseButton.setOnAction((ActionEvent aeEvent) -> purchaseMenu(car));

                scene.setRoot(detailView);
            });
            Label carLabel = new Label(car.getBrand().name() + " - $" + car.getPrice() + "K");

            VBox carBox = new VBox(carImage, carLabel);
            carBox.setAlignment(Pos.CENTER);
            pane.getChildren().add(carBox);
        }
    }

    private void purchaseMenu(Car carToBePurchased) {
        Scene scene = getPStage().getScene();
        Parent detailView = scene.getRoot();

        Button backButton = new Button("Back");
        backButton.setOnAction((ActionEvent aeEvent) -> scene.setRoot(detailView));

        Label firstNameLabel = new Label("First name: ");
        TextField firstNameInput = new TextField();
        HBox firstNameBox = new HBox(firstNameLabel, firstNameInput);
        firstNameBox.setAlignment(Pos.CENTER_LEFT);

        Label lastNameLabel = new Label("Last name: ");
        TextField lastNameInput = new TextField();
        HBox lastNameBox = new HBox(lastNameLabel, lastNameInput);
        lastNameBox.setAlignment(Pos.CENTER_LEFT);

        Label phoneLabel = new Label("Phone Number: ");
        TextField phoneInput = new TextField();
        HBox phoneBox = new HBox(phoneLabel, phoneInput);
        phoneBox.setAlignment(Pos.CENTER_LEFT);

        Label creditLabel = new Label("Credit card number: ");
        TextField creditInput = new TextField();
        HBox creditBox = new HBox(creditLabel, creditInput);
        creditBox.setAlignment(Pos.CENTER_LEFT);

        Label creditExpDateLabel = new Label("Exp Date: ");
        DatePicker creditExpDateInput = new DatePicker();
        HBox creditExpDateBox = new HBox(creditExpDateLabel, creditExpDateInput);
        creditExpDateBox.setAlignment(Pos.CENTER_LEFT);

        Label cvvLabel = new Label("CVV: ");
        TextField cvvInput = new TextField();
        HBox cvvBox = new HBox(cvvLabel, cvvInput);
        cvvBox.setAlignment(Pos.CENTER_LEFT);


        Button submitButton = new Button("Submit");
        submitButton.setOnAction((ActionEvent event) -> {
            boolean isValid = true;

            //First Name - Not Empty, a-Z
            String firstName = firstNameInput.getText();
            if (firstName.isEmpty() || !firstName.chars().allMatch(Character::isLetter)) {
                isValid = false;
            }

            //Last Name - Not Empty, a-Z
            String lastName = lastNameInput.getText();
            if (lastName.isEmpty() || !lastName.chars().allMatch(Character::isLetter)) {
                isValid = false;
            }

            //Credit Number - Not Empty, All Digits, Length 16
            String creditNumber = creditInput.getText();
            if (creditNumber.isEmpty() || !creditNumber.chars().allMatch(Character::isDigit) || creditNumber.length() != 16) {
                isValid = false;
            }

            //DATE - Exists, Date has not passed
            LocalDate expDate = creditExpDateInput.getValue();
            if (expDate == null || expDate.isBefore(LocalDate.now())) {
                isValid = false;
            }

            //CVV - Not Empty, All Digits, Length 3
            String cvv = cvvInput.getText();
            if (cvv.isEmpty() || !cvv.chars().allMatch(Character::isDigit) || cvv.length() != 3) {
                isValid = false;
            }

            if (isValid) {
                String confirmationString = "Thank you " + firstName + " " + lastName + " for your purchase of a " +
                    carToBePurchased.getColor().name() + " " + carToBePurchased.getBrand().name() + ".\n" +
                    "You will be contacted shortly to arrange pickup or delivery.\n" +
                    "Thank you for choosing Exotic Moves!";
                Text confirmation = new Text(confirmationString);

                VBox congratsBox = new VBox(confirmation);
                congratsBox.setAlignment(Pos.CENTER);
                scene.setRoot(congratsBox);
            }
        });

        VBox paymentInfo = new VBox(firstNameBox, lastNameBox, phoneBox, creditBox, creditExpDateBox, cvvBox, submitButton);

        VBox outerBox = new VBox(backButton, paymentInfo);
        scene.setRoot(outerBox);
    }

    private HBox createFilterBox() {
        Text brandFilterTitle = new Text("Filter by brand");
        CheckBox brandAstonCheck = new CheckBox("Aston Martin");
        brandAstonCheck.setId("brandAstonCheckBox");
        CheckBox brandFerrariCheck = new CheckBox("Ferrari");
        brandFerrariCheck.setId("brandFerrariCheckBox");
        CheckBox brandLamboCheck = new CheckBox("Lamborghini");
        brandLamboCheck.setId("brandLamborghiniCheckBox");
        CheckBox brandMclarenCheck = new CheckBox("McLaren");
        brandMclarenCheck.setId("brandMcLarenCheckBox");
        CheckBox brandMaseratiCheck = new CheckBox("Maserati");
        brandMaseratiCheck.setId("brandMaseratiCheckBox");
        VBox brandFilterBox = new VBox(brandFilterTitle, brandAstonCheck, brandFerrariCheck, brandLamboCheck, brandMclarenCheck, brandMaseratiCheck);

        Text colorFilterTitle = new Text("Filter by Color");
        CheckBox colorBlackCheck = new CheckBox("Black");
        colorBlackCheck.setId("colorBlackCheckBox");
        CheckBox colorBlueCheck = new CheckBox("Blue");
        colorBlueCheck.setId("colorBlueCheckBox");
        CheckBox colorGreenCheck = new CheckBox("Green");
        colorGreenCheck.setId("colorGreenCheckBox");
        CheckBox colorOrangeCheck = new CheckBox("Orange");
        colorOrangeCheck.setId("colorOrangeCheckBox");
        CheckBox colorRedCheck = new CheckBox("Red");
        colorRedCheck.setId("colorRedCheckBox");
        CheckBox colorWhiteCheck = new CheckBox("White");
        colorWhiteCheck.setId("colorWhiteCheckBox");
        CheckBox colorYellowCheck = new CheckBox("Yellow");
        colorYellowCheck.setId("colorYellowCheckBox");
        VBox colorFilterBox = new VBox(colorFilterTitle, colorBlackCheck, colorBlueCheck, colorGreenCheck, colorOrangeCheck, colorRedCheck, colorWhiteCheck, colorYellowCheck);

        Text isConvTitle = new Text("Filter by Y/N Convertible");
        CheckBox isConvCheck = new CheckBox("Yes");
        isConvCheck.setId("isConvCheckbox");
        CheckBox isNotConvCheck = new CheckBox("No");
        isNotConvCheck.setId("isNotConvCheckbox");
        VBox isConvFilterBox = new VBox(isConvTitle, isConvCheck, isNotConvCheck);

        Text cylinderTitle = new Text("Filter by # Cylinders");
        CheckBox cylinderCheck6 = new CheckBox("6");
        cylinderCheck6.setId("cylinderCheckBox6");
        CheckBox cylinderCheck8 = new CheckBox("8");
        cylinderCheck8.setId("cylinderCheckBox8");
        CheckBox cylinderCheck12 = new CheckBox("12");
        cylinderCheck12.setId("cylinderCheckBox12");
        VBox cylinderFilterBox = new VBox(cylinderTitle, cylinderCheck6, cylinderCheck8, cylinderCheck12);

        Text priceFilterTitle = new Text("Filter by Price (in thousands)\n" +
            "Show all cars less than");
        Slider priceFilterSlider = new Slider(0, 500, 500);
        priceFilterSlider.setShowTickMarks(true);
        priceFilterSlider.setShowTickLabels(true);
        priceFilterSlider.setMajorTickUnit(100);
        priceFilterSlider.setBlockIncrement(100);
        priceFilterSlider.setMinorTickCount(1);
        priceFilterSlider.setSnapToTicks(true);
        priceFilterSlider.setMinWidth(300);
        VBox priceFilterBox = new VBox(priceFilterTitle, priceFilterSlider);

        Button filterButton = new Button("Filter");
        filterButton.setOnAction((ActionEvent event) -> {
            inventoryFiltered = new HashSet<>(inventoryList);
            Set<Car> tempList = new HashSet<>();

            //Brand Filter
            if (brandAstonCheck.isSelected()) {
                tempList.addAll(CarFilters.filterByBrand(Brand.AstonMartin, inventoryList));
            }
            if (brandFerrariCheck.isSelected()) {
                tempList.addAll(CarFilters.filterByBrand(Brand.Ferrari, inventoryList));
            }
            if (brandLamboCheck.isSelected()) {
                tempList.addAll(CarFilters.filterByBrand(Brand.Lamborghini, inventoryList));
            }
            if (brandMclarenCheck.isSelected()) {
                tempList.addAll(CarFilters.filterByBrand(Brand.McLaren, inventoryList));
            }
            if (brandMaseratiCheck.isSelected()) {
                tempList.addAll(CarFilters.filterByBrand(Brand.Maserati, inventoryList));
            }
            if (tempList.size() > 0) {
                inventoryFiltered.retainAll(tempList);
            }


            //Color Filters
            tempList.clear();
            if (colorBlackCheck.isSelected()) {
                tempList.addAll(CarFilters.filterByColor(Color.Black, inventoryList));
            }
            if (colorBlueCheck.isSelected()) {
                tempList.addAll(CarFilters.filterByColor(Color.Blue, inventoryList));
            }
            if (colorGreenCheck.isSelected()) {
                tempList.addAll(CarFilters.filterByColor(Color.Green, inventoryList));
            }
            if (colorOrangeCheck.isSelected()) {
                tempList.addAll(CarFilters.filterByColor(Color.Orange, inventoryList));
            }
            if (colorRedCheck.isSelected()) {
                tempList.addAll(CarFilters.filterByColor(Color.Red, inventoryList));
            }
            if (colorWhiteCheck.isSelected()) {
                tempList.addAll(CarFilters.filterByColor(Color.White, inventoryList));
            }
            if (colorYellowCheck.isSelected()) {
                tempList.addAll(CarFilters.filterByColor(Color.Yellow, inventoryList));
            }
            if (tempList.size() > 0) {
                inventoryFiltered.retainAll(tempList);
            }


            //Convertible Filters
            tempList.clear();
            if (isConvCheck.isSelected()) {
                tempList.addAll(CarFilters.filterByConv(true, inventoryList));
            }
            if (isNotConvCheck.isSelected()) {
                tempList.addAll(CarFilters.filterByConv(false, inventoryList));
            }
            if (tempList.size() > 0) {
                inventoryFiltered.retainAll(tempList);
            }


            //Cylinder Filters
            tempList.clear();
            if (cylinderCheck6.isSelected()) {
                tempList.addAll(CarFilters.filterByNumCylinders(6, inventoryList));
            }
            if (cylinderCheck8.isSelected()) {
                tempList.addAll(CarFilters.filterByNumCylinders(8, inventoryList));
            }
            if (cylinderCheck12.isSelected()) {
                tempList.addAll(CarFilters.filterByNumCylinders(12, inventoryList));
            }
            if (tempList.size() > 0) {
                inventoryFiltered.retainAll(tempList);
            }


            //Price Filter
            tempList.clear();
            double lowerThanPrice = priceFilterSlider.getValue();
            tempList.addAll(CarFilters.filterByPrice(lowerThanPrice, inventoryList));
            if (tempList.size() > 0) {
                inventoryFiltered.retainAll(tempList);
            }


            //Repopulate FlowPane with filtered Cars
            FlowPane flowPane = (FlowPane) getPStage().getScene().lookup("#InventoryPane");
            populatePaneWithCarCards(flowPane, inventoryFiltered);
        });

        Button clearFilterButton = new Button("Clear Filters");
        clearFilterButton.setOnAction((ActionEvent event) -> {
            brandAstonCheck.setSelected(false);
            brandFerrariCheck.setSelected(false);
            brandLamboCheck.setSelected(false);
            brandMclarenCheck.setSelected(false);
            brandMaseratiCheck.setSelected(false);
            colorBlackCheck.setSelected(false);
            colorBlueCheck.setSelected(false);
            colorGreenCheck.setSelected(false);
            colorOrangeCheck.setSelected(false);
            colorRedCheck.setSelected(false);
            colorWhiteCheck.setSelected(false);
            colorYellowCheck.setSelected(false);
            isConvCheck.setSelected(false);
            isNotConvCheck.setSelected(false);
            cylinderCheck6.setSelected(false);
            cylinderCheck8.setSelected(false);
            cylinderCheck12.setSelected(false);
            priceFilterSlider.setValue(priceFilterSlider.getMax());

            FlowPane flowPane = (FlowPane) getPStage().getScene().lookup("#InventoryPane");
            populatePaneWithCarCards(flowPane, inventoryList);
        });

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
                astonInitInv.add(new Aston("Black", true, 12, new File("/resources/images/BlkAstonConvertible.jpg")));
                astonInitInv.add(new Aston("Blue", false, 12, new File("/resources/images/BluAston.jpg")));
                astonInitInv.add(new Aston("Green", false, 12, new File("/resources/images/GreenAston.jpg")));
                astonInitInv.add(new Aston("Red", true, 12, new File("/resources/images/RedAstonConvertible.jpg")));
                writeInventory(astonInitInv, ASTON_INVENTORY_FILE_LOCATION);
            }
            if (!FERRARI_INVENTORY_FILE_LOCATION.exists()) {
                ArrayList<Car> ferrariInitInv = new ArrayList<>();
                ferrariInitInv.add(new Ferrari("Black", true, 8, new File("/resources/images/BlkFerrariConvertible.jpg")));
                ferrariInitInv.add(new Ferrari("Blue", true, 8, new File("/resources/images/BluFerrariConvertible.jpg")));
                ferrariInitInv.add(new Ferrari("Red", false, 8, new File("/resources/images/RedFerrari.jpg")));
                ferrariInitInv.add(new Ferrari("White", false, 8, new File("/resources/images/WhiteFerrari.jpg")));
                ferrariInitInv.add(new Ferrari("White", true, 8, new File("/resources/images/WhiteFerrConvertible.jpg")));
                ferrariInitInv.add(new Ferrari("Yellow", false, 8, new File("/resources/images/YellowFerrari.jpg")));
                writeInventory(ferrariInitInv, FERRARI_INVENTORY_FILE_LOCATION);
            }
            if (!LAMBO_INVENTORY_FILE_LOCATION.exists()) {
                ArrayList<Car> lamboInitInv = new ArrayList<>();
                lamboInitInv.add(new Lamborghini("Black", false, 12, new File("/resources/images/BlkLambo.jpg")));
                lamboInitInv.add(new Lamborghini("Black", true, 12, new File("/resources/images/BlkLamboConvertible.jpg")));
                lamboInitInv.add(new Lamborghini("Blue", true, 12, new File("/resources/images/BluLamboConvertible.jpg")));
                lamboInitInv.add(new Lamborghini("Green", false, 12, new File("/resources/images/GreenLambo.jpg")));
                lamboInitInv.add(new Lamborghini("White", false, 12, new File("/resources/images/WhiteLambo.jpg")));
                lamboInitInv.add(new Lamborghini("Yellow", false, 12, new File("/resources/images/YellowLambo.jpg")));
                writeInventory(lamboInitInv, LAMBO_INVENTORY_FILE_LOCATION);
            }
            if (!MCLAREN_INVENTORY_FILE_LOCATION.exists()) {
                ArrayList<Car> mclarenInitInv = new ArrayList<>();
                mclarenInitInv.add(new McLaren("Black", false, 8, new File("/resources/images/BlkMcLaren.jpg")));
                mclarenInitInv.add(new McLaren("Blue", false, 8, new File("/resources/images/BluMcLaren.jpg")));
                mclarenInitInv.add(new McLaren("Green", false, 8, new File("/resources/images/GreenMcLaren.jpg")));
                mclarenInitInv.add(new McLaren("Orange", true, 8, new File("/resources/images/OranMcLarConvertible.jpg")));
                mclarenInitInv.add(new McLaren("Red", false, 8, new File("/resources/images/RedMcLaren.jpg")));
                mclarenInitInv.add(new McLaren("Yellow", false, 8, new File("/resources/images/YellowMcLaren.jpg")));
                writeInventory(mclarenInitInv, MCLAREN_INVENTORY_FILE_LOCATION);
            }
            if (!MASERATI_INVENTORY_FILE_LOCATION.exists()) {
                ArrayList<Car> maseratiInitInv = new ArrayList<>();
                maseratiInitInv.add(new Maserati("Black", false, 6, new File("/resources/images/BlkMaserati.jpg")));
                maseratiInitInv.add(new Maserati("Blue", false, 6, new File("/resources/images/BluMaserati.jpg")));
                maseratiInitInv.add(new Maserati("Red", false, 6, new File("/resources/images/RedMaserati.jpg")));
                maseratiInitInv.add(new Maserati("White", true, 6, new File("/resources/images/WhiteMaserConvertible.jpg")));
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

    private static Stage getPStage() {
        return pStage;
    }

}
