/**
 * @author Robert Breutzmann
 * CSD 420 - Advanced Java Programming
 * Assignment 6.2 - Due: April 26th, 2026
 * 
 * Generic bubble sort demonstrating:
 * - <E extends Comparable<E>>: E must implement Comparable (has compareTo method)
 * - <E> with Comparator<? super E>: E can be any type, Comparator provides comparison logic
 */

import java.util.Arrays;
import java.util.Comparator;

public class Mod_6_Assignment {

    /**
     * Sorts using natural ordering. E must implement Comparable<E>.
     * @param <E> type must be Comparable (e.g., Integer, String)
     */
    public static <E extends Comparable<E>> void bubbleSort(E[] list) {
    
        boolean swapped;

        // Outer loop: number of passes through the array
        // After each pass, the largest unsorted element bubbles to the end
        for (int i = 0; i < list.length - 1; i++) {
            swapped = false;

            // Inner loop: compare adjacent elements and swap if out of order
            // -i optimization: elements at end are already sorted from previous passes
            for (int j = 0; j < list.length - 1 - i; j++) {
                // If current element is greater than next, swap them
                // compareTo returns positive when list[j] > list[j+1]
                if (list[j].compareTo(list[j + 1]) > 0) {
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    swapped = true;
                }
            }
            // Optimization: if no swaps occurred, array is already sorted
            if (!swapped) break;
        }
    }

    /**
     * Sorts using custom Comparator. E can be any type.
     * @param <E> any type
     * @param comparator defines comparison logic
     */
    public static <E> void bubbleSort(E[] list, Comparator<? super E> comparator) {
        boolean swapped;

        // Outer loop: number of passes through the array
        for (int i = 0; i < list.length - 1; i++) {
            swapped = false;

            // Inner loop: compare adjacent elements using comparator
            for (int j = 0; j < list.length - 1 - i; j++) {
                // If first element is greater than second (per comparator), swap
                if (comparator.compare(list[j], list[j + 1]) > 0) {
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    swapped = true;
                }
            }
            // Optimization: if no swaps occurred, array is already sorted
            if (!swapped) break;
        }
    }

    public static void main(String[] args) {

        // TEST 1: Comparable (Integers) 
        Integer[] numbers = {5, 2, 9, 1, 5, 6};
        bubbleSort(numbers);
        System.out.println("Sorted Integers (Comparable): " + Arrays.toString(numbers));

        // TEST 2: Comparable (Strings) 
        String[] words = {"banana", "apple", "cherry", "date"};
        bubbleSort(words);
        System.out.println("Sorted Strings (Comparable): " + Arrays.toString(words));

        // TEST 3: Comparator (Descending Integers) 
        Integer[] numbersDesc = {5, 2, 9, 1, 5, 6};
        bubbleSort(numbersDesc, (a, b) -> b - a);
        System.out.println("Sorted Integers (Descending Comparator): " + Arrays.toString(numbersDesc));

        // TEST 4: Comparator (String length)
        String[] wordsByLength = {"banana", "apple", "cherry", "date"};
        bubbleSort(wordsByLength, Comparator.comparingInt(String::length));
        System.out.println("Sorted Strings (By Length Comparator): " + Arrays.toString(wordsByLength));
    }
}