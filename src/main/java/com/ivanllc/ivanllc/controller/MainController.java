package com.ivanllc.ivanllc.controller;

import com.ivanllc.ivanllc.entity.User;
import com.ivanllc.ivanllc.notification.Messages;
import com.ivanllc.ivanllc.service.UserService;
import com.ivanllc.ivanllc.service.UserServiceImpl;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.Objects;

public class MainController {
    UserService service = new UserServiceImpl();

    @FXML
    TextField txt_email;

    @FXML
    PasswordField txt_password;

    @FXML
    Button btn_register;

    @FXML
    Button btn_login;

    @FXML
    public void openNewRegistration(){
        try {

            Stage stage = (Stage) btn_register.getScene().getWindow();
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/ivanllc/ivanllc/register-user.fxml")));
            stage.setScene(new Scene(root, 700, 500));
            stage.setTitle("User Registration");

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    public void userLogin(){
        String email = txt_email.getText();
        String password = txt_password.getText();

       // User user = service.authUser(email,password);
//        if(user != null) {
//            try {
//                Stage stage = (Stage) btn_register.getScene().getWindow();
//                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/ivanllc/ivanllc/admin-dashboard.fxml")));
//                stage.setScene(new Scene(root, 900, 600));
//                stage.setTitle("admin-dashboard");
//
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//
//        }
//        else{
//            Messages.error("Invalid login details");
//        }

    }
}