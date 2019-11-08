package com.Windspinks.ExoticMoves.Model;

public class Aston extends Car {

    public Aston(Color color, boolean isConvertible, int numCylinders) {
        super(Brand.AstonMartin, 120, color, isConvertible, numCylinders, 3.6);
    }

    public Aston(String color, boolean isConvertible, int numCylinders) {
        this(Color.valueOf(color), isConvertible, numCylinders);
    }
}