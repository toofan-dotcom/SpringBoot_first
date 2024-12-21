package com.codingShuttle.JpaTutorial.jpaTuts.Controller;

import com.codingShuttle.JpaTutorial.jpaTuts.Entities.EmployeeEntity;
import com.codingShuttle.JpaTutorial.jpaTuts.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/{employeeId}")
    public EmployeeEntity getEmployeeById(@PathVariable Long employeeId){
        return employeeService.getEmployeeById(employeeId);
    }

    @PostMapping
    public EmployeeEntity createNewEmployee(@RequestBody EmployeeEntity employeeEntity){
        System.out.println("Received Employee: " + employeeEntity);
        return employeeService.createNewEmployee(employeeEntity);
    }
}
