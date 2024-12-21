package com.codingShuttle.JpaTutorial.jpaTuts.Services;

import com.codingShuttle.JpaTutorial.jpaTuts.Entities.EmployeeEntity;
import com.codingShuttle.JpaTutorial.jpaTuts.Repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public EmployeeEntity createNewEmployee(EmployeeEntity employeeEntity){
        return employeeRepository.save(employeeEntity);
    }

    public EmployeeEntity getEmployeeById(Long id){
        return employeeRepository.findById(id).orElse(null);
    }
}
