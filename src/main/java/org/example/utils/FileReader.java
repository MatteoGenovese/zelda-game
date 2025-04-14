package org.example.utils;

import org.example.Main;

import java.io.InputStream;
import java.util.Scanner;

public class FileReader {

    public static void readFile(String fileName) {
        InputStream input = Main.class.getClassLoader().getResourceAsStream(fileName+".txt");
        if (input == null) {
            System.out.println("File not found");
            return;
        }

        try (Scanner myReader = new Scanner(input)) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
        } catch (Exception e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }
}
