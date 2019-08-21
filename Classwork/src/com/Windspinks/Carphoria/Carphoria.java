package com.Windspinks.Carphoria;

public class Carphoria {
    private InventoryItem[] inventory;

    private static String companyName;


    public Carphoria() {
        inventory = new InventoryItem[1];
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

    public static String getCompanyName () {
        return companyName;
    }
}
