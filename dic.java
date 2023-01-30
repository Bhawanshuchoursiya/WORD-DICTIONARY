package com.example.dictionary;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

import static javafx.fxml.FXMLLoader.load;
public class dic {
   public AnchorPane root;
    dic() throws IOException{

        root = load(getClass().getResource("DictionaryPage.fxml"));
    }
}
