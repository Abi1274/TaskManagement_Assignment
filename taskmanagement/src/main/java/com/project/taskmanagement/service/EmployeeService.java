package com.project.taskmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.taskmanagement.dao.EmployeeDAO;
import com.project.taskmanagement.model.Employee;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDAO dao;
//fetch
    public List<Employee> getEmployees() {
        return dao.getAll();
    }
//id fetch
    public Employee get(int id) {
        return dao.get(id);
    }
//save
    public void save(Employee e) {
    	
        if (e.getEmployeeName() == null || e.getEmployeeName().trim().isEmpty()) {
            throw new RuntimeException("Employee Name is required");
        }

        if (e.getEmail() == null || e.getEmail().trim().isEmpty()) {
            throw new RuntimeException("Email is required");
        }

        if (!isValidEmail(e.getEmail())) {
            throw new RuntimeException("Invalid Email format");
        }

        
        if (e.getDepartment() == null || e.getDepartment().trim().isEmpty()) {
            throw new RuntimeException("Department is required");
        }
        
        dao.save(e);   // handles both insert and update
    }
    //email 
    private boolean isValidEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return java.util.regex.Pattern.matches(regex, email);
    }
    
//delete    
    public void delete(int id) {
        dao.delete(id);
    }
//search
    public List<Employee> searchByName(String keyword) {
        return dao.searchByName(keyword);
    }
}