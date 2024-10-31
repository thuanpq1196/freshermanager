package com.vmoacademy.freshermanager.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name ="department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private Integer departmentID;
    @Column(name = "department_name")
    private String departmentName;
    @JsonManagedReference
    @OneToMany(mappedBy = "department")
    private Set<Fresher> fresherSet;

    public Department() {
    }

    public Department(Integer departmentID, String departmentName, Set<Fresher> fresherSet) {
        this.departmentID = departmentID;
        this.departmentName = departmentName;
        this.fresherSet = fresherSet;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentID=" + departmentID +
                ", departmentName='" + departmentName + '\'' +
                ", fresherSet=" + fresherSet +
                '}';
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void setDepartmentID(Integer departmentID) {
        this.departmentID = departmentID;
    }

    public Integer getDepartmentID() {
        return departmentID;
    }

    public Set<Fresher> getFresherSet() {
        return fresherSet;
    }

    public void setFresherSet(Set<Fresher> fresherSet) {
        this.fresherSet = fresherSet;
    }
}
