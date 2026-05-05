package com.project.taskmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.project.taskmanagement.model.Employee;
import com.project.taskmanagement.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

 
    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("employees", service.getEmployees());
        return "employee_list";
    }

// employee/add   
    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee_form";
    }
//edit
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("employee", service.get(id));
        return "employee_form";
    }

//save   
    @PostMapping("/save")
    public String save(@ModelAttribute Employee emp, Model model) {
        try {
            service.save(emp);
            return "redirect:/employee/list";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "employee_form";
        }
    }

//  deletebyid 
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        service.delete(id);
        return "redirect:/employee/list";
    }
// search   
    @GetMapping("/search")
    public String search(@RequestParam String keyword, Model model) {

        if (keyword == null || keyword.trim().isEmpty()) {
            model.addAttribute("employees", service.getEmployees());
        } else {
            model.addAttribute("employees", service.searchByName(keyword));
        }

        return "employee_list";
    }
}