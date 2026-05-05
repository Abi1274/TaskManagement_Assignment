package com.project.taskmanagement.dao;

import com.project.taskmanagement.model.Employee;
import com.project.taskmanagement.config.DBConfig;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.*;

@Repository
public class EmployeeDAO {

    public List<Employee> getAll() {
        List<Employee> list = new ArrayList<>();

        try (Connection con = DBConfig.getConnection()) {

            String sql = "SELECT * FROM employee";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Employee e = new Employee();
                e.setEmployeeId(rs.getInt("employee_id"));
                e.setEmployeeName(rs.getString("employee_name"));
                e.setEmail(rs.getString("email"));
                e.setDepartment(rs.getString("department"));
                e.setDesignation(rs.getString("designation"));

                list.add(e);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public void save(Employee e) {
        try (Connection con = DBConfig.getConnection()) {

            if (e.getEmployeeId() == 0) {
                String sql = "INSERT INTO employee(employee_name,email,department,designation) VALUES (?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, e.getEmployeeName());
                ps.setString(2, e.getEmail());
                ps.setString(3, e.getDepartment());
                ps.setString(4, e.getDesignation());
                ps.executeUpdate();

            } else {
                String sql = "UPDATE employee SET employee_name=?, email=?, department=?, designation=? WHERE employee_id=?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, e.getEmployeeName());
                ps.setString(2, e.getEmail());
                ps.setString(3, e.getDepartment());
                ps.setString(4, e.getDesignation());
                ps.setInt(5, e.getEmployeeId());
                ps.executeUpdate();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Employee get(int id) {
        Employee e = null;

        try (Connection con = DBConfig.getConnection()) {

            String sql = "SELECT * FROM employee WHERE employee_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                e = new Employee();
                e.setEmployeeId(rs.getInt("employee_id"));
                e.setEmployeeName(rs.getString("employee_name"));
                e.setEmail(rs.getString("email"));
                e.setDepartment(rs.getString("department"));
                e.setDesignation(rs.getString("designation"));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return e;
    }
    
    public void delete(int id) {
        try (Connection con = DBConfig.getConnection()) {

            String sql = "DELETE FROM employee WHERE employee_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public List<Employee> searchByName(String keyword) {
        List<Employee> result = new ArrayList<>();

        try (Connection con = DBConfig.getConnection()) {

            String sql = "SELECT * FROM employee WHERE employee_name LIKE ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + keyword + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Employee e = new Employee();
                e.setEmployeeId(rs.getInt("employee_id"));
                e.setEmployeeName(rs.getString("employee_name"));
                e.setEmail(rs.getString("email"));
                e.setDepartment(rs.getString("department"));
                e.setDesignation(rs.getString("designation"));

                result.add(e);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}