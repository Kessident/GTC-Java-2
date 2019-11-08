package com.Windspinks.ExoticMoves.Model;

public class Ferrari extends Car {

    public Ferrari(Color color, boolean isConvertible, int numCylinders) {
        super(Brand.Ferrari, 200, color, isConvertible, numCylinders, 2.7);
    }

    public Ferrari(String color, boolean isConvertible, int numCylinders) {
        this(Color.valueOf(color), isConvertible, numCylinders);
    }
}
