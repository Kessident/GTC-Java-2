package com.Windspinks.ExoticMoves.Model;

import java.io.Serializable;

public abstract class Car implements Serializable {
    private Brand brand;
    private double price;
    private Color color;
    private boolean isConvertible;
    private int numCylinders;
    private double zeroToSixty;

    public Car() {
    }

    public Car(Brand brand, double price, Color color, boolean isConvertible, int numCylinders, double zeroToSixty) {
        this.brand = brand;
        this.price = price;
        this.color = color;
        this.isConvertible = isConvertible;
        this.numCylinders = numCylinders;
        this.zeroToSixty = zeroToSixty;
    }

    public Car(Brand brand, double price, String color, boolean isConvertible, int numCylinders, double zeroToSixty) {
        this(brand, price, Color.valueOf(color), isConvertible, numCylinders, zeroToSixty);
    }

    public Brand getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isConvertible() {
        return isConvertible;
    }

    public void setConvertible(boolean convertible) {
        isConvertible = convertible;
    }

    public int getNumCylinders() {
        return numCylinders;
    }

    public void setNumCylinders(int numCylinders) {
        this.numCylinders = numCylinders;
    }

    public double getZeroToSixty() {
        return zeroToSixty;
    }

    public void setZeroToSixty(double zeroToSixty) {
        this.zeroToSixty = zeroToSixty;
    }

    protected enum Brand {AstonMartin, Ferrari, Lamborghini, McLaren, Maserati}

    protected enum Color {Black, Blue, Green, Orange, Red, White, Yellow}
}
