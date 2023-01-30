package com.example.dictionary;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    public static Group root;
    @Override
    public void start(Stage stage) throws IOException {
        root = new Group();
       dic page = new dic();
       root.getChildren().add(page.root);
        Scene scene = new Scene(root, 500, 500);
        stage.setTitle("WORD DICTIONARY");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args){Launch(args);}

    private static void Launch(String[] args) {
    }
}