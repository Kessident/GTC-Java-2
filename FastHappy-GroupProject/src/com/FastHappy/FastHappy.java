package com.FastHappy;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FastHappy extends Application {
    ArrayList<Item> itemList = new ArrayList<>();
    ArrayList<Spinner> spinnerList = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox root = new VBox();
        FlowPane menuFlow = new FlowPane();

        //Customer Order Information - Bersolgens
        readDatMenu();
        createMenuItems(menuFlow);

        //Submit Buttom - Cindy
        Button submitBtn = new Button("Submit");
        submitBtn.setOnAction((ActionEvent event) -> {
            //Get Totals,
        });

//        root.getChildren().add(customerPane);
        root.getChildren().add(menuFlow);
        root.getChildren().add(submitBtn);
        Scene scene = new Scene(root);
        primaryStage.setTitle("Fast Happy");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
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
                spinnerList.add(new Spinner(0, 50, 0));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.exit(-1);
        }
    }

    //shmoogy
    private void createMenuItems(Pane pane) {
        for (int i = 0; i < itemList.size(); i++) {
            Label label = new Label(itemList.get(i).getName());
            HBox newBox = new HBox(label, spinnerList.get(i));
            pane.getChildren().add(newBox);
        }
    }


    private void createDatFile() throws Exception {
        Item entree1 = new Item("Moo Burger", "Made from real cows!", 7.99, "/resources/fasthappyimages/mooburger.jpg", Item.Section.Entree);
        Item entree2 = new Item("Let's Play Chicken Sandwich", "Be sure to live stream your lunch!", 6.99, "/resources/fasthappyimages/letsplaychicken.jpg", Item.Section.Entree);
        Item entree3 = new Item("Struck Gold Chicken Nuggets", "1 in 10000 contains a real gold nugget!", 4.99, "/resources/fasthappyimages/struckgoldnuggest.jpg", Item.Section.Entree);
        Item entree4 = new Item("It was you Alfredo", "Alfredo so good it'll break your heart!", 8.99, "/resources/fasthappyimages/itwasyoualfredo.jpg", Item.Section.Entree);
        Item entree5 = new Item("J. Paul Spaghetti", "Perfect for the grand kids!", 17, "/resources/fasthappyimages/jpaulspaghetti.jpg", Item.Section.Entree);
        Item side1 = new Item("Six, Fries, and Videotape", "Perfect for getting over a breakup!", 1.99, "/resources/fasthappyimages/sixfriesvideotape.jpg", Item.Section.Side);
        Item side2 = new Item("Make a Wedge", "PLACEHOLDER!", 1.99, "/resources/fasthappyimages/makeawedge.jpg", Item.Section.Side);
        Item dessert1 = new Item("Go to Townie Brownie", "PLACEHOLDER!", 5.99, "/resources/fasthappyimages/gototowniebrownie.jpg", Item.Section.Dessert);
        Item dessert2 = new Item("Shake Shake Shake", "Shake, shake, shake it off!", 4.99, "/resources/fasthappyimages/shakes.jpg", Item.Section.Dessert);
        Item drink1 = new Item("Coke, Sprite", "Original recipe!", 2.49, "/resources/fasthappyimages/coke.jpg", Item.Section.Drink);
        Item drink2 = new Item("Iced Tea", "A favourite of Tracy Marrow!", 2.99, "/resources/fasthappyimages/icetea.jpg", Item.Section.Drink);


        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/resources/menu.dat"));
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
    }
}
