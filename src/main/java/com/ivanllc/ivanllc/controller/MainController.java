package com.ivanllc.ivanllc.controller;

import com.ivanllc.ivanllc.dao.UserDAOImpl;
import com.ivanllc.ivanllc.entity.User;
import com.ivanllc.ivanllc.notification.Messages;
import com.ivanllc.ivanllc.service.UserService;
import com.ivanllc.ivanllc.service.UserServiceImpl;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.Objects;

public class MainController {
    UserDAOImpl userDAO = new UserDAOImpl();



    UserService service = new UserServiceImpl(userDAO);

    @FXML
    TextField txt_email;

    @FXML
    PasswordField txt_password;

    @FXML
    Button btn_register;

    @FXML
    Button btn_login;

    @FXML
    public void openNewRegistration() {
        try {

            Stage stage = (Stage) btn_register.getScene().getWindow();
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/ivanllc/ivanllc/register-user.fxml")));
            stage.setScene(new Scene(root, 700, 500));
            stage.setTitle("User Registration");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void userLogin() {
        String email = txt_email.getText() == null ? "" : txt_email.getText().trim();
        String password = txt_password.getText();

        User user;
        try {
            user = service.authUser(email, password);
        } catch (RuntimeException e) {
            Messages.error("Unable to log in right now. Please try again.");
            return;
        }
        if (user == null) {
            Messages.error("Invalid login details");
            return;
        }

        String role = user.getUserRole() == null ? "" : user.getUserRole().trim();
        if ("Admin".equalsIgnoreCase(role)) {
            openDashboard("/com/ivanllc/ivanllc/admin-dashboard.fxml", "Admin Dashboard");
            return;
        }

        if ("Customer".equalsIgnoreCase(role)) {
            openDashboard("/com/ivanllc/ivanllc/customer-dashboard.fxml", "Customer Dashboard");
            return;
        }

        Messages.error("Unknown user role: " + role);
    }

    private void openDashboard(String fxmlPath, String title) {
        try {
            Stage stage = (Stage) btn_login.getScene().getWindow();
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxmlPath)));
            stage.setScene(new Scene(root, 900, 600));
            stage.setTitle(title);
        } catch (Exception e) {
            e.printStackTrace();
            Messages.error("Unable to open dashboard");
        }
    }
}
