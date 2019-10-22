package com.FastHappy;

import java.io.Serializable;

public class Item implements Serializable {
    private String name;
    private String description;
    private double price;
    private String imageFileURL;
    private Section section;

    public Item() {
    }

    public Item(String name, String description, double price, String imageFileURL, Section section) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageFileURL = imageFileURL;
        this.section = section;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImageFileURL() {
        return imageFileURL;
    }

    public void setImageFileURL(String imageFileURL) {
        this.imageFileURL = imageFileURL;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public enum Section {Entree, Side, Dessert, Drink}
}
