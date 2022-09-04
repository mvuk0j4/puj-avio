package com.example.puj.controller;

import com.example.puj.Main;
import com.example.puj.model.Bookings;
import com.example.puj.model.Passanger;
import com.example.puj.model.Table;
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

public class ReservationFController implements Initializable {
    @FXML
    TableView reservationTbl;

    @FXML
    TableColumn reservationNameCol;

    @FXML
    TableColumn reservationSurnameCol;

    @FXML
    TableColumn reservationStartCol;

    @FXML
    TableColumn reservationDestinationCol;

    @FXML
    TextField nameTxt;

    @FXML
    TextField surnameTxt;

    @FXML
    TextField startTxt;

    @FXML
    TextField destinationTxt;

    @FXML
    Button addBtn;

    @FXML
    Button deleteBtn;

    @FXML
    Button gobackBtn;

    Bookings selectedReservation = null;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.reservationNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        this.reservationSurnameCol.setCellValueFactory(new PropertyValueFactory<>("surname"));
        this.reservationStartCol.setCellValueFactory(new PropertyValueFactory<>("start"));
        this.reservationDestinationCol.setCellValueFactory(new PropertyValueFactory<>("destination"));
        this.fillReservation();
    }

    private void fillReservation(){
        try {
            List<?> reservationList = Table.list(Bookings.class);
            ObservableList<?> reservationObservableList = FXCollections.observableList(reservationList);
            this.reservationTbl.setItems(reservationObservableList);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @FXML
    protected void addReservation(){
        String name = this.nameTxt.getText();
        String surname = this.surnameTxt.getText();
        String start = this.startTxt.getText();
        String destination = this.destinationTxt.getText();


        //if (this.selectedReservation == null)
            if (name.equals("") || surname.equals("") || start.equals("") || destination.equals("")) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Molimo unesite sve podatke!", ButtonType.OK);
                alert.setTitle("Upozorenje!!!");
                alert.setHeaderText("Neispravan unos podataka");
                alert.showAndWait();
            } else if (this.selectedReservation == null) {
                Bookings r = new Bookings();
                r.setName(name);
                r.setSurname(surname);
                r.setStart(start);
                r.setDestination(destination);
                try {
                    r.save();
                    this.nameTxt.setText("");
                    this.surnameTxt.setText("");
                    this.startTxt.setText("");
                    this.destinationTxt.setText("");
                    this.fillReservation();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }else {
                this.selectedReservation.setName(name);
                this.selectedReservation.setSurname(surname);
                this.selectedReservation.setStart(start);
                this.selectedReservation.setDestination(destination);
                try {
                    this.selectedReservation.update();
                    this.removeSelection();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
    }

    @FXML
    protected void selectReservation() {
        this.selectedReservation = (Bookings) this.reservationTbl.getSelectionModel().getSelectedItem();
        this.addBtn.setText("Uredi");
        //this.nameTxt.setText(this.selectedPassanger.getName());
        this.nameTxt.setText(this.selectedReservation.getName());
        this.surnameTxt.setText(this.selectedReservation.getSurname());
        this.startTxt.setText(this.selectedReservation.getStart());
        this.destinationTxt.setText(this.selectedReservation.getDestination());
    }

    @FXML
    protected void removeSelection(){
        this.selectedReservation = null;
        this.fillReservation();
        this.addBtn.setText("Dodaj");
        this.nameTxt.setText("");
        this.surnameTxt.setText("");
        this.startTxt.setText("");
        this.destinationTxt.setText("");
    }

    @FXML
    protected void deleteReservation(){
        if (selectedReservation != null){
            try {
                selectedReservation.delete();
                this.fillReservation();
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
