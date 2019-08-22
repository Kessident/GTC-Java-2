package com.Windspinks.Carphoria;

public class InventoryItem {
    private Car vehicle;
    private double price;
    private int itemNumber;
    private static int maxItemNumber = 1000;

    public InventoryItem() {
    }
    public InventoryItem(Car vehicle, double price) {
        this.vehicle = vehicle;
        this.price = price;
        this.itemNumber = getNextItemNumber();
    }
    public InventoryItem(InventoryItem invItem) {
        this.vehicle = invItem.vehicle;
        this.price = invItem.price;
        this.itemNumber = invItem.itemNumber;
    }

    public Car getVehicle() {
        return this.vehicle;
    }
    public void setVehicle(Car vehicle) {
        this.vehicle = new Car(vehicle);
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
    public void setItemnumber(int itemNumber) {
        this.itemNumber = itemNumber;
    }

    private int getNextItemNumber() {
        return ++maxItemNumber;
    }

    @Override
    public String toString() {
        return "InventoryItem{" +
            "vehicle=" + vehicle +
            ", price=" + price +
            '}';
    }
}
