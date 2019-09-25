package com.Windspinks;
/*
 * Charles Dodge
 * CIST 2372 CRN 23159
 * Lab FileArray
 */
import java.io.*;

public class FileArray {

    public static void writeArray(File file, int[] array) throws FileNotFoundException, IOException {
        DataOutputStream oStream = new DataOutputStream(new FileOutputStream(file));
        oStream.writeInt(array.length);
        for (int i : array) {
            oStream.writeInt(i);
        }
        oStream.close();
    }

    public static void readArray(File file, int[] array) throws FileNotFoundException, IOException {
        DataInputStream inStream = new DataInputStream(new FileInputStream(file));
        int numInts = inStream.readInt();
        for (int i = 0; i < numInts; i++) {
            if (i >= array.length) {
                inStream.close();
                return;
            }
            array[i] = inStream.readInt();
        }

        inStream.close();
    }
}
