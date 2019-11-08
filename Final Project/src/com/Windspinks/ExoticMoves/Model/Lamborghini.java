package com.Windspinks.ExoticMoves.Model;

import java.io.File;

public class Lamborghini extends Car {

    public Lamborghini(Color color, boolean isConvertible, int numCylinders, File imageFile) {
        super(Brand.Lamborghini, 400, color, isConvertible, numCylinders, 2.5, imageFile);
    }

    public Lamborghini(String color, boolean isConvertible, int numCylinders, File imageFile) {
        this(Color.valueOf(color), isConvertible, numCylinders, imageFile);
    }
}
