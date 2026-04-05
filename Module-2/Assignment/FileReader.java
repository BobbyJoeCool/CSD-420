/**
 * Robert Breutzmann
 * CSD 420 - Advanced Java Programming
 * Assignment 2.2 - Due April 5th, 2026
 */

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * FileReader class contains the main method to read data from a binary file.
 * This program reads integers and doubles from "Rbreutzmann_datafile.dat" and displays them.
 * It assumes the file contains sets of 5 integers followed by 5 doubles, repeating until the end of the file.
 */
public class FileReader {

    public static void main(String[] args) {

        try (DataInputStream input =
                new DataInputStream(
                    new FileInputStream("Rbreutzmann_datafile.dat"))) {

            // Read and display data in sets of 5 integers and 5 doubles until end of file
            while (input.available() > 0) {

                System.out.println("Integers:");
                // Read and print 5 integers
                for (int i = 0; i < 5; i++) {
                    System.out.println(input.readInt());
                }

                System.out.println("Doubles:");
                // Read and print 5 doubles
                for (int i = 0; i < 5; i++) {
                    System.out.println(input.readDouble());
                }

                System.out.println("-----");
            }

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}