package com.Windspinks.Carphoria;

import java.util.concurrent.ThreadLocalRandom;

public class CarphoriaDriver {

    public static void main(String[] args) {
        Carphoria carphoria = new Carphoria();
        initInventory(carphoria);

        System.out.println("Welcome to Carphoria!");
        carphoria.displayInventory();

        for (int i = 0; i < 17; i++) {
            carphoria.addInventoryItem(getNewCar());
        }

        carphoria.displayInventory();
    }

    private static void initInventory(Carphoria carphoria) {
        InventoryItem invItem1 = new InventoryItem(new Car("Toyota", "Camry"), 17000.00);
        carphoria.addInventoryItem(invItem1);

        InventoryItem invItem2 = new InventoryItem(new Car("Honda", "Accord"), 20000.00);
        carphoria.addInventoryItem(invItem2);

        InventoryItem invItem3 = new InventoryItem(new Car("Ford", "Focus"), 15000.00);
        carphoria.addInventoryItem(invItem3);
    }

    private static InventoryItem getNewCar() {
        String make;
        String model;
        int carPrice;
        make = "Custom";
        model = "Custom";
        carPrice = ThreadLocalRandom.current().nextInt(10000, 100000);

        return new InventoryItem(new Car(make, model), carPrice);
    }
}
