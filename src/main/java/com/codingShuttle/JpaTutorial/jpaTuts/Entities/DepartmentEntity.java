package com.codingShuttle.JpaTutorial.jpaTuts.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="departments")
public class DepartmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    Long id;
    @JsonProperty("title")
    String title;

    @OneToOne
    @JoinColumn(name="department_manager")
    @JsonProperty("manager")
    EmployeeEntity manager;

    @JsonProperty("workers")
    @OneToMany(mappedBy = "workerDepartment")
    Set<EmployeeEntity> workers;

    @JsonProperty("freelancers")
    @ManyToMany(mappedBy = "freelanceDepartments")
    Set<EmployeeEntity> freelancers;

    public Set<EmployeeEntity> getFreelancers() {
        return freelancers;
    }

    public void setFreelancers(Set<EmployeeEntity> freelancers) {
        this.freelancers = freelancers;
    }

    public Set<EmployeeEntity> getWorkers() {
        return workers;
    }

    public void setManager(EmployeeEntity manager) {
        this.manager = manager;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setWorkers(Set<EmployeeEntity> workers) {
        this.workers = workers;
    }

    public EmployeeEntity getManager() {
        return manager;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DepartmentEntity that = (DepartmentEntity) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getTitle(), that.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle());
    }
}
