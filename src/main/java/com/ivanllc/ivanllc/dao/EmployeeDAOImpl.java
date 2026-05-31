package com.ivanllc.ivanllc.dao;

import com.ivanllc.ivanllc.entity.Employee;


import java.sql.*;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public void addEmployee(Employee employee) {
        String sql = "INSERT INTO TABLE employee VALUES (null,? ?,?,?,?,?)";
        try (Connection connection = DBConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setDouble(2, employee.getSalary());
            preparedStatement.setString(3, employee.getGender());
            preparedStatement.setDate(4, (Date) employee.getDOB());
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
            preparedStatement.setDate(4, (Date) employee.getDOB());
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

            Employee employee = new Employee();
            if(resultSet.next()){
                employee.setId(resultSet.getInt("employee_id"));
                employee.setName(resultSet.getString("name"));
                employee.setSalary(resultSet.getDouble("salary"));
                employee.setGender(resultSet.getString("gender"));
                employee.setDOB(resultSet.getDate("DOB"));
                employee.setDepartment_id(resultSet.getInt("Department"));
                employee.setRole_id(resultSet.getInt("Role"));
                return  employee;
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return null;
    }

    @Override
    public List<Employee> getAllEmployee() {

        return List.of();
    }

    @Override
    public List<Employee> searchEmployeeByName(String name) {
        return List.of();
    }
}
