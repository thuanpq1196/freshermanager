package com.vmoacademy.freshermanager.service;

import com.vmoacademy.freshermanager.dao.DepartmentRepository;
import com.vmoacademy.freshermanager.entity.Department;
import com.vmoacademy.freshermanager.entity.Fresher;
import com.vmoacademy.freshermanager.exceptionHandler.DepartmentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    private DepartmentRepository departmentRepository;
    private FresherService fresherService;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository, FresherService fresherService) {
        this.departmentRepository = departmentRepository;
        this.fresherService = fresherService;
    }

    @Override
    public Department findById(int id) {
        Optional<Department> optDepartment = departmentRepository.findById(id);
        Department dbDepartment = null;
        if(optDepartment.isPresent()){
            dbDepartment = optDepartment.get();
        }
        if(dbDepartment == null){
            throw new DepartmentNotFoundException("Department id not found: "+id);
        }
        return dbDepartment;
    }

    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Override
    public void deleteById(int id) {
        Department dbDepartment = this.findById(id);
        departmentRepository.delete(dbDepartment);
    }

    @Override
    public Department save(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Set<Fresher> addFresherToDepartment(int departmentId, int fresherId) {
        Department dbDepartment = this.findById(departmentId);
        Fresher dbFresher = fresherService.findById(fresherId);
        dbFresher.setDepartment(dbDepartment);
        fresherService.save(dbFresher);
        return dbDepartment.getFresherSet();
    }


}
