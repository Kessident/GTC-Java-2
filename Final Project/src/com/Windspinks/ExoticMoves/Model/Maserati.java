package com.Windspinks.ExoticMoves.Model;

public class Maserati extends Car {

    public Maserati(Color color, boolean isConvertible, int numCylinders) {
        super(Brand.Maserati, 100, color, isConvertible, numCylinders, 3.8);
    }

    public Maserati(String color, boolean isConvertible, int numCylinders) {
        this(Color.valueOf(color), isConvertible, numCylinders);
    }
}
