package com.vmoacademy.freshermanager.rest;

import com.vmoacademy.freshermanager.entity.Department;
import com.vmoacademy.freshermanager.entity.Fresher;
import com.vmoacademy.freshermanager.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/department")
public class DepartmentRestController {
    private DepartmentService departmentService;
    @Autowired
    public DepartmentRestController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public List<Department> findAll(){
        return departmentService.findAll();
    }

    @PostMapping
    public Department addDepartment(@RequestBody Department department){
        return departmentService.save(department);
    }

    @PutMapping
    public Department updateDepartment(@RequestBody Department department){
        Department dbDepartment = departmentService.findById(department.getDepartmentID());
        return departmentService.save(department);
    }

    @DeleteMapping("/{id}")
    public String deleteDepartment(@PathVariable int id){
        departmentService.deleteById(id);
        return "Delete department with id: "+ id;
    }
    @PutMapping("/{departmentId}/{fresherId}")
    public Set<Fresher> addFreshertoDepartment(@PathVariable("departmentId") int departmentId, @PathVariable("fresherId") int fresherId){
        return departmentService.addFresherToDepartment(departmentId,fresherId);
    }
}
