package com.ivanllc.ivanllc.controller;

import com.ivanllc.ivanllc.notification.Messages;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.util.Objects;

public class EmployeeServiceController {

    @FXML
    private Button btnDashboard;

    public void openDashboard(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) btnDashboard.getScene().getWindow();
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/ivanllc/ivanllc/admin-dashboard.fxml")));
            stage.setScene(new Scene(root, 900, 600));
            stage.setTitle("Employee Service ");
        } catch (Exception e) {
            e.printStackTrace();
            Messages.error("Unable to open dashboard");
        }
    }
}
