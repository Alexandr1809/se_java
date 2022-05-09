package com.example.autenawtoriz.osnownController;


import com.example.autenawtoriz.DBConnect;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private Button Button_login;

    @FXML
    private Button Button_perh;

    @FXML
    private AnchorPane pane_singup;

    @FXML
    private TextField tx_password;

    @FXML
    private TextField tx_username;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Button_login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!tx_username.getText().trim().isEmpty() && !tx_password.getText().trim().isEmpty() ){
                    DBConnect.logAwtoriz(event, tx_username.getText(),tx_password.getText());
                } else {
                    System.out.println("РЕГИСТРАЦИЯ");
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Введите логи и пароль");
                    alert.show();
                }

            }
        });

        Button_perh.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBConnect.formSc(event,"registr.fxml","РЕГИСТРАЦИЯ",null,null);
            }
        });
    }
}