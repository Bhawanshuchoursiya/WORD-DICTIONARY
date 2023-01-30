package com.example.dictionary;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import java.lang.*;
import javafx.scene.control.TextInputControl;

import java.io.IOException;
import java.util.*;

public class DictionaryPageController {
    private DictionarySaver db;
    @FXML
    TextField search;
    @FXML
    TextField newword;
    @FXML
    TextField meaning;
    @FXML
    TextField findword;

    @FXML
    public void searchbutton(MouseEvent event) throws ClassNotFoundException {

        try {
            db = new DictionarySaver();
            //db.serializeHashMap();
            db.deserializeHashMap();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Dictionary");
            if (search.getText().equals("")) {
                alert.setContentText("Please enter a word to search");
                alert.showAndWait();
            }
            if (db.getDictionaryList().containsKey(search.getText())) {
                alert.setContentText("The word is available in dictionary");
                alert.showAndWait();
            } else
                alert.setContentText("The word is not available in dictionary");
            alert.showAndWait();
            // System.out.println("Button is clicked");
            // System.out.println(search.getText());
        } catch (IOException ex) {
            db.serializeHashMap();
            System.out.println("Exception resolved");
        }
    }
    @FXML
    public void Add(MouseEvent event) throws IOException, ClassNotFoundException {
        db = new DictionarySaver();
        db.deserializeHashMap();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Dictionary");
        if (newword.getText().equals("") || meaning.getText().equals(" ")) {
            alert.setContentText("please enter word/meaning to add to the dictionary");
            alert.showAndWait();
        }
        else if (db.getDictionaryList().containsKey(newword.getText().toLowerCase())){
            alert.setContentText("The word is already available in the dictionary");
            alert.showAndWait();
        }
        else {
            db.getDictionaryList().put(newword.getText(),meaning.getText());
            db.serializeHashMap();
            alert.setContentText("New word is added to dictionary");
            alert.showAndWait();
            //System.out.println("Button is clicked");
           // System.out.println(search.getText());
        }
    }

    @FXML
    public void Meaning(MouseEvent event) throws IOException, ClassNotFoundException {
        db = new DictionarySaver();
        db.deserializeHashMap();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Meaning");
        if (findword.getText().equals("")) {
            alert.setContentText("Please enter a word to find meaning");
            alert.showAndWait();
        }

        else if (db.getDictionaryList().containsKey(findword.getText())) {
            // System.out.println(db.getDictionaryList().get(findword.getText()));
            alert.setContentText(db.getDictionaryList().get(findword.getText().toLowerCase()).toString());
            alert.showAndWait();
        }
        //  System.out.println("Button is clicked");
        // System.out.println(search.getText());
        else {
            alert.setContentText("The word is not available in the dictionary");
            alert.showAndWait();
        }
    }
}
