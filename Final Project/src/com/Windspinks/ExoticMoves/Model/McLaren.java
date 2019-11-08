package com.Windspinks.ExoticMoves.Model;

public class McLaren extends Car {

    public McLaren(Color color, boolean isConvertible, int numCylinders) {
        super(Brand.McLaren, 265, color, isConvertible, numCylinders, 2.5);
    }

    public McLaren(String color, boolean isConvertible, int numCylinders) {
        this(Color.valueOf(color), isConvertible, numCylinders);
    }
}
