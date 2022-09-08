package com.example.puj.controller;

import com.example.puj.Main;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import com.example.puj.model.Employer;
import com.example.puj.model.Database;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController {
    @FXML
    private Label errorMsg;

    @FXML
    private TextField usernameTxt;

    @FXML
    private PasswordField passwordTxt;

    @FXML
    protected void onLogin() throws IOException {
        String name = this.usernameTxt.getText();
        String surname = this.passwordTxt.getText();

        if (name.equals("") || surname.equals("")){
            this.errorMsg.setText("Morate unijeti sva polja!");
        } else {
            try {
                PreparedStatement query = Database.CONNECTION.prepareStatement("SELECT * FROM Employer WHERE name=? AND surname=?");
                query.setString(1,usernameTxt.getText());
                query.setString(2,passwordTxt.getText());
                ResultSet rs = query.executeQuery();

                if (rs.next()){
                    this.errorMsg.setText("");
                    Main.showWindow(
                            "menu.fxml",
                            "Izbornik ", 610, 400);
                } else {
                    Alert alert = new Alert(Alert.AlertType.WARNING, "Pogrešan unos!!", ButtonType.OK);
                    alert.setTitle("Upozorenje");
                    alert.setHeaderText("Error");
                    alert.showAndWait();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        }
    }
}