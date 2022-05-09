package com.example.autenawtoriz;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminController implements Initializable {

    @FXML
    private Button Button_1;

    @FXML
    private Button Button_2;

    @FXML
    private Button Button_3;

    @FXML
    private Button Button_4;

    @FXML
    private Button Button_5;

    @FXML
    private Button Button_wozwr;

    @FXML
    private Button Button_zapis;

    @FXML
    private ListView<String> List_text;

    @FXML
    private TextArea arri;

    @FXML
    private TextField tx_text1;

    ObservableList<String> list = FXCollections.observableArrayList();
    File adr = new File("C:\\Users\\User\\Desktop");

    File fild;


    void readFile(){
        try {
            FileReader fr = new FileReader(adr + "\\AutenAwtoriz.txt");
            System.err.println("file1");
        } catch (FileNotFoundException e) {
            try {
                FileWriter fw = new FileWriter(adr + "\\AutenAwtoriz.txt");
                System.out.println("ФАЙЛ СОЗДАН");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    void del(){

        if (fild != null) {
            fild.delete();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("введите Адрес Файла");
            alert.show();
        }

    }

    void addData(){

        String txt = arri.getText();

        try {
            RandomAccessFile rd = new RandomAccessFile(adr+"\\AutenAwtoriz.txt", "rw");
            rd.writeBytes(" "+txt);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Button_1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                readFile();
            }
        });






        Button_wozwr.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                DBConnect.formSc(event,"glawni.fxml","АВТОРИЗАЦИЯ",null,null);
            }
        });
    }





    public void Butt_zapis(ActionEvent event) {
        addData();
    }

    public void Button_otkr(ActionEvent event) {
        Node sour = (Node) event.getSource();
        Stage stage = (Stage) sour.getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter tXF = new FileChooser.ExtensionFilter("TXT (*.txt)","*.txt");
        fileChooser.getExtensionFilters().add(tXF);
        fileChooser.getExtensionFilters().addAll(tXF);
        fileChooser.setTitle("Выбор файла");

        fild = fileChooser.showOpenDialog(stage);
        try {
            tx_text1.setText(fild.getPath());
        } catch (Exception e){

        }
    }

    public void Button_zagrus(ActionEvent event) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fild),"cp1251"));
            String line = reader.readLine();
            list.add(line);

            while (line != null){
                line = reader.readLine();
                if (line != null){
                    list.add(line);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
                 List_text.setItems(list);
    }

    public void Button_delet(ActionEvent event) {
        del();
    }
}
