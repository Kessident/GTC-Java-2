package com.Windspinks;
/*
 * Charles Dodge
 * CIST 2372 CRN 23159
 * Lab 6 RetailItem Exceptions
 */
public class NegativeInStock extends Exception {
    public NegativeInStock(String item){
        super("Cannot have negative " + item +"s.");
    }
}
