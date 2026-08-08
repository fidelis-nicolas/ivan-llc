package com.ivanllc.ivanllc.controller;

import com.ivanllc.ivanllc.dao.EmployeeDAO;
import com.ivanllc.ivanllc.dao.EmployeeDAOImpl;
import com.ivanllc.ivanllc.entity.Employee;
import com.ivanllc.ivanllc.notification.Messages;
import com.ivanllc.ivanllc.service.EmployeeServiceImpl;
import javafx.beans.Observable;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;


import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class EmployeeServiceController implements Initializable {

    @FXML
    private Button btnDashboard;

    @FXML private TableView<Employee> tblEmployee;
    @FXML private TableColumn<Employee, Integer>   colEmployeeId;
    @FXML private TableColumn<Employee, String>    colEmployeeName;
    @FXML private TableColumn<Employee, Double>     colEmployeeSalary;
    @FXML private TableColumn<Employee, String>    colGender;
    @FXML private TableColumn<Employee, LocalDate> colDOB;
    @FXML private TableColumn<Employee, Integer>   colEmployeeDept;
    @FXML private TableColumn<Employee, Integer>   colEmployeeRole;
    @FXML private TableColumn<Employee, String>    colEmployeePosition;

   private EmployeeDAO employeeDAO= new EmployeeDAOImpl();
   private EmployeeServiceImpl employeeService = new EmployeeServiceImpl(employeeDAO);

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

    public void loadEmployees (){
        List<Employee> employeeList = employeeService.getAllEmployee();
        ObservableList <Employee> employeeData = FXCollections.observableArrayList(employeeList);

        tblEmployee.setItems(employeeData);
    }

    public void setColumns (){
        colEmployeeId.setCellValueFactory(c -> new SimpleObjectProperty<>(c.getValue().getId()));
        colEmployeeName.setCellValueFactory(c -> new SimpleObjectProperty<>(c.getValue().getName()));
        colEmployeeSalary.setCellValueFactory(c -> new SimpleObjectProperty<>(c.getValue().getSalary()));
        colGender.setCellValueFactory(c -> new SimpleObjectProperty<>(c.getValue().getGender()));
        colDOB.setCellValueFactory(c -> new SimpleObjectProperty<>(c.getValue().getDOB()));
        colEmployeeDept.setCellValueFactory(c -> new SimpleObjectProperty<>(c.getValue().getDepartment_id()));
        colEmployeeRole.setCellValueFactory(c -> new SimpleObjectProperty<>(c.getValue().getRole_id()));
        colEmployeePosition.setCellValueFactory(c -> new SimpleObjectProperty<>(c.getValue().getPosition()));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources){
        setColumns();
        loadEmployees();

    }
}
