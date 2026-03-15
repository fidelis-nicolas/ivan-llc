package com.ivanllc.ivanllc;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException, SQLException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws SQLException {
        //launch();
        String username = "root";
        String password = "";
        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/ivanllc", username, password);
/*
        Scanner scanner = new Scanner(System.in);
        System.out.print("name: ");
        String name = scanner.next();

        System.out.print("email: ");
        String email = scanner.next();

        System.out.println("Phone Number: ");
        String phoneNumber = scanner.next();

        String sql = "INSERT INTO customer (customer_id, name, email, phone_number) VALUES(null, ?, ?, ?)";

        PreparedStatement statement = connect.prepareStatement(sql);
//        statement.setInt(1, );
        statement.setString(1, name);
        statement.setString(2, email);
        statement.setString(3, phoneNumber);

        int exec = statement.executeUpdate();
        System.out.println("Rows affected: " + exec);

        connect.close();



 */


        //Prone to SQL Injection
        Statement statement = connect.createStatement();
        String sql = "INSERT INTO customer (customer_id, name, email, phone_number) VALUES(null, 'Mary', 'mary3@email.com', '+09333444444'), (null, 'Mary', 'mary1@email.com', '+09333444444')";

        int excute = statement.executeUpdate(sql);

        System.out.println("Records affected: " + excute);
        statement.close();
        connect.close();





    }
}