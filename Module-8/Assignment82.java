/**
 * @author Robert Breutzmann
 * CSD 420 - Advanced Java Programming
 * Assignment 8.2 - Multi-Threading
 * Due Date May 3rd, 2026.
 */

import java.util.Random;

/**
 * Shows basic multithreading with three worker threads.
 * Each thread prints 10,000 characters: letters, digits, or symbols.
 * The output is mixed together because the threads run at the same time.
 */
public class Assignment82 {

    static final int COUNT = 10000;


    /**
     * Defines the three worker threads and starts them together.
     * LETTERS, DIGITS, and SYMBOLS are built once at class load time.
     */
    static class RobertThreeThreads {

        // Lowercase letters a-z.
        static final char[] LETTERS = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        // Digits 0-9.
        static final char[] DIGITS = "0123456789".toCharArray();

        // Symbol characters: ! @ # $ % & *.
        static final char[] SYMBOLS = "!@#$%&*".toCharArray();

        // ----- Thread 1

        /**
         * Prints COUNT random lowercase letters.
         * Each letter is printed as soon as it is chosen.
         */
        static class LetterThread implements Runnable {
            private final Random rng = new Random();

            @Override
            public void run() {
                for (int i = 0; i < COUNT; i++) {
                    System.out.print(LETTERS[rng.nextInt(LETTERS.length)]);
                }
            }
        }

        // ----- Thread 2 

        /**
         * Prints COUNT random digits.
         */
        static class DigitThread implements Runnable {
            private final Random rng = new Random();

            @Override
            public void run() {
                for (int i = 0; i < COUNT; i++) {
                    System.out.print(DIGITS[rng.nextInt(DIGITS.length)]);
                }
            }
        }

        // ----- Thread 3 

        /**
         * Prints COUNT random symbols.
         */
        static class SymbolThread implements Runnable {
            private final Random rng = new Random();

            @Override
            public void run() {
                for (int i = 0; i < COUNT; i++) {
                    System.out.print(SYMBOLS[rng.nextInt(SYMBOLS.length)]);
                }
            }
        }

        // ----- Thread coordinator

        /**
         * Starts the three worker threads and waits for them to finish.
         *
         * @throws InterruptedException if the current thread is interrupted while waiting
         */
        public void run() throws InterruptedException {
            Thread t1 = new Thread(new LetterThread(), "LetterThread");
            Thread t2 = new Thread(new DigitThread(),  "DigitThread");
            Thread t3 = new Thread(new SymbolThread(), "SymbolThread");

            t1.start();
            t2.start();
            t3.start();

            t1.join();
            t2.join();
            t3.join();
        }
    }

    // -------------------------------------------------------------------------

    /**
     * Entry point for the program.
     * Starts the threads and waits for them to finish.
     *
     * @throws InterruptedException if the main thread is interrupted while waiting
     */
    public static void main(String[] _args) throws InterruptedException {

        System.out.println("Starting three threads — characters are interleaved as generated:");
        System.out.println("------------------------------------------------------------------");

        RobertThreeThreads rtt = new RobertThreeThreads();
        rtt.run();
    }
}
