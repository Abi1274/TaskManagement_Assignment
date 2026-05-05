package com.project.taskmanagement.dao;

import com.project.taskmanagement.model.Task;
import com.project.taskmanagement.model.Employee;
import com.project.taskmanagement.config.DBConfig;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.*;

@Repository
public class TaskDAO {

    public List<Task> getAll() {
        List<Task> list = new ArrayList<>();

        try (Connection con = DBConfig.getConnection()) {

            String sql = "SELECT t.*, e.employee_name FROM task t LEFT JOIN employee e ON t.employee_id = e.employee_id";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Task t = new Task();
                t.setTaskId(rs.getInt("task_id"));
                t.setTaskTitle(rs.getString("task_title"));
                t.setDescription(rs.getString("description"));
                t.setPriority(rs.getString("priority"));
                t.setStatus(rs.getString("status"));

                Employee e = new Employee();
                e.setEmployeeId(rs.getInt("employee_id"));
                e.setEmployeeName(rs.getString("employee_name"));

                t.setAssignedEmployee(e);

                list.add(t);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public void save(Task t) {
        try (Connection con = DBConfig.getConnection()) {

            if (t.getTaskId() == 0) {
                String sql = "INSERT INTO task(task_title,description,priority,status,employee_id) VALUES (?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, t.getTaskTitle());
                ps.setString(2, t.getDescription());
                ps.setString(3, t.getPriority());
                ps.setString(4, t.getStatus());
                ps.setInt(5, t.getAssignedEmployee().getEmployeeId());
                ps.executeUpdate();

            } else {
                String sql = "UPDATE task SET task_title=?, description=?, priority=?, status=?, employee_id=? WHERE task_id=?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, t.getTaskTitle());
                ps.setString(2, t.getDescription());
                ps.setString(3, t.getPriority());
                ps.setString(4, t.getStatus());
                ps.setInt(5, t.getAssignedEmployee().getEmployeeId());
                ps.setInt(6, t.getTaskId());
                ps.executeUpdate();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try (Connection con = DBConfig.getConnection()) {

            String sql = "DELETE FROM task WHERE task_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Task get(int id) {
        Task t = null;

        try (Connection con = DBConfig.getConnection()) {

            String sql = "SELECT * FROM task WHERE task_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                t = new Task();
                t.setTaskId(rs.getInt("task_id"));
                t.setTaskTitle(rs.getString("task_title"));
                t.setDescription(rs.getString("description"));
                t.setPriority(rs.getString("priority"));
                t.setStatus(rs.getString("status"));

                Employee e = new Employee();
                e.setEmployeeId(rs.getInt("employee_id"));
                t.setAssignedEmployee(e);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return t;
    }
    
}