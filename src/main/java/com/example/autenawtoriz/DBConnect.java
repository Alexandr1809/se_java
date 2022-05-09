package com.example.autenawtoriz;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class DBConnect {

    public static void formSc(ActionEvent event, String fxmlF, String title, String username, String password) {
        Parent root = null;

        try {
            FXMLLoader loader = new FXMLLoader(DBConnect.class.getResource(fxmlF));
            root = loader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle(title);
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }



    public static void regCon(ActionEvent event, String username, String password,String profil){
        Connection connection = null;
        PreparedStatement prow = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String conn = "jdbc:mysql://localhost:3306/sequrit";
        String userName = "root";
        String pass = "1809";

        String sqlProw = "SELECT profil FROM sequrit.autawt WHERE username=?";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(conn,userName,pass);
            System.out.println("DB CONNECT");
            prow = connection.prepareStatement(sqlProw);
            prow.setString(1,username);
            rs = prow.executeQuery();

            if (rs.isBeforeFirst()){
                System.out.println("СОЕДИНИЛИСЬ С БД");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Такой есть Логина и Пароля");
                alert.show();
            } else {
                String sqlIns = "INSERT INTO autawt(username,password,profil) VALUES(?,?,?)";

                ps = connection.prepareStatement(sqlIns);
                ps.setString(1,username);
                ps.setString(2,password);
                ps.setString(3,profil);
                ps.executeUpdate();
                System.out.println("РЕГИСТРАЦИЯ УСПЕШНА");

                    formSc(event,"glawni.fxml","ФВТОРИЗАЦИЯ",null,null);

                }
            } catch (Exception ex) {
            ex.printStackTrace();
        }


    }
    public static void logAwtoriz(ActionEvent event,String username,String password){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        String conn = "jdbc:mysql://localhost:3306/sequrit";
        String userName = "root";
        String pass = "1809";

        String sqlAut = "SELECT profil FROM sequrit.autawt WHERE username=? AND password=?";

        try {
            connection = DriverManager.getConnection(conn,userName,pass);
            System.out.println("DB CONNECT");
            preparedStatement = connection.prepareStatement(sqlAut);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            rs = preparedStatement.executeQuery();

            if (!rs.isBeforeFirst()){
                System.out.println("СОЕДИНИЛИСЬ С БД");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Такого нет Логина и Пароля");
                alert.show();
            } else {
                while (rs.next()){
                String prof =rs.getString("profil");
                formSc(event,prof+".fxml",prof,null,null);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null){

                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null){

                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
            if (connection != null){

                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }


        }

    }


}
