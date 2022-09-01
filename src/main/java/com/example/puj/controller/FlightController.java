package com.example.puj.controller;

import com.example.puj.Main;
import com.example.puj.model.Flight;
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

public class FlightController implements Initializable {
    @FXML
    TextField startTxt;

    @FXML
    TextField destinationTxt;

    @FXML
    TextField priceTxt;

    @FXML
    Button addBtn;

    @FXML
    Button deleteBtn;

    @FXML
    Button gobackBtn;

    @FXML
    TableView flightTbl;

    @FXML
    TableColumn flightIDCol;

    @FXML
    TableColumn flightStartCol;

    @FXML
    TableColumn flightDestinationCol;

    @FXML
    TableColumn flightPriceCol;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
            this.flightIDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
            this.flightStartCol.setCellValueFactory(new PropertyValueFactory<>("start"));
            this.flightDestinationCol.setCellValueFactory(new PropertyValueFactory<>("destination"));
            this.flightPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
            this.fillFlights();
    }

    private void fillFlights(){
        try {
            List<?> flightList = Table.list(Flight.class);
            ObservableList<?> flightObservableList = FXCollections.observableList(flightList);
            this.flightTbl.setItems(flightObservableList);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    Flight selectedFlight = null;

    @FXML
    protected void addFlight(){
        String start = this.startTxt.getText();
        String destination = this.destinationTxt.getText();
        String price = this.priceTxt.getText();
        int price1 = Integer.parseInt(price);

        if (start.equals("") || destination.equals("") || price1 <= 0 || price.equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Molimo unesite sve podatke!", ButtonType.OK);
            alert.setTitle("Upozorenje!!!");
            alert.setHeaderText("Neispravan unos podataka");
            alert.showAndWait();
        } else if (selectedFlight == null) {
            Flight f = new Flight();
            f.setStart(start);
            f.setDestination(destination);
            f.setPrice(price1);
            try {
                f.save();
                this.startTxt.setText("");
                this.destinationTxt.setText("");
                this.priceTxt.setText("");
                this.fillFlights();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }else {
            this.selectedFlight.setStart(start);
            this.selectedFlight.setDestination(destination);
            this.selectedFlight.setPrice(price1);
            try {
                this.selectedFlight.update();
                //       this.removeSelection();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
    @FXML
    protected void deleteFlight(){
        if (selectedFlight != null){
            try {
                selectedFlight.delete();
                //     this.fillCategories();

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
