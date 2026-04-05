/**
 * Robert Breutzmann
 * CSD 420 - Advanced Java Programming
 * Assignment 2.2 - Due April 5th, 2026
 */

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * FileWriter class contains the main method to write random integers and doubles to a file.
 */
public class FileWriter {
    /**
     * The main method generates random data and writes it to a file.
     * @param args command-line arguments (not used in this program)
     */
    public static void main(String[] args) {
        int[] integers = new int[5];
        double[] doubles = new double[5];

        // Generate random values for integers and doubles
        for (int i = 0; i < 5; i++) {
            integers[i] = (int)(Math.random() * 2147483646) + 1;
            doubles[i] = Math.random();
        }

        try (DataOutputStream output =
                new DataOutputStream(
                    new FileOutputStream("Rbreutzmann_datafile.dat", true))) {

            // Write integers to the file
            for (int i : integers) {
                output.writeInt(i);
            }

            // Write doubles to the file
            for (double d : doubles) {
                output.writeDouble(d);
            }

            System.out.println("Data written successfully.");

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}