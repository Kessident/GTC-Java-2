package com.Windspinks;

public class NegativeInStock extends Exception {
    public NegativeInStock(String item){
        super("Cannot have negative " + item +"s.");
    }
}
