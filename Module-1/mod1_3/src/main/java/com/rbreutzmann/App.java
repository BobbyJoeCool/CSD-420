/**
 * Robert Breutzmann
 * CSD 420: Advanced Java Programming
 * Due Date: March 29th, 2026
 * Assignment: Module 1.3: JavaFX Event Handling and Images.
 * 
 * Must be run with Maven.
 */

package com.rbreutzmann;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Main JavaFX application for Module 1.3.
 *
 * This app displays four random playing cards and includes a "Draw New Cards"
 * button that refreshes the displayed cards.
 */
public class App extends Application {

    /**
     * Called by the JavaFX runtime to initialize and show the main stage.
     *
     * @param stage the primary stage for this application
     */
    @Override
    public void start(Stage stage) {
        StackPane pane = new StackPane();
        pane.setStyle("-fx-background-color: #2e5a44;"); // Background Color set to a Casino Table color

        populatePane(pane);

        Scene scene = new Scene(pane, 350, 200);
        stage.setScene(scene);
        stage.setTitle("Module 1.3 Assignment");
        stage.show();
    }

    /**
     * Builds the UI components in the given root pane.
     *
     * @param pane root container to populate with controls and card images
     */
    private void populatePane(Pane pane) {

        // VBox holds the cardBox and the Button and centers them.
        VBox paneBox = new VBox(20);
        paneBox.setAlignment(Pos.CENTER);
        
        // HBox holds the cards and centers them.
        HBox cardBox = new HBox(10);
        cardBox.setAlignment(Pos.CENTER);
        
        // Shuffle Button to draw new cards, styled to look Gold to contrast the "Table"
        Button shuffle = new Button("Draw New Cards");
        shuffle.setStyle(
            "-fx-background-color: #d4af37; " +
            "-fx-text-fill: black; " +
            "-fx-font-weight: bold;" +
            "-fx-background-radius: 8; " +
            "-fx-padding: 8 16;"
        );

        // ImageView used to hold the cards to make them easier to change.
        ImageView card1 = new ImageView();
        ImageView card2 = new ImageView();
        ImageView card3 = new ImageView();
        ImageView card4 = new ImageView();

        setCard(card1);
        setCard(card2);
        setCard(card3);
        setCard(card4);

        // Add the objects to the appropriate boxes and the parent pane.
        cardBox.getChildren().addAll(card1, card2, card3, card4);
        paneBox.getChildren().addAll(cardBox, shuffle);
        pane.getChildren().add(paneBox);

        // Event handler for pressing the shuffle button, using a Lambda expression.
        shuffle.setOnAction(e -> shuffleButton(card1, card2, card3, card4));
}
    /**
     * Handles card shuffling by setting a new random card image for each ImageView.
     * Set cards MAY assign duplicate cards, since each card is selected independent of the others.
     *
     * @param card1 first card view
     * @param card2 second card view
     * @param card3 third card view
     * @param card4 fourth card view
     */
    private void shuffleButton(ImageView card1, ImageView card2, ImageView card3, ImageView card4) {
        setCard(card1);
        setCard(card2);
        setCard(card3);
        setCard(card4);
    }

    /**
     * Chooses a random card image and applies it to the provided ImageView.
     *
     * @param imageView ImageView to receive the random card image
     */
    private void setCard(ImageView imageView) {
        // generate a random number 1 -52
        int cardNumber = (int)(Math.random() * 52) + 1;

        // Use that random number to generate the pathway to the image
        String cardPath = "/cards/" + cardNumber + ".png";

        // Creates an image with the image path using the packages getResource
        Image image = new Image(
            getClass().getResource(cardPath).toExternalForm()
        );

        // Updates the ImageView with a new random card image.
        imageView.setImage(image);
    }

    /**
     * Java main entry point used when launching the application from the command line.
     *
     * @param args command-line arguments (ignored)
     */
    public static void main(String[] args) {
        launch();
    }

}