package com.rbreutzmann;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage stage) {
        // Create a Pane
        Pane pane = new Pane();

        // Create Text in gold color
        Text text = new Text("Welcome to Bellevue University!");
        text.setFont(Font.font("Arial", 36));

        // Sets the pane to a Bellevue Purple and Text to Gold
        setSolidColor(pane, text);

        // Sets the pane with a Pride Flag and the Text to Black
        // setGradientColor(pane, text);

        // Position the text in the center
        text.setX(50);
        text.setY(100);

        // Add text to the pane
        pane.getChildren().add(text);

        // Create the scene and add the pane
        Scene scene = new Scene(pane, 600, 200);

        stage.setScene(scene);
        stage.setTitle("Bellevue Colors Example");
        stage.show();
    }

    private void setSolidColor(Pane pane, Text text) {
        pane.setStyle("-fx-background-color: #4F3674;"); // Bellevue Purple
        text.setFill(Color.web("#D6A800")); // Bellevue Gold
    }

    private void setGradientColor(Pane pane, Text text) {
        text.setFill(Color.BLACK);
        text.setStroke(Color.WHITE);  // Gives an outline for readability
        text.setStrokeWidth(1);

        Stop[] stops = new Stop[] {
            new Stop(0.0, Color.RED),
            new Stop(0.16, Color.ORANGE),
            new Stop(0.33, Color.YELLOW),
            new Stop(0.5, Color.GREEN),
            new Stop(0.66, Color.BLUE),
            new Stop(0.83, Color.INDIGO),
            new Stop(1.0, Color.VIOLET)
        };

        LinearGradient rainbowGradient = new LinearGradient(
                0, 0, 1, 0,   // horizontal gradient (left to right)
                true,
                CycleMethod.NO_CYCLE,
                stops
        );

        pane.setBackground(new Background(
                new BackgroundFill(rainbowGradient, null, null)
        ));
    }

    public static void main(String[] args) {
        launch();
    }
}