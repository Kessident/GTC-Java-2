package com.Windspinks.ExoticMoves.Model;

public class Lamborghini extends Car {

    public Lamborghini(Color color, boolean isConvertible, int numCylinders) {
        super(Brand.Lamborghini, 400, color, isConvertible, numCylinders, 2.5);
    }

    public Lamborghini(String color, boolean isConvertible, int numCylinders) {
        this(Color.valueOf(color), isConvertible, numCylinders);
    }
}
