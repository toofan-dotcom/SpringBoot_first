package com.codingShuttle.JpaTutorial.jpaTuts.Repositories;

import com.codingShuttle.JpaTutorial.jpaTuts.Entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {
}
