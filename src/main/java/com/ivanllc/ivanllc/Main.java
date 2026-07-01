package com.ivanllc.ivanllc;

import com.ivanllc.ivanllc.dao.EmployeeDAO;
import com.ivanllc.ivanllc.dao.EmployeeDAOImpl;
import com.ivanllc.ivanllc.entity.Employee;
import com.ivanllc.ivanllc.service.EmployeeServiceImpl;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException, SQLException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 500);
        stage.setTitle("Welcome to Ivan LLC App");
        stage.setResizable(true);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws SQLException {
        //launch();
        EmployeeDAOImpl employeeDAOImpl = new EmployeeDAOImpl();
        EmployeeServiceImpl employeeServiceImpl = new EmployeeServiceImpl(employeeDAOImpl);
        Employee employee = new Employee();
        employee.setName("Ivan");
        employee.setSalary(20.0);
        employee.setRole_id(1);
        employee.setGender("Male");
        employee.setDepartment_id(1);
        employee.setDOB(LocalDate.of(1990,8,20));


        employeeServiceImpl.addEmployee(employee);
    }
}