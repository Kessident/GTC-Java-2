package com.Windspinks;

public class RoomCarpet {
    private RoomDimension size;
    private double carpetCost;



    public RoomCarpet(RoomDimension size, double carpetCost) {
        this.size = size;
        this.carpetCost = carpetCost;
    }

    public RoomDimension getSize() {
        return size;
    }

    public void setSize(RoomDimension size) {
        this.size = size;
    }

    public double getCarpetCost() {
        return carpetCost;
    }

    public void setCarpetCost(double carpetCost) {
        this.carpetCost = carpetCost;
    }

    public double getTotalCost() {
        return size.getArea() * carpetCost;
    }
}
