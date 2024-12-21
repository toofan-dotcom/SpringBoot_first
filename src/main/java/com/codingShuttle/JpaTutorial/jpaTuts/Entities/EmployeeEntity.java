package com.codingShuttle.JpaTutorial.jpaTuts.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.http.ResponseEntity;

import java.util.Objects;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name="employees")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    Long id;
    @JsonProperty("name")
    String name;
    @JsonProperty("managedDepartment")
    @OneToOne(mappedBy = "manager")
    @JsonIgnore
    DepartmentEntity managedDepartment;

    @JsonProperty("workerDepartment")
    @ManyToOne
    @JoinColumn(name = "worker_department_id",referencedColumnName = "id")
    @JsonIgnore
    DepartmentEntity workerDepartment;

    @JsonProperty("freelanceDepartment")
    @ManyToMany
    @JoinTable(name = "freelancer_department_mapping",
    joinColumns = @JoinColumn(name = "employee_id"),
    inverseJoinColumns = @JoinColumn(name = "department_id"))
    Set<DepartmentEntity> freelanceDepartments;

    public Set<DepartmentEntity> getFreelanceDepartments() {
        return freelanceDepartments;
    }

    public void setFreelanceDepartments(Set<DepartmentEntity> freelanceDepartments) {
        this.freelanceDepartments = freelanceDepartments;
    }

    public DepartmentEntity getManagedDepartment() {
        return managedDepartment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DepartmentEntity getWorkerDepartment() {
        return workerDepartment;
    }

    public void setWorkerDepartment(DepartmentEntity workerDepartment) {
        this.workerDepartment = workerDepartment;
    }

    public void setManagedDepartment(DepartmentEntity managedDepartment) {
        this.managedDepartment = managedDepartment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeEntity that = (EmployeeEntity) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }

}
