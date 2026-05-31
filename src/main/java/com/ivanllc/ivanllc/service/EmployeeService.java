package com.ivanllc.ivanllc.service;

import com.ivanllc.ivanllc.entity.Employee;

import java.util.List;

public interface EmployeeService {
    void addEmployee(Employee employee);
    void deleteEmployee (int employeeId);
    void updateEmployee (int employeeId, Employee employee);
    Employee findById (int employeeId);
    List<Employee> getAllEmployee ();
    List<Employee> searchEmployeeByName(String name);
}
