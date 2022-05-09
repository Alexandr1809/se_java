package com.example.autenawtoriz.osnownController;


import com.example.autenawtoriz.DBConnect;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class RegistrController implements Initializable {


    @FXML
    private Button Button_registr;

    @FXML
    private Button Button_wozwr;

    @FXML
    private RadioButton rb_Admin;

    @FXML
    private RadioButton rb_Moderator;

    @FXML
    private RadioButton rb_User;

    @FXML
    private TextField tx_password;

    @FXML
    private TextField tx_username;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ToggleGroup toggleGroup = new ToggleGroup();
        rb_Admin.setToggleGroup(toggleGroup);
        rb_Moderator.setToggleGroup(toggleGroup);
        rb_User.setToggleGroup(toggleGroup);

        rb_User.setSelected(true);

        Button_registr.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               String togg = ((RadioButton) toggleGroup.getSelectedToggle()).getText();

               if (!tx_username.getText().trim().isEmpty() && !tx_password.getText().trim().isEmpty()){
                   DBConnect.regCon(event,tx_username.getText(),tx_password.getText(),togg);
               } else {
                   System.out.println("РЕГИСТРАЦИЯ НЕ ПРОШЛА");
                   Alert alert = new Alert(Alert.AlertType.ERROR);
                   alert.setContentText("Введите Логин и Пароль");
                   alert.show();
               }
            }
        });
        Button_wozwr.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                DBConnect.formSc(event,"glawni.fxml","АВТОРИЗАЦИЯ",null,null);
            }
        });
    }
}
