/**
 * 
 * @author Robert Breutzmann
 * CSD 420 - Advanced Java Programming
 * Assignment 5.2: Due 4-19-2026
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Module5 {
    /**
     * Loads words from the named text file into a set, automatically removing duplicates.
     *
     * @param fileName the name of the text file that contains one word or phrase per line
     * @return a set containing each non-empty word from the file exactly once
     */
    public static Set<String> loadWords(String fileName) {
        Set<String> words = new HashSet<>(); // Using a set automatically removes duplicates

        // try with resources to get each line from the text document.
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = reader.readLine()) != null) { // While loop reads if there is another line.
                line = line.trim(); // Remove whitespace from the line

                // skip empty lines if any
                if (!line.isEmpty()) {
                    words.add(line);
                }
            }

        } catch (IOException e) { // Prints an exception if the file doesn't exist.
            System.out.println("Error reading file: " + e.getMessage());
        }

        return words;
    }

    /**
     * Prints all words from the provided list, one entry per line.
     *
     * @param list the list of words to print
     */
    private static void printWords(ArrayList<String> list) {
        for (String word : list) {
            System.out.println(word);
        }
    }

    /**
     * Prints a horizontal separator line to improve output readability.
     */
    private static void printSpacer() {
        System.out.println("-".repeat(30));
    }

    /**
     * The program entry point. Reads the default word file, sorts the unique words alphabetically,
     * prints them, then prints the same words in reverse alphabetical order.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        String fileName = "collection_of_words.txt"; // stores the filename as a variable

        // These two lines were for debugging when I couldn't get the file to load.  Terminal was in one directory but the file in another.
        // System.out.println(System.getProperty("user.dir"));
        // System.out.println(fileName);

        Set<String> wordSet = loadWords(fileName); // Creates a set using the "loadWords" method.

        ArrayList<String> wordList = new ArrayList<>(wordSet);  // Create a list from the set for easier sorting.

        // Sorts the list Alphabetically, prints spacers and a title, then the list.
        wordList.sort(Comparator.naturalOrder());
        printSpacer();
        System.out.println("List ordered Alphabetically:");
        printSpacer();
        printWords(wordList);
        
        System.out.println();

        // Reverses the list, prints spacers and a title, then the list.
        wordList.sort(Comparator.reverseOrder());
        printSpacer();
        System.out.println("List ordered reverse Alphabetically:");
        printSpacer();
        printWords(wordList);
    }
}
