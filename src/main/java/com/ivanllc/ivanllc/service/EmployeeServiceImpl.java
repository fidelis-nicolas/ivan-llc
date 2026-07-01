package com.ivanllc.ivanllc.service;

import java.util.List;

import com.ivanllc.ivanllc.dao.EmployeeDAO;
import com.ivanllc.ivanllc.entity.Employee;


public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDAO employeeDAO;

    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public void addEmployee(Employee employee) {
    // if(employee.getDepartment_id() == 0){
    //     throw new RuntimeException("Employee must be assigned to department");
    // }
    employeeDAO.addEmployee(employee);

    System.out.println(employee);
    }

    @Override
    public void deleteEmployee(int employeeId) {

    }

    @Override
    public void updateEmployee(int employeeId, Employee employee) {

    }

    @Override
    public Employee findById(int employeeId) {
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
