package com.Windspinks.ExoticMoves.Model;

import java.io.File;

public class Maserati extends Car {

    public Maserati(Color color, boolean isConvertible, int numCylinders, File imageFile) {
        super(Brand.Maserati, 100, color, isConvertible, numCylinders, 3.8, imageFile);
    }

    public Maserati(String color, boolean isConvertible, int numCylinders, File imageFile) {
        this(Color.valueOf(color), isConvertible, numCylinders, imageFile);
    }
}
