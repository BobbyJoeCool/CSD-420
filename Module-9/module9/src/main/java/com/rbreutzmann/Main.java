package com.rbreutzmann.module9;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import io.github.cdimascio.dotenv.Dotenv;

/**
 * Tests that the MySQL database created for Assignment 9.2 is reachable,
 * contains the expected database and table, and has data in it.
 *
 * Connection details (URL, username, password, table name) are loaded
 * from a .env file in the project root so they are not hardcoded here.
 *
 * @author Robert Breutzmann
 * CSD 420 - Advanced Java Programming
 * Assignment 9.2
 * Due: May 12th, 2026
 */
public class Main {

    // Load all values from the .env file once when the class is first used
    static final Dotenv dotenv = Dotenv.load();

    // Pull each connection setting out of the .env file by its key name
    static final String DB_URL = dotenv.get("DB_URL");
    static final String USER   = dotenv.get("DB_USER");
    static final String PASS   = dotenv.get("DB_PASS");
    static final String TABLE  = dotenv.get("DB_TABLE");

    /**
     * Entry point for the program. Runs through four checks in order:
     * connection, database existence, table existence, and row data.
     * Stops early and prints a FAIL message if any check does not pass.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String... args) {
        System.out.println("Starting database connection test...\n");

        // Try to open a connection to the database. The try-with-resources block
        // automatically closes the connection when we are done, even if an error occurs.
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            printSuccess("Connection to MySQL established");

            // DatabaseMetaData lets us ask the server questions about its structure
            // without running a regular SQL query
            DatabaseMetaData meta = conn.getMetaData();

            // Ask the server for a list of every database (catalog) it knows about,
            // then scan through the list looking for "databasedb"
            try (ResultSet dbs = meta.getCatalogs()) {
                boolean dbFound = false;
                while (dbs.next()) {
                    // TABLE_CAT is the column name the JDBC driver uses for the database (catalog) name
                    if ("databasedb".equalsIgnoreCase(dbs.getString("TABLE_CAT"))) {
                        dbFound = true;
                        break;
                    }
                }
                if (dbFound) {
                    printSuccess("Database 'databasedb' found");
                } else {
                    System.out.println("FAIL: Database 'databasedb' not found in catalog.");
                    return; // No point going further if the database is missing
                }
            }

            // Ask the server whether the expected table exists inside databasedb
            try (ResultSet tables = meta.getTables("databasedb", null, TABLE, new String[]{"TABLE"})) {
                if (tables.next()) {
                    printSuccess("Table '" + TABLE + "' found");
                } else {
                    System.out.println("FAIL: Table '" + TABLE + "' not found.");
                    return; // No point querying a table that does not exist
                }
            }

            // Run a SELECT * to fetch every row from the table
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery("SELECT * FROM " + TABLE)) {

                // Print a header row so the output is easy to read
                System.out.println("\n--- Contents of '" + TABLE + "' ---");
                System.out.printf("%-5s %-15s %-15s %-25s %-15s %-5s %-10s%n",
                        "ID", "LASTNAME", "FIRSTNAME", "STREET", "CITY", "STATE", "ZIP");
                System.out.println("-".repeat(95));

                // Walk through each row returned by the query and print its columns
                int rowCount = 0;
                while (rs.next()) {
                    rowCount++;
                    // Print each column of the current row, padded to fixed widths so the output lines up neatly
                    System.out.printf("%-5d %-15s %-15s %-25s %-15s %-5s %-10s%n",
                            rs.getInt("ID"),
                            rs.getString("LASTNAME"),
                            rs.getString("FIRSTNAME"),
                            rs.getString("STREET"),
                            rs.getString("CITY"),
                            rs.getString("STATE"),
                            rs.getString("ZIP"));
                }
                System.out.println();

                // Only report success if at least one row came back
                if (rowCount > 0) {
                    printSuccess("Table '" + TABLE + "' contains " + rowCount + " row(s) of data");
                } else {
                    System.out.println("WARNING: Table '" + TABLE + "' exists but contains no data.");
                }
            }

        } catch (SQLException e) {
            // Catches any database error — bad credentials, server not running, etc.
            System.out.println("FAIL: Connection error - " + e.getMessage());
        }
    }

    /**
     * Prints a success message to the console in a consistent format.
     * Call this whenever a check passes so all success output looks the same.
     *
     * @param message a short description of what succeeded
     */
    static void printSuccess(String message) {
        System.out.println("SUCCESS: " + message);
    }
}
