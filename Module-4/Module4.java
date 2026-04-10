/**
 *
 * @author Robert Breutzmann
 * CSD 420 - Advanced Java Programming
 * Assignment 4.2 - Due 4/8/2026
 */

import java.util.LinkedList;
import java.util.Random;

public class Module4 {

    /**
     * Traverses the provided list using an enhanced for-loop.
     *
     * @param list the list to traverse
     * @return the elapsed traversal time in seconds, to the nearest millisecond.
     */
    public static double iterateList(LinkedList<Integer> list) {
        long startTime = System.nanoTime();  // logs the start time in nanoseconds
        int num;
        
        for (int number : list) {
            num = number; // Assigns the variable in the list to a dummy variable to simulate the list doing something.
        }

        long endTime = System.nanoTime(); // logs the end time in nanoseconds
        long durationMS = (endTime - startTime) / 1000000;  // finds the difference (time elapsed) in nanoseconds, and converts to milliseconds.
        return durationMS / 1000.0; // converts milliseconds to seconds with a decimal of milliseconds and returns the double value.
    } 

    /**
     * Traverses the provided list using the get(index) method.
     *
     * @param list the list to traverse
     * @return the elapsed traversal time in seconds (rounded to the nearest millisecond)
     */
    public static double getList(LinkedList<Integer> list) {
        long startTime = System.nanoTime();  // logs the start time in nanoseconds
        int num;

        for (int i = 0; i < list.size(); i++) {
            num = list.get(i); // Dummy function to simulate something happening
        }

        long endTime = System.nanoTime(); // logs the end time in nanoseconds
        long durationMS = (endTime - startTime) / 1000000;  // finds the difference (time elapsed) in nanoseconds, and converts to milliseconds.
        return durationMS / 1000.0; // converts milliseconds to seconds with a decimal of milliseconds and returns the double value.
    }

    /**
     * Prints a formatted comparison of the two traversal times.
     *
     * @param iterateT the elapsed time for iterator-based traversal in seconds
     * @param getT the elapsed time for indexed traversal in seconds
     * @param listLen the length of the list being tested
     */
    public static void compareTimes(double iterateT, double getT, int listLen) {
        System.out.println("-".repeat(30));
        System.out.println("List length was " + String.format("%,d", listLen));

        System.out.println("Iterating the list took " + 
            String.format("%.3f", iterateT) + " seconds.");

        System.out.println("Using the get() function took " + 
            String.format("%.3f", getT) + " seconds.");

        double percentDiff = ((getT - iterateT) / iterateT) * 100;

        System.out.println("get() was " + 
            String.format("%,.2f", percentDiff) + "% slower than iteration.");
    }

    /**
     * Entry point for the program. Populates the linked list with random integers
     * and compares traversal performance for 50,000 and 500,000 elements.
     *
     * @param args command-line arguments are ignored
     */
    public static void main(String[] args) {
        LinkedList<Integer> numbers = new LinkedList<>();
        Random rand = new Random();
        
        int len = 50000; // sets the list length to 50K

        for (int i = 0; i < len; i ++) {  // Generates a random list of the assigned length
            numbers.add(rand.nextInt());
        }

        double iterate50K = iterateList(numbers);  // calls the iterate method
        double get50K = getList(numbers);  // calls the get() method

        compareTimes(iterate50K, get50K, len);  // calls the comparer method to display results.

        len = 500000; // resets the length the length to 500K.

        numbers.clear(); // clears the list

        for (int i = 0; i < len; i ++) { // adds 500K integers to the list.
            numbers.add(rand.nextInt());
        }

        double iterate500K = iterateList(numbers); // calls the iterate method
        double get500K = getList(numbers); // calls the get() method

        compareTimes(iterate500K, get500K, len); // calls the comparer method to display results.
    }
}
