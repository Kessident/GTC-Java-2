package com.Windspinks;

public class Temperature {

    private double fTemp;

    public Temperature(double fTemp) {
        this.fTemp = fTemp;
    }

    public double getFahrenheit() {
        return fTemp;
    }

    public void setFahrenheit(double fTemp) {
        this.fTemp = fTemp;
    }

    public double getCelsius() {
        return (5.0 / 9.0) * (fTemp - 32);
    }

    public double getKelvin() {
        return getCelsius() + 273;
    }
}
