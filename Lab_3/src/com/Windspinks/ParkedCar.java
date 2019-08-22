package com.Windspinks;

public class ParkedCar {
    private String make;
    private String model;
    private String color;
    private String licenseNumber;
    private int minutesParked;

    public ParkedCar(String make, String model, String color) {
        this.make = make;
        this.model = model;
        this.color = color;
    }

    public ParkedCar(String make, String model, String color, String licenseNumber, int minutesParked) {
        this.make = make;
        this.model = model;
        this.color = color;
        this.licenseNumber = licenseNumber;
        this.minutesParked = minutesParked;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public int getMinutesParked() {
        return minutesParked;
    }

    public void setMinutesParked(int minutesParked) {
        this.minutesParked = minutesParked;
    }

    public String toString() {
        //COLOR MAKE MODEL, plate number PLATENUM, parked for NUM minutes
        return String.format("%s %s %s, plate number %s, parked for %,d minutes", color, make, model, licenseNumber, minutesParked);
    }
}