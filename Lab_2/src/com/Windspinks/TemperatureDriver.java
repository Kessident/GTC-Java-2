package com.Windspinks;

import java.util.Scanner;

public class TemperatureDriver {
    public static void tempDemo() {
        Scanner input = new Scanner(System.in);

        double fTemp;
        System.out.println("Enter a temperature in Fahrenheit and it will be displayed in Celsius and Kelvin");
        System.out.print(">>> ");

        fTemp = input.nextDouble();

        Temperature userTemp = new Temperature(fTemp);


        System.out.printf("%.2f degrees Fahrenheit is %.2f in Celsius and %.2f in Kelvin.", userTemp.getFahrenheit(), userTemp.getCelsius(), userTemp.getKelvin());
    }
}
