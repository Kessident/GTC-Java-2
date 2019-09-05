package com.Windspinks.Classwork.Lesson_4;

public class Lesson4Main {

    public static void main(String[] args){
        Ford car = new Ford("Car");

        car.startEngine();
        car.accelerate();
        car.brake();
        car.stopEngine();

        Mustang must = new Mustang();
        System.out.println(must.getMake());
    }
}
