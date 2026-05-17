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

public class RegisterUserController {
    @FXML
    private TextField txt_email;

    @FXML
    private PasswordField txt_password;

    @FXML
    private Button btn_login;

    @FXML
    private Button btn_register;

    UserDAOImpl userDAO = new UserDAOImpl();

    UserService userService = new UserServiceImpl(userDAO);

    @FXML
    public void registerUser() {
        String email = txt_email.getText() == null ? "" : txt_email.getText().trim();
        String password = txt_password.getText();

        User user = new User();
        user.setUserRole("Customer");
        user.setEmail(email);
        user.setPassword(password);

        try {
            userService.registerUser(user);
            Messages.info("Registration successful");
        } catch (RuntimeException e) {
            if ("Email already exists".equalsIgnoreCase(e.getMessage())) {
                Messages.error("Email already exists");
                return;
            }
            Messages.error("Unable to register user. Check your details and try again.");
        }


    }

    @FXML
    public void openLoginPage() {
        try {

            Stage stage = (Stage) btn_login.getScene().getWindow();
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/ivanllc/ivanllc/main.fxml")));
            stage.setScene(new Scene(root, 700, 500));
            stage.setTitle("Login page");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
