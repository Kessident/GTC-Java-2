package com.Windspinks.ExoticMoves.Model;

import java.util.HashSet;
import java.util.Set;

public class CarFilters {

    public static Set<Car> filterByBrand(Brand brand, Set<Car> carInventory) {
        Set<Car> filteredList = new HashSet<>();
        for (Car car : carInventory) {
            if (car.getBrand().equals(brand)) {
                filteredList.add(car);
            }
        }
        return filteredList;
    }

    public static Set<Car> filterByColor(Color color, Set<Car> carInventory) {
        Set<Car> filteredList = new HashSet<>();
        for (Car car : carInventory) {
            if (car.getColor().equals(color)) {
                filteredList.add(car);
            }
        }
        return filteredList;
    }

    public static Set<Car> filterByConv(boolean isConvertible, Set<Car> carInventory) {
        Set<Car> filteredList = new HashSet<>();
        for (Car car : carInventory) {
            if (car.isConvertible() == isConvertible) {
                filteredList.add(car);
            }
        }
        return filteredList;
    }

    public static Set<Car> filterByNumCylinders(int num, Set<Car> carInventory) {
        Set<Car> filteredList = new HashSet<>();
        for (Car car : carInventory) {
            if (car.getNumCylinders() == num) {
                filteredList.add(car);
            }
        }
        return filteredList;
    }

    public static Set<Car> filterByPrice(double price, Set<Car> carInventory) {
        Set<Car> filteredList = new HashSet<>();
        for (Car car : carInventory) {
            if (car.getPrice() <= price) {
                filteredList.add(car);
            }
        }
        return filteredList;
    }
}