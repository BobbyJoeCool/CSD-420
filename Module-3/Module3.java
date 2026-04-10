/**
 * Module3 class demonstrates removing duplicates from an ArrayList of Integers.
 * 
 * @author Robert Breutzmann
 * CSD 420 - Advanced Java Programming
 * Assignment 3.2
 * Due Date: 4/12/2026
 */

import java.util.ArrayList;

public class Module3 {
    /**
     * Removes duplicate elements from the given ArrayList of Integers.
     * 
     * @param list the ArrayList from which duplicates are to be removed
     * @return a new ArrayList containing unique elements from the input list
     */
    private static ArrayList<Integer> removeDuplicates(ArrayList<Integer> list) {
        ArrayList<Integer> result = new ArrayList<>();  // Creates a blank ArrayList of Integers.
        for (Integer num : list) { // ForEach loop of the list passed to the method
            if (!result.contains(num)) { // Checks if the number is NOT in the "blank" list
                result.add(num); // If the number is not present, add it.
            }
        }

        return result;
    }


    /**
     * The main method that demonstrates the removeDuplicates functionality.
     * It creates a list with random integers, prints the original, removes duplicates, and prints the result.
     * 
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<>();

        // For loop generates 50 random numbers from 1-20 and inserts them into the ArrayList<Integer>
        for (int i = 1; i <= 50; i ++) {
            arr.add((int)(Math.random()*20) + 1);
        }

        System.out.println("Original List: " + arr);  // Prints original List
        ArrayList<Integer> newArr = removeDuplicates(arr);  // removes duplicates using function
        System.out.println("New List: " + newArr);  // Prints modified list without the duplicates
    }
}
