package com.spotify.mini;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SpotifyMiniApp


extends Application {

    @Override
    public void start(Stage stage) {
        Label titulo = new Label("Spotify Mini 🎧");
        VBox root = new VBox(titulo);
        Scene scene = new Scene(root, 600, 450);

        stage.setTitle("Spotify Mini");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
