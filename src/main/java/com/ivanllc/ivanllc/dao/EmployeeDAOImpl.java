package com.ivanllc.ivanllc.dao;

import com.ivanllc.ivanllc.entity.Employee;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public void addEmployee(Employee employee) {
        String sql = "INSERT INTO employee VALUES (null,? ?,?,?,?,?)";
        try (Connection connection = DBConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setDouble(2, employee.getSalary());
            preparedStatement.setString(3, employee.getGender());
            preparedStatement.setDate(4, Date.valueOf(employee.getDOB()));
            preparedStatement.setInt(5, employee.getDepartment_id());
            preparedStatement.setInt(6, employee.getRole_id());

            preparedStatement.executeUpdate();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    @Override
    public void deleteEmployee(int employeeId) {
        String sql = "DELETE FROM employee WHERE employee_id = ?";
        try (Connection connection = DBConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
            preparedStatement.setInt(1, employeeId);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    @Override
    public void updateEmployee(int employeeId, Employee employee) {
        String sql = "UPDATE employee SET employee_name = ?, salary = ?, gender = ?, dob = ?, department_id = ?, role_id = ? WHERE employee_id = ?";
        try (Connection connection = DBConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setDouble(2, employee.getSalary());
            preparedStatement.setString(3, employee.getGender());
            preparedStatement.setDate(4, Date.valueOf(employee.getDOB()));
            preparedStatement.setInt(5, employee.getDepartment_id());
            preparedStatement.setInt(6, employee.getRole_id());
            preparedStatement.setInt(7, employeeId);
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }

    @Override
    public Employee findById(int employeeId) {
        String sql = "SELECT * FROM EMPLOYEE WHERE employee_id  = ?";
        try (Connection connection = DBConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ) {
            preparedStatement.setInt(1, employeeId);
            ResultSet resultSet = preparedStatement.executeQuery();


            if (resultSet.next()) {
                Employee employee = new Employee();
                employee.setId(resultSet.getInt("employee_id"));
                employee.setName(resultSet.getString("name"));
                employee.setSalary(resultSet.getDouble("salary"));
                employee.setGender(resultSet.getString("gender"));
                employee.setDOB(resultSet.getDate("DOB").toLocalDate());
                employee.setDepartment_id(resultSet.getInt("Department"));
                employee.setRole_id(resultSet.getInt("Role"));
                return employee;
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return null;
    }

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> allEmployees = new ArrayList<>();
        String sql = "SELECT * FROM employee";
        try (Connection connection = DBConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setId(resultSet.getInt("employee_id"));
                employee.setName(resultSet.getString("name"));
                employee.setSalary(resultSet.getDouble("salary"));
                employee.setGender(resultSet.getString("gender"));
                employee.setDOB(resultSet.getDate("DOB").toLocalDate());
                employee.setDepartment_id(resultSet.getInt("Department"));
                employee.setRole_id(resultSet.getInt("Role"));
                allEmployees.add(employee);
            }
        } catch (SQLException sqlExeption) {
            sqlExeption.printStackTrace();
        }
        return allEmployees;
    }

    @Override
    public List<Employee> searchEmployeeByName(String name) {
        List<Employee> employees = new ArrayList<>();

        String sql = "SELECT * FROM employee WHERE name ?";

        try (Connection connection = DBConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, name);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Employee employee = new Employee();

                employee.setId(resultSet.getInt("employee_id"));
                employee.setName(resultSet.getString("name"));
                employee.setSalary(resultSet.getDouble("salary"));
                employee.setGender(resultSet.getString("gender"));
                employee.setDOB(resultSet.getDate("DOB").toLocalDate());
                employee.setDepartment_id(resultSet.getInt("Department"));
                employee.setRole_id(resultSet.getInt("Role"));

                employees.add(employee);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    return employees;
    }
}
