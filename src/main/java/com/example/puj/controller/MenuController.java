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
    Button passangerBtn;

    @FXML
    Button flightBtn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }



    @FXML
    protected void openPassanger() throws IOException {
        Main.showWindow(
                "passanger.fxml",
                "Putnici", 610, 400);

    }

    @FXML
    protected void openFlight() throws IOException {
        Main.showWindow(
                "flight.fxml",
                "Letovi",610,400
        );
    }

}
