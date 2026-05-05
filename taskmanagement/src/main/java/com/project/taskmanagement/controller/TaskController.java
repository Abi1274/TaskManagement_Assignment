package com.project.taskmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.project.taskmanagement.model.Task;
import com.project.taskmanagement.service.TaskService;
import com.project.taskmanagement.service.EmployeeService;

@Controller
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService service;

    @Autowired
    private EmployeeService empService;

//  /task/list → show all tasks
    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("tasks", service.getTasks());
        return "task_list";
    }

//  /task/add → open form
    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("task", new Task());
        model.addAttribute("employees", empService.getEmployees());
        return "task_form";
    }

//  /task/edit/{id} → edit form
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("task", service.get(id));
        model.addAttribute("employees", empService.getEmployees());
        return "task_form";
    }
//save
    @PostMapping("/save")
    public String save(@ModelAttribute Task task,
                       @RequestParam int empId,
                       Model model) {
        try {
            service.save(task, empId);
            return "redirect:/task/list";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("employees", empService.getEmployees());
            return "task_form";
        }
    }

// id Delete task
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        service.delete(id);
        return "redirect:/task/list";
    }

//Update status (BONUS FEATURE)
    @GetMapping("/update-status/{id}")
    public String updateStatus(@PathVariable int id,
                              @RequestParam String status) {

        service.updateStatus(id, status);
        return "redirect:/task/list";
    }
}