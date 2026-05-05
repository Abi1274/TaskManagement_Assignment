package com.project.taskmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.taskmanagement.dao.TaskDAO;
import com.project.taskmanagement.dao.EmployeeDAO;
import com.project.taskmanagement.model.Task;
import com.project.taskmanagement.model.Employee;

@Service
public class TaskService {

    @Autowired
    private TaskDAO taskDao;

    @Autowired
    private EmployeeDAO empDao;

    // Get all tasks
    public List<Task> getTasks() {
        return taskDao.getAll();
    }

    //Get single task
    public Task get(int id) {
        return taskDao.get(id);
    }
    //saave
    public void save(Task task, int empId) {

        
        if (task.getTaskTitle() == null || task.getTaskTitle().trim().isEmpty()) {
            throw new RuntimeException("Task Title is required");
        }

        
        if (task.getPriority() == null || task.getPriority().isEmpty()) {
            throw new RuntimeException("Priority is required");
        }

       
        if (task.getStatus() == null || task.getStatus().isEmpty()) {
            task.setStatus("PENDING"); // default
        }

        
        Employee emp = empDao.get(empId);
        if (emp == null) {
            throw new RuntimeException("Employee must be selected");
        }

        task.setAssignedEmployee(emp);

        taskDao.save(task);
    }

   //deletion 
    public void delete(int id) {
        taskDao.delete(id);
    }

    //update
    public void updateStatus(int id, String status) {
        Task t = taskDao.get(id);

        if (t != null) {
            t.setStatus(status);
        }
    }
}