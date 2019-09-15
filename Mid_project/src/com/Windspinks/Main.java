package com.Windspinks;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        String powerBallFileLocation = "pbnumbers.txt";
        File pnumbersFile = new File(powerBallFileLocation);
        Scanner numbersScn = null;

        while (numbersScn == null) {
            try {
                numbersScn = new Scanner(pnumbersFile);

            } catch (FileNotFoundException ex) {
                Scanner userInput = new Scanner(System.in);
                System.out.println(powerBallFileLocation + " not found");
                System.out.print("Please enter location for PowerBall numbers file: ");


                powerBallFileLocation = userInput.next();
                pnumbersFile = new File(powerBallFileLocation);
            }
        }

        String currentPowerBallLine;
        String[] currentPBNums;//
        int[] powerBallNumberFrequency = new int[69];
        int[] powerBallPBNumberFrequency = new int[35];

        while (numbersScn.hasNext()) {
            currentPowerBallLine = numbersScn.nextLine();
            currentPBNums = currentPowerBallLine.split(" ");

            for (int i = 0; i < currentPBNums.length; i++) {
                String s = currentPBNums[i];
                int index = Integer.parseInt(s) - 1;
                if (i == 5) {
                    if (index < 35) //TODO: REMOVE - NECESSARY FOR THE DATA.GOV DATA SETS
                    powerBallPBNumberFrequency[index]++;
                } else {
                    powerBallNumberFrequency[index]++;
                }
            }
        }

        System.out.println("Frequency of regular numbers: ");
        for (int i = 0; i < powerBallNumberFrequency.length; i++) {
            System.out.println(i + ": " + powerBallNumberFrequency[i]);
        }

        System.out.println("Frequency of PowerBall Numbers: ");
        for (int i = 0; i < powerBallPBNumberFrequency.length; i++) {
            System.out.println(i + ": " + powerBallPBNumberFrequency[i]);
        }

        List<Integer> list = IntStream.of(powerBallNumberFrequency).boxed().collect(Collectors.toList());
        Map<Integer, Long> map = list.stream()
            .collect(Collectors.groupingBy(w -> w, Collectors.counting()));

        List<Map.Entry<Integer, Long>> mostCommonNumbers = map.entrySet().stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .limit(10)
            .collect(Collectors.toList());
        List<Map.Entry<Integer, Long>> leastCommonNumbers = map.entrySet().stream()
            .sorted(Map.Entry.comparingByValue(Comparator.naturalOrder()))
            .limit(10)
            .collect(Collectors.toList());


        System.out.println("\nTop 10 most frequent numbers: ");
        for (Map.Entry<Integer, Long> m: mostCommonNumbers) {
            System.out.print(m.getKey() + " ");
        }

        System.out.println("\nTop 10 least frequent numbers: ");
        for (Map.Entry<Integer, Long> m: leastCommonNumbers) {
            System.out.print(m.getKey() + " ");
        }
    }
}
