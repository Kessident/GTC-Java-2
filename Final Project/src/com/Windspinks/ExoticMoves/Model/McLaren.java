package com.Windspinks.ExoticMoves.Model;

import java.io.File;

public class McLaren extends Car {

    public McLaren(Color color, boolean isConvertible, int numCylinders, File imageFile) {
        super(Brand.McLaren, 265, color, isConvertible, numCylinders, 2.5, imageFile);
    }

    public McLaren(String color, boolean isConvertible, int numCylinders, File imageFile) {
        this(Color.valueOf(color), isConvertible, numCylinders, imageFile);
    }
}
