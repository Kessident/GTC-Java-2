package com.Windspinks.Carphoria;

public class CarphoriaDriver {

    public static void main(String[] args) {
        Carphoria carphoria = new Carphoria();
        initInventory(carphoria);

        System.out.println("Welcome to Carphoria!");
        System.out.println("We currently have the following vehicles in inventory");

        //14, 10, 12, 8
        System.out.printf("%-14s %-10s %-12s %-8s\n", "Item Number", "Make", "Model", "Price");
        for (InventoryItem item : carphoria.getInventory()) {
            if (item != null) {
                System.out.printf("%-14d %-10s %-12s %-8.2f\n", item.getItemNumber(), item.getVehicle().getMake(), item.getVehicle().getModel(), item.getPrice());
            }
        }

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
