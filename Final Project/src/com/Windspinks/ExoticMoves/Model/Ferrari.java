package com.Windspinks.ExoticMoves.Model;

import java.io.File;

public class Ferrari extends Car {

    public Ferrari(Color color, boolean isConvertible, int numCylinders, File imageFile) {
        super(Brand.Ferrari, 200, color, isConvertible, numCylinders, 2.7, imageFile);
    }

    public Ferrari(String color, boolean isConvertible, int numCylinders, File imageFile) {
        this(Color.valueOf(color), isConvertible, numCylinders, imageFile);
    }
}
