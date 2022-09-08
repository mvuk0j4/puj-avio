package com.example.puj.controller;

import com.example.puj.Main;
import com.example.puj.model.Table;
import com.example.puj.model.Passanger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class PassangerController implements Initializable {
    @FXML
    TextField nameTxt;

    @FXML
    TextField surnameTxt;

    @FXML
    TextField mailTxt;

   // @FXML
   // TextField typeTxt;
    @FXML
    Button gobackBtn;

    @FXML
    Button addBtn;

    @FXML
    Button deleteBtn;
    @FXML
    TableView passangerTbl;

    @FXML
    TableColumn passangerNameCol;

    @FXML
    TableColumn passangerSurnameCol;

    @FXML
    TableColumn passangerMailCol;

    @FXML
    TableColumn passangerIDCol;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.passangerNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        this.passangerSurnameCol.setCellValueFactory(new PropertyValueFactory<>("surname"));
        this.passangerMailCol.setCellValueFactory(new PropertyValueFactory<>("mail"));
        this.passangerIDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.fillPassangers();
    }

    private void fillPassangers() {
        try {
            List<?> passangerList = Table.list(Passanger.class);
            ObservableList<?> passangerObservableList = FXCollections.observableList(passangerList);
            this.passangerTbl.setItems(passangerObservableList);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    Passanger selectedPassanger = null;
    @FXML
    protected void addPassanger(){
        String name = this.nameTxt.getText();
        String surname = this.surnameTxt.getText();
        String mail = this.mailTxt.getText();
      //  String type = this.typeTxt.getText();

       // int type1= Integer.parseInt(type);

        if (name.equals("") || surname.equals("") || mail.equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Molimo unesite sve podatke!", ButtonType.OK);
            alert.setTitle("Upozorenje!!!");
            alert.setHeaderText("Neispravan unos podataka");
            alert.showAndWait();
        } else if (this.selectedPassanger == null) {
                Passanger p = new Passanger();
                p.setName(name);
                p.setSurname(surname);
                p.setMail(mail);
             //   p.setType(type1);
            try {
                p.save();
                this.nameTxt.setText("");
                this.surnameTxt.setText("");
                this.mailTxt.setText("");
            //    this.typeTxt.setText("");
                this.fillPassangers();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }else {
            this.selectedPassanger.setName(name);
            this.selectedPassanger.setSurname(surname);
            this.selectedPassanger.setMail(mail);
       //     this.selectedPassanger.setType(type1);
            try {
                this.selectedPassanger.update();
                this.removeSelection();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        }


    @FXML
    protected void selectPassanger(){
        this.selectedPassanger = (Passanger) this.passangerTbl.getSelectionModel().getSelectedItem();
        this.addBtn.setText("Uredi");
        this.nameTxt.setText(this.selectedPassanger.getName());
        this.surnameTxt.setText(this.selectedPassanger.getSurname());
        this.mailTxt.setText(this.selectedPassanger.getMail());
        //  int type1 = Integer.parseInt(this.typeTxt.getText());
        // this.typeTxt.setText(Integer.toString(type1));
    }

    @FXML
    protected void removeSelection(){
        this.fillPassangers();
        this.selectedPassanger = null;
        this.addBtn.setText("Dodaj");
        this.nameTxt.setText("");
        this.surnameTxt.setText("");
        this.mailTxt.setText("");
        // this.typeTxt.setText("");

    }
    @FXML
    protected void deletePassanger(){
        if (selectedPassanger != null){
            try {
                selectedPassanger.delete();
                this.fillPassangers();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }



    @FXML
    protected void goBack(){
        try {
            Main.showWindow(
                    "menu.fxml",
                    "Izbornik", 610, 400);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
