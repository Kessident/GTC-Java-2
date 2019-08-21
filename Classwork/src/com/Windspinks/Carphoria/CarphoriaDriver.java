package com.Windspinks.Carphoria;

public class CarphoriaDriver {

    public static void main(String[] args) {
        Carphoria carphoria = new Carphoria();
        initInventory(carphoria);

        System.out.println("Welcome to Carphoria!");
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
}
