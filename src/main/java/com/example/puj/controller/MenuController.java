package com.example.puj.controller;

import com.example.puj.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {
    @FXML
    Button reservationBtn;
    @FXML
    Button passangerBtn;
    @FXML
    Button planeBtn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    protected void openReservation() throws IOException {
        Main.showWindow(
                "reservation.fxml",
                "Rezervacije", 600, 215);

    }
    @FXML
    protected void openPlane() throws IOException {
        Main.showWindow(
                "plane.fxml",
                "Avioni", 600, 215);

    }
    @FXML
    protected void openPassanger() throws IOException {
        Main.showWindow(
                "passanger.fxml",
                "Putnici", 600, 215);

    }

}
