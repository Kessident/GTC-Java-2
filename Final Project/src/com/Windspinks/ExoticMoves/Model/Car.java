package com.Windspinks.ExoticMoves.Model;

import java.io.File;
import java.io.Serializable;

public abstract class Car implements Serializable {
    private Brand brand;
    private double price;
    private Color color;
    private boolean isConvertible;
    private int numCylinders;
    private double zeroToSixty;
    private File imageFile;

    public Car() {
    }

    public Car(Brand brand, double price, Color color, boolean isConvertible, int numCylinders, double zeroToSixty, File imageFile) {
        this.brand = brand;
        this.price = price;
        this.color = color;
        this.isConvertible = isConvertible;
        this.numCylinders = numCylinders;
        this.zeroToSixty = zeroToSixty;
        this.imageFile = imageFile;
    }

    public Car(Brand brand, double price, String color, boolean isConvertible, int numCylinders, double zeroToSixty, File imageFile) {
        this(brand, price, Color.valueOf(color), isConvertible, numCylinders, zeroToSixty, imageFile);
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

    public File getImageFile() {
        return imageFile;
    }

    public void setImageFile(File imageFile) {
        this.imageFile = imageFile;
    }
}
