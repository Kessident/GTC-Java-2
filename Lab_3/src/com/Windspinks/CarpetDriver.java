package com.Windspinks;

import java.util.Scanner;

public class CarpetDriver {

    public static void carpetDemo() {
        double length;
        double width;
        double price;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the length of the room (in feet): ");
        length = input.nextDouble();
        System.out.print("Enter the width of the room (in feet): ");
        width = input.nextDouble();
        System.out.print("Enter the price per square foot of carpet: ");
        price = input.nextDouble();

        RoomDimension dimensions = new RoomDimension(length, width);
        RoomCarpet carpet = new RoomCarpet(dimensions, price);

        System.out.printf("For a room with dimensions %.2f ft by %.2f ft\n", carpet.getSize().getLength(), carpet.getSize().getWidth());
        System.out.printf("It will cost $%.2f at $%.2f per sq ft", carpet.getTotalCost(), carpet.getCarpetCost());
    }

}
