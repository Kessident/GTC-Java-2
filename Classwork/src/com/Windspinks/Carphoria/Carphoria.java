package com.Windspinks.Carphoria;

public class Carphoria {
    private Object[] inventory;

    private static String companyName;


    public Carphoria() {
        inventory = new Object[1];
    }

    public Carphoria(int inventoryNum) {
        inventory = new Object[inventoryNum];
    }


    public Object[] getInventory() {
        return inventory;
    }

    public void setInventory(Object[] inventory) {
        this.inventory = inventory;
    }

    public static String getCompanyName () {
        return companyName;
    }
}
