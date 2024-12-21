package com.codingShuttle.JpaTutorial.jpaTuts.Repositories;

import com.codingShuttle.JpaTutorial.jpaTuts.Entities.DepartmentEntity;
import com.codingShuttle.JpaTutorial.jpaTuts.Entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity,Long> {
    DepartmentEntity findByManager(EmployeeEntity employeeEntity);
}
