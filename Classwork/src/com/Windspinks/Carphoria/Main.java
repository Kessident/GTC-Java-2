package com.Windspinks.Carphoria;

public class Main {

    public static void main(String[] args) {
        InventoryItem item1 = new InventoryItem(new Car("make 1", "model 1"), 111);
        InventoryItem item2 = new InventoryItem(new Car("make 2", "model 2"), 222);
        InventoryItem item3 = new InventoryItem(new Car("make 3", "model 3"), 333);
        InventoryItem item4 = new InventoryItem(new Car("make 4", "model 4"), 444);
        InventoryItem item5 = new InventoryItem(new Car("make 5", "model 5"), 555);

        System.out.println(item1.getItemNumber());
        System.out.println(item2.getItemNumber());
        System.out.println(item3.getItemNumber());
        System.out.println(item4.getItemNumber());
        System.out.println(item5.getItemNumber());

    }
}
