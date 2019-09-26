package com.Windspinks.PowerBall;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class LotteryStatistics {
    public static void runStats() {
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
        String[] currentPBNums;
        Map<Integer, Integer> numberFrequency = new HashMap<>();
        Map<Integer, Integer> powerBallFrequency = new HashMap<>();
        Map<Integer, Integer> powerBallLastPull = new HashMap<>();
        Integer count = 0;

        while (numbersScn.hasNext()) {
            currentPowerBallLine = numbersScn.nextLine();
            currentPBNums = currentPowerBallLine.split("\t");

            for (int i = 0; i < currentPBNums.length; i++) {
                Integer currentNum = Integer.parseInt(currentPBNums[i]);
                if (i == 5) { //Powerball Number
                    increaseFrequency(powerBallFrequency, currentNum);
                } else {
                    increaseFrequency(numberFrequency, currentNum);
                    powerBallLastPull.put(currentNum, count);
                }
            }
            count++;
        }


        System.out.println("Frequency of regular numbers: ");
        System.out.println("Number | Frequency");
        for (Map.Entry<Integer, Integer> entry : numberFrequency.entrySet()) {
            System.out.println(entry.getKey() + "\t\t" + entry.getValue());
        }

        System.out.println("Frequency of PowerBall Numbers: ");
        System.out.println("Number | Frequency");
        for (Map.Entry<Integer, Integer> entry : powerBallFrequency.entrySet()) {
            System.out.println(entry.getKey() + "\t\t" + entry.getValue());
        }

        List<Map.Entry<Integer, Integer>> mostCommonNumbers = numberFrequency.entrySet().stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .limit(10)
            .collect(Collectors.toList());
        List<Map.Entry<Integer, Integer>> leastCommonNumbers = numberFrequency.entrySet().stream()
            .sorted(Map.Entry.comparingByValue(Comparator.naturalOrder()))
            .limit(10)
            .collect(Collectors.toList());
        List<Map.Entry<Integer, Integer>> mostOverdueNumbers = powerBallLastPull.entrySet().stream()
            .sorted(Map.Entry.comparingByValue(Comparator.naturalOrder()))
            .limit(10)
            .collect(Collectors.toList());

        System.out.println("\n--Top 10 most frequent numbers--");
        System.out.println("Number\tFrequency");
        for (Map.Entry<Integer, Integer> entry : mostCommonNumbers) {
            System.out.println(entry.getKey() + "\t\t" + entry.getValue());
        }

        System.out.println("\n--Top 10 least frequent numbers--");
        System.out.println("Number\tFrequency");
        for (Map.Entry<Integer, Integer> entry : leastCommonNumbers) {
            System.out.println(entry.getKey() + "\t\t" + entry.getValue());
        }

        System.out.println("\n--Top 10 most overdue numbers--");
        System.out.println("Number\tWeeks Since Pulled");
        for (Map.Entry<Integer, Integer> entry : mostOverdueNumbers) {
            System.out.println(entry.getKey() + "\t\t" + (count - entry.getValue()));
        }
    }

    private static void increaseFrequency(Map<Integer, Integer> map, Integer value) {
        Integer frequency = map.get(value);
        if (frequency == null) {
            map.put(value, 1);
        } else {
            map.put(value, frequency + 1);
        }
    }
}
