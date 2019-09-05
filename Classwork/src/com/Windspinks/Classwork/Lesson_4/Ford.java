package com.Windspinks.Classwork.Lesson_4;

public class Ford {

    private String make;
    private String model;
    private String specs;
    private int numberOfCylinders;

    public Ford(String model) {
        this.model = model;
    }

    public Ford(String make, String model, String specs, int numberOfCylinders) {
        this.make = make;
        this.model = model;
        this.specs = specs;
        this.numberOfCylinders = numberOfCylinders;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSpecs() {
        return specs;
    }

    public void setSpecs(String specs) {
        this.specs = specs;
    }

    public int getNumberOfCylinders() {
        return numberOfCylinders;
    }

    public void setNumberOfCylinders(int numberOfCylinders) {
        this.numberOfCylinders = numberOfCylinders;
    }

    public void startEngine(){
        System.out.println("The engine is running.");
    }

    public void accelerate(){
        System.out.println("The car is moving.");
    }

    public void brake(){
        System.out.println("The car is stopped.");
    }

    public void stopEngine() {
        System.out.println("The engine is not running.");
    }

}
