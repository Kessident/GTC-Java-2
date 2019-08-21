package com.Windspinks.Carphoria;

public class InventoryItem {
    private Car vehicle;
    private double price;
    private int itemNumber;

    public InventoryItem() {
    }

    public InventoryItem(Car vehicle, double price, int itemNumber) {
        this.vehicle = vehicle;
        this.price = price;
        this.itemNumber = itemNumber;
    }

    public Car getVehicle() {
        return this.vehicle;
    }

    public void setVehicle(Car vehicle) {
        this.vehicle = vehicle;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getItemNumber() {
        return this.itemNumber;
    }

    public void setItemNumber(int itemNumber) {
        this.itemNumber = itemNumber;
    }
}
