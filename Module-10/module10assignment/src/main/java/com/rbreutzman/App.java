package com.rbreutzman;

/**
 * @author Robert Breutzmann
 * CSD 420 - Advanced Java Programming
 * Assignment 10.2
 * Due Date - May 17th, 2026
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Fan Database Viewer — a single-file JavaFX application that reads and updates
 * fan records stored in a MySQL database.
 *
 * <p>The "fans" table must already exist with the following schema:
 * <pre>
 *   ID           INT          PRIMARY KEY
 *   firstname    VARCHAR(25)
 *   lastname     VARCHAR(25)
 *   favoriteteam VARCHAR(25)
 * </pre>
 *
 * <p>Run with: {@code mvn clean javafx:run}
 */
public class App extends Application {

    // JDBC connection details 
    static final String DB_URL  = "jdbc:mysql://localhost:3306/databasedb";
    static final String DB_USER = "student1";
    static final String DB_PASS = "pass";

    // UI input / output fields — initialized here so they are ready before start()
    private final TextField idField        = new TextField();
    private final TextField firstNameField = new TextField();
    private final TextField lastNameField  = new TextField();
    private final TextField teamField      = new TextField();
    private final Label     statusLabel    = new Label(); // feedback line shown below the buttons

    // -------------------------------------------------------------------------
    // JavaFX UI
    // -------------------------------------------------------------------------

    /**
     * Builds and displays the main application window.
     * Called automatically by the JavaFX runtime after {@code launch()} is invoked.
     *
     * @param stage the primary window provided by the JavaFX runtime
     */
    @Override
    public void start(Stage stage) {
        // GridPane lays out the labels and text fields in a two-column table
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setHgap(10); // horizontal gap between columns
        grid.setVgap(8);  // vertical gap between rows

        // Add label-field pairs — column 0 = label, column 1 = text field
        grid.add(new Label("ID:"),             0, 0); grid.add(idField,        1, 0);
        grid.add(new Label("First Name:"),     0, 1); grid.add(firstNameField, 1, 1);
        grid.add(new Label("Last Name:"),      0, 2); grid.add(lastNameField,  1, 2);
        grid.add(new Label("Favorite Team:"),  0, 3); grid.add(teamField,      1, 3);

        // Create action buttons and wire them to their handler methods
        Button displayBtn = new Button("Display");
        Button updateBtn  = new Button("Update");
        displayBtn.setOnAction(e -> handleDisplay());
        updateBtn.setOnAction(e  -> handleUpdate());

        // Stack the grid, button row, and status label vertically
        VBox root = new VBox(10, grid, new HBox(10, displayBtn, updateBtn), statusLabel);
        root.setPadding(new Insets(10));

        stage.setTitle("Fan Database Viewer");
        stage.setScene(new Scene(root, 380, 230));
        stage.show();
    }

    /**
     * Handles the Display button click.
     * Reads the ID field, fetches the matching row from the database, and
     * populates the remaining fields with the retrieved values.
     * Shows a status message if the ID is missing, invalid, or not found.
     */
    private void handleDisplay() {
        try {
            // Parse the ID the user typed; throws NumberFormatException if non-numeric
            int id = Integer.parseInt(idField.getText().trim());

            Fan fan = getRecord(id); // query the database for this ID

            if (fan != null) {
                // Populate the display fields with the data from the database
                firstNameField.setText(fan.firstname());
                lastNameField.setText(fan.lastname());
                teamField.setText(fan.favoriteTeam());
                statusLabel.setText("Record loaded.");
            } else {
                statusLabel.setText("No record found for ID " + id + ".");
            }
        } catch (NumberFormatException e) {
            // ID field was blank or contained non-integer text
            statusLabel.setText("Enter a valid integer ID.");
        } catch (SQLException e) {
            statusLabel.setText("DB error: " + e.getMessage());
        }
    }

    /**
     * Handles the Update button click.
     * Reads all four fields from the UI and writes them back to the database
     * row matching the given ID.  The record must already exist — this method
     * does not insert new rows.
     */
    private void handleUpdate() {
        try {
            int id = Integer.parseInt(idField.getText().trim());

            // Build a Fan object from whatever the user has typed in the fields
            Fan fan = new Fan(id, firstNameField.getText(), lastNameField.getText(), teamField.getText());

            boolean ok = updateRecord(fan); // returns true if a row was changed
            statusLabel.setText(ok ? "Record updated." : "No record found to update.");
        } catch (NumberFormatException e) {
            statusLabel.setText("Enter a valid integer ID.");
        } catch (SQLException e) {
            statusLabel.setText("DB error: " + e.getMessage());
        }
    }

    // -------------------------------------------------------------------------
    // Database helpers
    // -------------------------------------------------------------------------

    /**
     * Opens and returns a new JDBC connection to the database.
     * The caller is responsible for closing the connection (use try-with-resources).
     *
     * @return an open {@link Connection}
     * @throws SQLException if the driver cannot connect with the given credentials
     */
    static Connection getConnection() throws SQLException {
        // DriverManager looks up the correct driver from those registered on the classpath
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
    }

    /**
     * Fetches a single fan record from the database by primary key.
     *
     * @param id the primary key to look up
     * @return a {@link Fan} if found, or {@code null} if no row has that ID
     * @throws SQLException if the query fails
     */
    static Fan getRecord(int id) throws SQLException {
        String sql = "SELECT ID, firstname, lastname, favoriteteam FROM fans WHERE ID = ?";

        // try-with-resources closes both the Connection and PreparedStatement automatically
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id); // bind the ID parameter — avoids SQL injection

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                // Map the result row to a Fan record and return it
                return new Fan(rs.getInt("ID"), rs.getString("firstname"),
                        rs.getString("lastname"), rs.getString("favoriteteam"));
            }
        }
        return null; // no row matched the given ID
    }

    /**
     * Updates an existing fan record in the database.
     * Only the three name/team columns are changed; the ID is used as the key.
     *
     * @param fan the updated fan data (ID must match an existing row)
     * @return {@code true} if one row was updated, {@code false} if no row matched
     * @throws SQLException if the update fails
     */
    static boolean updateRecord(Fan fan) throws SQLException {
        String sql = "UPDATE fans SET firstname=?, lastname=?, favoriteteam=? WHERE ID=?";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            // Bind fields in the same order they appear in the SQL string above
            ps.setString(1, fan.firstname());
            ps.setString(2, fan.lastname());
            ps.setString(3, fan.favoriteTeam());
            ps.setInt(4, fan.id());

            // executeUpdate() returns the number of rows affected; 1 means success
            return ps.executeUpdate() > 0;
        }
    }

    // -------------------------------------------------------------------------
    // Fan record
    // -------------------------------------------------------------------------

    /**
     * Immutable data holder for one row of the "fans" table.
     * Java records auto-generate the constructor, accessors, equals, hashCode, and toString.
     *
     * @param id           primary key
     * @param firstname    fan's first name
     * @param lastname     fan's last name
     * @param favoriteTeam the fan's favorite sports team
     */
    record Fan(int id, String firstname, String lastname, String favoriteTeam) {
        /** Returns a human-readable representation useful for test output. */
        @Override public String toString() {
            return "Fan{id=" + id + ", firstname='" + firstname + "', lastname='" + lastname
                    + "', favoriteTeam='" + favoriteTeam + "'}";
        }
    }

    // -------------------------------------------------------------------------
    // Tests  (run before the JavaFX window opens so output is visible in console)
    // -------------------------------------------------------------------------

    /**
     * Entry point for all self-tests.  Called from {@code main()} before the
     * JavaFX window is shown so that results appear in the console first.
     */
    static void runTests() {
        System.out.println("=== Running Tests ===");
        testConnection();
        testGetRecord();
        testUpdateRecord();
        System.out.println("=== Tests Complete ===\n");
    }

    /**
     * Verifies that a JDBC connection can be established with the configured credentials.
     * Prints PASS if successful, FAIL with the error message otherwise.
     */
    static void testConnection() {
        try (var _ = getConnection()) { // open and immediately close — just verifying credentials work
            pass("testConnection: connected to " + DB_URL);
        } catch (SQLException e) {
            fail("testConnection: " + e.getMessage());
        }
    }

    /**
     * Verifies that {@link #getRecord(int)} can retrieve a record from the database.
     * Uses ID 1, which is expected to exist in a pre-populated table.
     * Prints INFO (not FAIL) when the row is absent, because the table may be empty
     * in a local development environment.
     */
    static void testGetRecord() {
        try {
            Fan fan = getRecord(1);
            if (fan != null) {
                pass("testGetRecord: retrieved " + fan);
            } else {
                // Not a hard failure — the table may simply have no row with ID 1 locally
                info("testGetRecord: ID 1 not present in table (no record to display)");
            }
        } catch (SQLException e) {
            fail("testGetRecord: " + e.getMessage());
        }
    }

    /**
     * Verifies that {@link #updateRecord(Fan)} writes changes to the database and
     * that the changes can be read back.  The test saves the original values, applies
     * a temporary change, confirms it, then restores the original data so the table
     * is left unchanged after the test run.
     */
    static void testUpdateRecord() {
        try {
            Fan original = getRecord(1);
            if (original == null) {
                info("testUpdateRecord: skipped — no record with ID 1");
                return;
            }

            // Write temporary test values to the row
            Fan modified = new Fan(1, "TestFirst", "TestLast", "TestTeam");
            boolean updated = updateRecord(modified);
            if (!updated) { fail("testUpdateRecord: update returned false"); return; }
            pass("testUpdateRecord: record updated to " + modified);

            // Restore the original row and verify the round-trip was lossless
            updateRecord(original);
            Fan restored = getRecord(1);
            boolean match = restored != null
                    && restored.firstname().equals(original.firstname())
                    && restored.lastname().equals(original.lastname())
                    && restored.favoriteTeam().equals(original.favoriteTeam());
            if (match) pass("testUpdateRecord: original values restored");
            else        fail("testUpdateRecord: restore mismatch — got " + restored);

        } catch (SQLException e) {
            fail("testUpdateRecord: " + e.getMessage());
        }
    }

    // Shorthand print helpers for test output readability
    private static void pass(String msg) { System.out.println("  PASS  " + msg); }
    private static void fail(String msg) { System.out.println("  FAIL  " + msg); }
    private static void info(String msg) { System.out.println("  INFO  " + msg); }

    // -------------------------------------------------------------------------
    // Entry point
    // -------------------------------------------------------------------------

    /**
     * Application entry point.
     * Runs the self-tests first (console output), then launches the JavaFX window.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        runTests(); // print test results to console before the window appears
        launch();   // hand control to the JavaFX runtime, which calls start()
    }
}
