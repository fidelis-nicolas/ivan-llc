package com.ivanllc.ivanllc.controller;

import com.ivanllc.ivanllc.entity.User;
import com.ivanllc.ivanllc.service.UserService;
import com.ivanllc.ivanllc.service.UserServiceImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class RegisterUserController {
    @FXML
    private TextField txt_email;

    @FXML
    private TextField txt_password;

    @FXML
    private Button btn_login;

    @FXML
    private Button btn_register;

    UserService userService = new UserServiceImpl();

    @FXML
    public void registerUser(){
        String email = txt_email.getText();
        String password = txt_password.getText();

        User user = new User();
        user.setUserRole("Customer");
        user.setEmail(email);
        user.setPassword(password);

        userService.registerUser(user);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Registration successful");
        alert.show();
    }
}
