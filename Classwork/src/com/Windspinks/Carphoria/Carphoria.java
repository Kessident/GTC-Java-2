package com.Windspinks.Carphoria;

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
        //If not enough space remains in inventory array, create new array with 10 extra, copy everything over, then set new inventory
        if (indexOfLast == inventory.length) {
            InventoryItem[] newInventoryList = new InventoryItem[inventory.length + 10];
            int newInventoryCounter = 0;

            for (InventoryItem invItem : inventory) {
                newInventoryList[newInventoryCounter] = new InventoryItem(invItem);
            }

            this.setInventory(newInventoryList);
        }

        inventory[indexOfLast] = new InventoryItem(newItem);
        indexOfLast++;
    }
}
