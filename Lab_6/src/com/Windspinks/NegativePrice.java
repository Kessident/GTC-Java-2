package com.Windspinks;

public class NegativePrice extends Exception {
    public NegativePrice(double price) {
        super(price + " is not a valid price (cannot be negative).");
    }

}
