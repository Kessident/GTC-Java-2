package com.Windspinks.Carphoria;

public class Car {

    private String make;
    private String model;

    public Car() {
    }

    public Car(String make, String model) {
        this.make = make;
        this.model = model;
    }

    public Car(Car obj) {
        this.make = obj.make;
        this.model = obj.model;
    }

    public String getMake() {
        return this.make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Car{" +
            "make='" + make + '\'' +
            ", model='" + model + '\'' +
            '}';
    }
}
