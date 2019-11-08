package com.Windspinks.ExoticMoves.Model;

import java.io.File;

public class Aston extends Car {

    public Aston(Color color, boolean isConvertible, int numCylinders, File imageFile) {
        super(Brand.AstonMartin, 120, color, isConvertible, numCylinders, 3.6, imageFile);
    }

    public Aston(String color, boolean isConvertible, int numCylinders, File imageFile) {
        this(Color.valueOf(color), isConvertible, numCylinders, imageFile);
    }
}