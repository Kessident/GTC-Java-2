package com.FastHappy;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FastHappy extends Application {
    private final int ITEM_ORDER_LIMIT = 50;
    private ArrayList<Item> itemList = new ArrayList<>();
    private ArrayList<Spinner> spinnerList = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) throws Exception {
        createDatFile();
        VBox root = new VBox();
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(root);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

        readDatMenu();
        VBox outerMenu = createMenuItems();

        VBox customerInfoBox = createCustomerBox(root, primaryStage);

        HBox orderForm = new HBox(outerMenu, customerInfoBox);

        Button addMenuButton = new Button("Add Menu Item");
        addMenuButton.setOnAction((ActionEvent event) -> addMenuitem(primaryStage));
        VBox addMenuWrapper = new VBox();
        addMenuWrapper.getChildren().add(addMenuButton);
        addMenuWrapper.setAlignment(Pos.CENTER_RIGHT);
        root.getChildren().add(addMenuWrapper);
        root.getChildren().add(orderForm);

        Scene scene = new Scene(scrollPane);
        scene.getStylesheets().add(getClass().getResource("FastHappy.css").toExternalForm());
        primaryStage.setTitle("Fast Happy");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    //shmoogy
    private VBox createMenuItems() {
        VBox outerMenu = new VBox();
        outerMenu.setPrefWidth(1250);
        FlowPane entreeFlow = new FlowPane();
        Label entreeMenuLabel = new Label("Entrees");
        entreeMenuLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        FlowPane sideFlow = new FlowPane();
        Label sideMenuLabel = new Label("Sides");
        sideMenuLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        FlowPane dessertFlow = new FlowPane();
        Label dessertMenuLabel = new Label("Dessert");
        dessertMenuLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        FlowPane drinkFlow = new FlowPane();
        Label drinkMenuLabel = new Label("Drinks");
        drinkMenuLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 20));

        outerMenu.getChildren().addAll(entreeMenuLabel, entreeFlow, sideMenuLabel, sideFlow, dessertMenuLabel, dessertFlow, drinkMenuLabel, drinkFlow);
        ArrayList<FlowPane> flowPaneLists = new ArrayList<>(Arrays.asList(entreeFlow, sideFlow, dessertFlow, drinkFlow));
        for (int i = 0; i < itemList.size(); i++) {
            Item currItem = itemList.get(i);
            switch (currItem.getSection()) {
                case Entree:
                    createMenuItem(flowPaneLists.get(0), currItem, spinnerList.get(i));
                    break;
                case Side:
                    createMenuItem(flowPaneLists.get(1), currItem, spinnerList.get(i));
                    break;
                case Dessert:
                    createMenuItem(flowPaneLists.get(2), currItem, spinnerList.get(i));
                    break;
                case Drink:
                    createMenuItem(flowPaneLists.get(3), currItem, spinnerList.get(i));
                    break;
            }
        }

        return outerMenu;
    }

    //shmoogy
    private void createMenuItem(FlowPane menuFlow, Item item, Spinner spinner) {
        ImageView menuImageView = new ImageView(new Image(item.getImageFileURL()));
        menuImageView.setFitHeight(100);
        menuImageView.setFitWidth(100);
        Label nameLabel = new Label(item.getName() + " - $" + item.getPrice());
        nameLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        Label itemDesc = new Label(item.getDescription());

        VBox itemBox = new VBox(menuImageView, nameLabel, itemDesc, spinner);
        itemBox.setAlignment(Pos.CENTER);
        itemBox.getStyleClass().add("menuItem");

        menuFlow.getChildren().add(itemBox);
    }

    //Bersolgens
    private VBox createCustomerBox(Pane root, Stage primaryStage) {
        Label fName = new Label("First Name:");
        Label lName = new Label("Last Name: ");
        Label address = new Label("Address: ");
        Label city = new Label("City: ");
        Label state = new Label("State: ");
        Label zip = new Label("Zip: ");
        Label phone = new Label("Phone: ");
        Label email = new Label("Email: ");

        TextField tfName = new TextField();
        TextField tlName = new TextField();
        TextField tAddress = new TextField();
        TextField tCity = new TextField();
        String[] states = {"AK", "AL", "AR", "AS", "AZ", "CA", "CO", "CT", "DC", "DE", "FL", "GA", "GU", "HI", "IA", "ID", "IL", "IN", "KS", "KY", "LA", "MA", "MD", "ME", "MI", "MN", "MO", "MP",
            "MS", "MT", "NC", "ND", "NE", "NH", "NJ", "NM", "NV", "NY", "OH", "OK", "OR", "PA", "PR", "RI", "SC", "SD", "TN", "TX", "UM", "UT", "VA", "VI", "VT", "WA", "WI", "WV", "WY"};
        ComboBox tState = new ComboBox<>(FXCollections.observableArrayList(states));

        TextField tZip = new TextField();
        TextField tPhone = new TextField();
        TextField tEmail = new TextField();

        Button submitButton = new Button("Submit");

        //Questions and text oxes
        restrictInputToIntegers(tPhone);
        submitButton.setPrefSize(100, 50);
        submitButton.setId("OrderSubmitButton");


        HBox hbox1 = new HBox(40, fName, tfName);
        HBox hbox12 = new HBox(40, lName, tlName);
        HBox hbox2 = new HBox(40, address, tAddress);
        HBox hbox3 = new HBox(40, city, tCity);
        HBox hbox4 = new HBox(40, state, tState);
        HBox hbox5 = new HBox(40, zip, tZip);
        HBox hbox6 = new HBox(40, phone, tPhone);
        HBox hbox7 = new HBox(40, email, tEmail);

        //Validate my text fields on Submit Button Pressed
        submitButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                showFinalScreen(root, primaryStage);

                boolean valid = true;
                Pattern emailPattern = Pattern.compile("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{3}$");
                Matcher emailMatcher = emailPattern.matcher(tEmail.getText());

                if (tfName.getText().isEmpty()) {
                    tfName.setPromptText("Name must not be empty");
                    tfName.setStyle("-fx-prompt-text-fill: #ff0000;"); //Set red text color
                    valid = false;
                }
                if (tlName.getText().isEmpty()) {
                    tlName.setPromptText("Name must not be empty");
                    tlName.setStyle("-fx-prompt-text-fill: #ff0000;"); //Set red text color
                    valid = false;
                }
                if (tAddress.getText().isEmpty()) {
                    tAddress.setPromptText("Address must not be empty");
                    tAddress.setStyle("-fx-prompt-text-fill: #ff0000;"); //Set red text color
                    valid = false;
                }
                if (tCity.getText().isEmpty()) {
                    tCity.setPromptText("City must not be empty");
                    tCity.setStyle("-fx-prompt-text-fill: #ff0000;"); //Set red text color
                    valid = false;
                }

                if (tZip.getText().length() < 5 || tZip.getText().length() > 10) {
                    tZip.clear();
                    tZip.setPromptText("Must be between 5 and 10");
                    tZip.setStyle("-fx-prompt-text-fill: #ff0000;"); //Set red text color
                    valid = false;
                }

                if (tPhone.getText().length() != 10) {
                    tPhone.clear();
                    tPhone.setPromptText("Has to be 10 Digits");
                    tPhone.setStyle("-fx-prompt-text-fill: #ff0000;"); //Set red text color
                    valid = false;
                }

                if (!emailMatcher.matches()) {
                    tEmail.clear();
                    tEmail.setPromptText("name@domain.com");
                    tEmail.setStyle("-fx-prompt-text-fill: #ff0000;"); //Set red text color
                    valid = false;
                }

                if (valid) {
                    showFinalScreen(root, primaryStage);
                    //Can only place one order
                    //Remove eventHandler after placing order
                    ((Button) event.getSource()).setOnAction(null);
                }
            }
        });

        return new VBox(hbox1, hbox12, hbox2, hbox3, hbox4, hbox5, hbox6, hbox7, submitButton);
    }

    //Calculate Order total - Cindy
    private void showFinalScreen(Pane root, Stage primaryStage) {
        HBox externalLayout = new HBox();
        double total = 0;
        VBox checkoutBox = new VBox();

        GridPane lineItems = new GridPane();
        lineItems.setPadding(new Insets(10, 10, 0, 50));

        //Headers
        Text itemText = new Text("Item");
        itemText.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
        Text costText = new Text("Cost");
        costText.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
        Text quantityText = new Text("Quantity");
        quantityText.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
        Text totalText = new Text("Total");
        totalText.setFont(Font.font("Verdana", FontWeight.BOLD, 14));

        lineItems.add(itemText, 1, 0);
        lineItems.add(costText, 2, 0);
        lineItems.add(quantityText, 3, 0);
        lineItems.add(totalText, 4, 0);

        //Items ordered
        for (int i = 0; i < itemList.size(); i++) {
            Item item = itemList.get(i);
            Integer quantity = (Integer) spinnerList.get(i).getValue();
            if (quantity > 0) {
                Label itemName = new Label(item.getName());
                itemName.setPrefWidth(150);
                Label itemPrice = new Label("$ " + item.getPrice());
                itemPrice.setPrefWidth(80);
                Label itemQuantity = new Label("" + quantity);
                itemQuantity.setPrefWidth(80);
                Label itemTotal = new Label("$ " + quantity * item.getPrice());
                itemTotal.setPrefWidth(80);

                lineItems.add(itemName, 1, i + 1);
                lineItems.add(itemPrice, 2, i + 1);
                lineItems.add(itemQuantity, 3, i + 1);
                lineItems.add(itemTotal, 4, i + 1);
                total += item.getPrice() * quantity;
            }
        }
        checkoutBox.getChildren().add(lineItems);

        //Order Total
        VBox orderTotalBox = new VBox();
        orderTotalBox.setPadding(new Insets(10, 10, 10, 50));
        orderTotalBox.setStyle("-fx-border-width: 1px");
        orderTotalBox.setStyle("-fx-border-color: black");
        orderTotalBox.setAlignment(Pos.CENTER_RIGHT);

        Label subtotalTitle = new Label("Subtotal");
        subtotalTitle.setPrefWidth(250);
        subtotalTitle.setFont(Font.font("Verdana", FontWeight.BOLD, 16));
        Label subTotalAmount = new Label(String.format("$ %.2f", total));
        subTotalAmount.setPrefWidth(250);
        subTotalAmount.setFont(Font.font("Verdana", FontWeight.BOLD, 16));
        HBox subtotalBox = new HBox(subtotalTitle, subTotalAmount);
        subtotalBox.setPadding(new Insets(0, 10, 0, 50));
        orderTotalBox.getChildren().add(subtotalBox);

        Label salesTax = new Label("Sales Tax - 6%");
        salesTax.setPrefWidth(250);
        salesTax.setFont(Font.font("Verdana", FontWeight.BOLD, 16));
        Label salesTaxTotal = new Label(String.format("$ %.2f", 0.06 * total));
        salesTaxTotal.setPrefWidth(250);
        salesTaxTotal.setFont(Font.font("Verdana", FontWeight.BOLD, 16));
        HBox salesTaxBox = new HBox(salesTax, salesTaxTotal);
        salesTaxBox.setPadding(new Insets(0, 10, 0, 50));
        orderTotalBox.getChildren().add(salesTaxBox);

        Label deliveryFee = new Label("Delivery Fee - 2%");
        deliveryFee.setPrefWidth(250);
        deliveryFee.setFont(Font.font("Verdana", FontWeight.BOLD, 16));
        Label deliveryFeeTotal = new Label(String.format("$ %.2f", 0.02 * total));
        deliveryFeeTotal.setPrefWidth(250);
        deliveryFeeTotal.setFont(Font.font("Verdana", FontWeight.BOLD, 16));
        HBox deliveryFeeBox = new HBox(deliveryFee, deliveryFeeTotal);
        deliveryFeeBox.setPadding(new Insets(0, 10, 0, 50));
        orderTotalBox.getChildren().add(deliveryFeeBox);

        Label totalLabel = new Label("Total");
        totalLabel.setPrefWidth(250);
        totalLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 16));
        Label totalAmount = new Label("$ " + String.format("%.2f", (0.06 * total) + (0.02 * total) + total));
        totalAmount.setPrefWidth(250);
        totalAmount.setFont(Font.font("Verdana", FontWeight.BOLD, 16));
        HBox totalBox = new HBox(totalLabel, totalAmount);
        totalBox.setPadding(new Insets(0, 10, 0, 50));
        orderTotalBox.getChildren().add(totalBox);


        checkoutBox.getChildren().add(orderTotalBox);
        root.getChildren().add(checkoutBox);
        primaryStage.sizeToScene();
    }

    private void addMenuitem(Stage primaryStage) {
        Scene scene = primaryStage.getScene();
        Parent menuRoot = scene.getRoot();

        VBox newBox = new VBox();
        newBox.setAlignment(Pos.CENTER);
        Label passLabel = new Label("Password");
        PasswordField passInput = new PasswordField();
        Button submitButton = new Button("Submit");
        HBox passBox = new HBox(passLabel, passInput, submitButton);
        passBox.setAlignment(Pos.CENTER);

        VBox newMenuItemBox = createNewMenuItemBox(primaryStage);
        newMenuItemBox.setAlignment(Pos.CENTER);
        newMenuItemBox.setVisible(false);

        submitButton.setOnAction((ActionEvent event) -> {
            if (passInput.getText().equals("1111")) {
                passBox.setVisible(false);
                newMenuItemBox.setVisible(true);
            }
        });

        Button backButton = new Button("Back");
        backButton.setOnAction((ActionEvent event) -> scene.setRoot(menuRoot));
        passBox.getChildren().add(backButton);

        newBox.getChildren().add(passBox);
        newBox.getChildren().add(newMenuItemBox);

        scene.setRoot(newBox);
    }

    private VBox createNewMenuItemBox(Stage primaryStage) {
        VBox toReturn = new VBox();
        //Name
        Label nameLabel = new Label("New item name: ");
        nameLabel.setFont(Font.font("Verdana", 16));
        TextField nameInput = new TextField();
        HBox namebox = new HBox(nameLabel, nameInput);
        namebox.setAlignment(Pos.CENTER);
        //Description
        Label descLabel = new Label("New item Description: ");
        descLabel.setFont(Font.font("Verdana", 16));
        TextField descInput = new TextField();
        HBox descbox = new HBox(descLabel, descInput);
        descbox.setAlignment(Pos.CENTER);
        //Picture
        Label picLabel = new Label("New item Picture: ");
        picLabel.setFont(Font.font("Verdana", 16));
        FileChooser pictureChooser = new FileChooser();
        Button picInput = new Button("Picture");
        Text pictureSelectedAbs = new Text();
        Text pictureSelectedFileName = new Text();
        pictureSelectedAbs.setVisible(false);
        picInput.setOnAction((ActionEvent event) -> {
            File pictureFile = pictureChooser.showOpenDialog(primaryStage);
            if (pictureFile != null) {
                pictureSelectedAbs.setText(pictureFile.getAbsolutePath());
                pictureSelectedFileName.setText(pictureFile.getName());
            }
        });
        HBox picBox = new HBox(picLabel, picInput);
        picBox.setAlignment(Pos.CENTER);
        //Section
        Label sectLabel = new Label("New item section: ");
        sectLabel.setFont(Font.font("Verdana", 16));
        List<Item.Section> sectionList = Arrays.asList(Item.Section.values());
        ComboBox<Item.Section> sectInput = new ComboBox<>(FXCollections.observableList(sectionList));
        HBox sectBox = new HBox(sectLabel, sectInput);
        sectBox.setAlignment(Pos.CENTER);
        //Price
        Label priceLabel = new Label("New item price: $");
        priceLabel.setFont(Font.font("Verdana", 16));
        TextField priceInput = new TextField();
        HBox priceBox = new HBox(priceLabel, priceInput);
        priceBox.setAlignment(Pos.CENTER);

        Button submitButton = new Button("Submit");

        submitButton.setOnAction((ActionEvent event) -> {
            boolean validItem = true;

            if (nameInput.getText().isEmpty()) {
                nameInput.setStyle("-fx-background-color: #FF474C");
                validItem = false;
            } else {
                nameInput.setStyle("-fx-background-color: white");
            }
            if (descInput.getText().isEmpty()) {
                descInput.setStyle("-fx-background-color: #FF474C");
                validItem = false;
            } else {
                descInput.setStyle("-fx-background-color: white");
            }
            if (priceInput.getText().isEmpty()) {
                priceInput.setStyle("-fx-background-color: #FF474C");
                validItem = false;
            } else {
                priceInput.setStyle("-fx-background-color: white");
            }
            if (sectInput.getValue() == null) {
                sectInput.setStyle("-fx-background-color: #FF474C");
                validItem = false;
            } else {
                sectInput.setStyle("-fx-background-color: white");
            }
            if (pictureSelectedAbs.getText().isEmpty()) {
                picInput.setStyle("-fx-background-color: #FF474C");
                validItem = false;
            } else {
                picInput.setStyle("-fx-background-color: white");
            }


            if (validItem) {
                String itemName = nameInput.getText();
                String itemDescription = descInput.getText();
                double itemPrice = Double.parseDouble(priceInput.getText());
                String itemFileLoc = "/resources/fasthappyimages/" + pictureSelectedFileName.getText();
                Item.Section itemSection = sectInput.getValue();

                //Copy picture Over
                try {
                    Files.copy(new File(pictureSelectedAbs.getText()).toPath(), new File(System.getProperty("user.dir") + "/src" + itemFileLoc).toPath());
                } catch (IOException ex) {
                    Text ioException = new Text("IOException, please reload application\nSee console for details\n" + ex.getMessage());
                    ex.printStackTrace();
                    toReturn.getChildren().add(ioException);
                    return;
                }

                Item newMenuItem = new Item(itemName, itemDescription, itemPrice, itemFileLoc, itemSection);
                itemList.add(newMenuItem);

                //Write all Items to menu.dat
                try {
                    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/resources/menu.dat"));
                    oos.writeInt(itemList.size());
                    for (Item item : itemList) {
                        oos.writeObject(item);
                    }
                    oos.close();
                } catch (IOException ex) {
                    Text ioException = new Text("IOException, please reload application\nSee console for details");
                    ex.printStackTrace();
                    toReturn.getChildren().add(ioException);
                    return;
                }

                Text success = new Text("Item added successfully");
                success.setFont(Font.font("Verdana", 26));
                toReturn.getChildren().add(success);
                //prevent accidental additional presses
                submitButton.setOnAction(null);
            }
        });
        toReturn.getChildren().addAll(namebox, descbox, picBox, sectBox, priceBox, submitButton);
        return toReturn;
    }


    private void createDatFile() throws Exception {
        File datFile = new File("src/resources/menu.dat");
        //Initial Menu Offerings
        if (!datFile.exists()) {
            Item entree1 = new Item("Moo Burger", "Made from real cows!", 7.99, "/resources/fasthappyimages/mooburger.jpg", Item.Section.Entree);
            Item entree2 = new Item("Let's Play Chicken Sandwich", "Be sure to live stream your lunch!", 6.99, "/resources/fasthappyimages/letsplaychicken.jpg", Item.Section.Entree);
            Item entree3 = new Item("Struck Gold Chicken Nuggets", "1 in 10000 contains a real gold nugget!", 4.99, "/resources/fasthappyimages/struckgoldnuggest.jpg", Item.Section.Entree);
            Item entree4 = new Item("It was you Alfredo", "Alfredo so good it'll break your heart!", 8.99, "/resources/fasthappyimages/itwasyoualfredo.jpg", Item.Section.Entree);
            Item entree5 = new Item("J. Paul Spaghetti", "Perfect for the grand kids!", 17, "/resources/fasthappyimages/jpaulspaghetti.jpg", Item.Section.Entree);
            Item side1 = new Item("Six, Fries, and Videotape", "Perfect for getting over a breakup!", 1.99, "/resources/fasthappyimages/sixfriesvideotape.jpg", Item.Section.Side);
            Item side2 = new Item("Make a Wedge", "Guaranteed to not get between you and your significant other!", 1.99, "/resources/fasthappyimages/makeawedge.jpg", Item.Section.Side);
            Item dessert1 = new Item("Go to Townie Brownie", "A dessert oh so sweet!", 5.99, "/resources/fasthappyimages/gototowniebrownie.jpg", Item.Section.Dessert);
            Item dessert2 = new Item("Shake Shake Shake", "Shake, shake, shake it off!", 4.99, "/resources/fasthappyimages/shakes.jpg", Item.Section.Dessert);
            Item drink1 = new Item("Coke, Sprite", "Original recipe!", 2.49, "/resources/fasthappyimages/coke.jpg", Item.Section.Drink);
            Item drink2 = new Item("Iced Tea", "A favourite of Tracy Marrow!", 2.99, "/resources/fasthappyimages/icetea.jpg", Item.Section.Drink);


            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(datFile));
            oos.writeInt(11);
            oos.writeObject(entree1);
            oos.writeObject(entree2);
            oos.writeObject(entree3);
            oos.writeObject(entree4);
            oos.writeObject(entree5);
            oos.writeObject(side1);
            oos.writeObject(side2);
            oos.writeObject(dessert1);
            oos.writeObject(dessert2);
            oos.writeObject(drink1);
            oos.writeObject(drink2);
            oos.close();
        }
    }

    private void readDatMenu() {

        int menuItemsToRead;
        FileInputStream fis;
        ObjectInputStream ois;
        try {
            fis = new FileInputStream("src/resources/menu.dat");
            ois = new ObjectInputStream(fis);
            menuItemsToRead = ois.readInt();

            for (int i = 0; i < menuItemsToRead; i++) {
                Item newItem = (Item) ois.readObject();
                itemList.add(newItem);
                spinnerList.add(new Spinner(0, ITEM_ORDER_LIMIT, 0));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.exit(-1);
        }
    }


    private void restrictInputToIntegers(TextField textField) {
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d")) {
                textField.setText(newValue.replaceAll("[^\\d.]", ""));
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}