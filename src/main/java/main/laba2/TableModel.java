package main.laba2;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class TableModel {
    private String name;
    @FXML private TextField inputParam;


    TableModel(String name, TextField inputParam){
        this.name = name;
        this.inputParam = inputParam;
    }

    public String getName(){
        return name;
    }

    public void setName(String value){
        name = value;
    }

    public TextField getInputParam() {
        return inputParam;
    }

    public void setInputParam(TextField value) {
        inputParam = value;
    }
}
