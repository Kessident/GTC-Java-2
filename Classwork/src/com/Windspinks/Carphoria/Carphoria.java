package com.Windspinks.Carphoria;

import java.util.Arrays;

public class Carphoria {
    private InventoryItem[] inventory;
    private int indexOfLast;

    private static String companyName;


    public Carphoria() {
        inventory = new InventoryItem[1];
        indexOfLast = 0;
    }

    public Carphoria(int inventoryNum) {
        inventory = new InventoryItem[inventoryNum];
    }


    public InventoryItem[] getInventory() {
        return inventory;
    }

    public void setInventory(InventoryItem[] inventory) {
        this.inventory = inventory;
    }

    public static String getCompanyName() {
        return companyName;
    }

    public void addInventoryItem(InventoryItem newItem) {
        //If no more space, new array with 10 more elements, set new array as inventory
        if (indexOfLast == inventory.length) {
            InventoryItem[] newInventory = Arrays.copyOf(inventory, inventory.length + 10);

            this.setInventory(newInventory);
        }

        inventory[indexOfLast] = new InventoryItem(newItem);
        indexOfLast++;
    }


    public void displayInventory() {
        System.out.println("We currently have the following vehicles in inventory");

        //14, 10, 12, 8
        System.out.printf("%-15s %-10s %-12s %-8s\n", "Item Number", "Make", "Model", "Price");
        for (InventoryItem item : inventory) {
            if (item != null) {
                System.out.printf("%-15d %-10s %-12s %-8.2f\n", item.getItemNumber(), item.getVehicle().getMake(), item.getVehicle().getModel(), item.getPrice());
            }
        }
    }
}
