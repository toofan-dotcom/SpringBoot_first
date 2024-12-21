package com.codingShuttle.JpaTutorial.jpaTuts.Services;

import com.codingShuttle.JpaTutorial.jpaTuts.Entities.DepartmentEntity;
import com.codingShuttle.JpaTutorial.jpaTuts.Entities.EmployeeEntity;
import com.codingShuttle.JpaTutorial.jpaTuts.Repositories.DepartmentRepository;
import com.codingShuttle.JpaTutorial.jpaTuts.Repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    EmployeeRepository employeeRepository;

    public DepartmentEntity createNewDepartment(DepartmentEntity departmentEntity){
        DepartmentEntity savedEntity= departmentRepository.save(departmentEntity);
        return  savedEntity;
    }

    public DepartmentEntity getDepartmentById(Long id){
        return departmentRepository.findById(id).orElse(null);
    }

    public DepartmentEntity assignManagerToDepartment(Long departmentId, Long employeeId) {
       Optional<DepartmentEntity> departmentEntity= departmentRepository.findById(departmentId);
       Optional<EmployeeEntity> employeeEntity= employeeRepository.findById(employeeId);

       return departmentEntity.flatMap(department ->
               employeeEntity.map(employee -> {
                   department.setManager(employee);
                   return departmentRepository.save(department);
               })).orElse(null);
    }

    public DepartmentEntity getAssignedDepartment(Long employeeId) {
        Optional<EmployeeEntity> employeeEntity=employeeRepository.findById(employeeId);
       return  departmentRepository.findByManager(employeeEntity.get());
    }

    public DepartmentEntity assignWorkerToDepartment(Long departmentId, Long employeeId) {
        Optional<DepartmentEntity> departmentEntity=departmentRepository.findById(departmentId);
        Optional<EmployeeEntity> employeeEntity=employeeRepository.findById(employeeId);
        return departmentEntity.flatMap(departmentEntity1 ->
                employeeEntity.map(employeeEntity1 -> {
                    employeeEntity1.setWorkerDepartment(departmentEntity1);
                    employeeRepository.save((employeeEntity1));

                    departmentEntity1.getWorkers().add(employeeEntity1);
                    return departmentEntity1;
                })).orElse(null);
    }
}
