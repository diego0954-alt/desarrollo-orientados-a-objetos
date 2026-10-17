package com.spotify.mini;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SpotifyApp extends Application{

    @Override
    public void start(Stage mama) throws Exception {

        Label nombre = new Label("wuapo");
        Label carrera = new Label("samame");
        TextField caja = new TextField();
        Button boton = new Button("precionar para confirmra");
        

        VBox aplication = new VBox(10, nombre, carrera, caja, boton);


        boton.setOnAction(e -> {
            Label saludo = new Label(caja.getText());
            aplication.getChildren().add(saludo);
        });

        Scene scene = new Scene(aplication, 400, 250);

        mama.setScene(scene);
        mama.setTitle("para una persona ");
        mama.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
