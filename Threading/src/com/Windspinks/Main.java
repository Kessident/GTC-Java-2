package com.Windspinks;

import javax.swing.*;

public class Main implements Runnable {

    public static void main(String[] args) {
            System.out.println(1);

            Main main = new Main();
            Thread newThread = new Thread(main);
            newThread.start();

            System.out.println(5);
    }

    public void run() {
        try {
            Thread.sleep(4000);
            String oneString = JOptionPane.showInputDialog("Hello person");
            System.out.println(oneString);
        } catch (Exception ignored) {

        }
    }
}
