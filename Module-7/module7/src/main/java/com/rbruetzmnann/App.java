package com.rbruetzmnann;

/**
 * @author Robert Breutzmann
 * CSD 420 - Advanced Java Programming
 * Assignment 7.2 - MORE JavaFX
 * Due Date May 3rd, 2026
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class App extends Application {

    /**
     * The main entry point for the JavaFX application.
     * 
     * This method is called when the JavaFX application is started.
     * It creates the primary window (stage) and sets up the scene graph
     * with four circles and styling.
     * 
     * @param stage the primary window for this application
     * @throws Exception if an error occurs during application startup
     */
    @Override
    public void start(Stage stage) {
        
        // Create circles
        Circle c1 = new Circle(50);
        Circle c2 = new Circle(50);
        Circle c3 = new Circle(50);
        Circle c4 = new Circle(50);

        // Apply CSS class (white fill, black stroke)
        c1.getStyleClass().add("white-circle");
        c2.getStyleClass().add("white-circle");

        // Apply IDs for red and green
        c3.setId("red-circle");
        c4.setId("green-circle");

        // Create vertical rectangle box around first circle
        Rectangle box = new Rectangle(120, 500);
        box.getStyleClass().add("box-rectangle");

        // Wrap first circle in StackPane with rectangle behind it
        StackPane firstCirclePane = new StackPane();
        firstCirclePane.getChildren().addAll(box, c1);

        // Layout - center aligned
        HBox pane = new HBox(20);
        pane.setAlignment(javafx.geometry.Pos.CENTER);
        pane.getChildren().addAll(firstCirclePane, c2, c3, c4);

        // Scene - sized to show all circles properly
        Scene scene = new Scene(pane, 520, 620);

        // Load external CSS
        scene.getStylesheets().add(getClass().getResource("/com/rbruetzmnann/mystyle.css").toExternalForm());

        stage.setTitle("Exercise31_01");
        stage.setScene(scene);
        stage.show();
        
    }

    /**
     * The main method - entry point for the application.
     * 
     * This method launches the JavaFX application by calling the
     * static launch() method from the Application class.
     * 
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        launch();
    }
}

