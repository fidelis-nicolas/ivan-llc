package com.ivanllc.ivanllc.dao;

import com.ivanllc.ivanllc.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    void addEmployee(Employee employee);
    void deleteEmployee (int employeeId);
    void updateEmployee (int employeeId, Employee employee);
    Employee findById (int employeeId);
    List<Employee> getAllEmployee ();
    List<Employee> searchEmployeeByName(String name);
}
