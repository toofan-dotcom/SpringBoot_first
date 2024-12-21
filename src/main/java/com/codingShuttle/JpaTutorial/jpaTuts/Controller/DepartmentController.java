package com.codingShuttle.JpaTutorial.jpaTuts.Controller;

import com.codingShuttle.JpaTutorial.jpaTuts.Entities.DepartmentEntity;
import com.codingShuttle.JpaTutorial.jpaTuts.Services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @GetMapping("/{departmentId}")
    public DepartmentEntity getDepartmentById(@PathVariable Long departmentId){
        return departmentService.getDepartmentById(departmentId);
    }

    @PostMapping
    public DepartmentEntity createNewDepartment(@RequestBody DepartmentEntity departmentEntity){
        return  departmentService.createNewDepartment(departmentEntity);
    }

    @PutMapping("/{departmentId}/manager/{employeeId}")
    public DepartmentEntity assignManagerToDepartment(@PathVariable Long departmentId,
                                                      @PathVariable Long employeeId){
        return departmentService.assignManagerToDepartment(departmentId,employeeId);
    }

    @GetMapping("/assignedDepartmentOfManager/{employeeId}")
    public DepartmentEntity getAssignedDepartment(@PathVariable Long employeeId){
        return departmentService.getAssignedDepartment(employeeId);
    }


    @PutMapping("/{departmentId}/worker/{employeeId}")
    public DepartmentEntity assignWorkerToDepartment(@PathVariable Long departmentId,
                                                      @PathVariable Long employeeId){
        return departmentService.assignWorkerToDepartment(departmentId,employeeId);
    }

}
