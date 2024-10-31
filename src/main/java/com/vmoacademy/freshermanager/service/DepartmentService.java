package com.vmoacademy.freshermanager.service;

import com.vmoacademy.freshermanager.entity.Department;
import com.vmoacademy.freshermanager.entity.Fresher;

import java.util.List;
import java.util.Set;

public interface DepartmentService {
    Department findById(int id);
    List<Department> findAll();
    void deleteById(int id);
    Department save(Department department);

    Set<Fresher> addFresherToDepartment(int departmentId, int fresherId);
}
