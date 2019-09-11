package com.Windspinks;
/*
 * Charles Dodge
 * CIST 2372 CRN 23159
 * Lab 6 RetailItem Exceptions
 */
public class NegativePrice extends Exception {
    public NegativePrice(double price) {
        super(price + " is not a valid price (cannot be negative).");
    }

}
