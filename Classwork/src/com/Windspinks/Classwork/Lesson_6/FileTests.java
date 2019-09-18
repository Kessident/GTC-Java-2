package com.Windspinks.Classwork.Lesson_6;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileTests {

    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter("/Users/Windspinks/IdeaProjects/GTC/Java II/Classwork/Test.txt");
        pw.println("123");

        pw.close();

        System.out.println();
        System.out.println("a thing");


        File inputFile = new File("test.txt");
        Scanner scnFile = new Scanner(inputFile);

        System.out.println(scnFile.nextLine());

        scnFile.close();


        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("someData.dat"));
        dataOutputStream.writeUTF("This is a string in \"someData.dat\"\t");
        dataOutputStream.close();

        DataInputStream dataInputStream = new DataInputStream(new FileInputStream("someData.dat"));
        System.out.println(dataInputStream.readUTF());
        dataInputStream.close();


        System.out.println("\n\n\n");


        Account newAccount = new Account(1000000, "first", "last");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("accountData.dat"));
        oos.writeInt(1);
        oos.writeObject(newAccount);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("accountData.dat"));
        int numObjects = ois.readInt();
        ArrayList<Account> accounts = new ArrayList<>();


        try {
            for (int i = 0; i < numObjects; i++) {
                accounts.add((Account) ois.readObject());
            }
            ois.close();
        } catch (ClassNotFoundException ex) {
            System.out.println("Well shit");
        }


        for (Account acc : accounts) {
            System.out.println(acc);
        }
    }
}
