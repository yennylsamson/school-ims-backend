package io.ims.backend.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.ims.backend.Models.Department;
import io.ims.backend.Repository.DepartmentRepository;

@RestController
@RequestMapping("/departments")
@CrossOrigin
public class DepartmentController {
    @Autowired
    private DepartmentRepository departmentRepository;

    //GET ALL
    @GetMapping("/")
    public List<Department> getDepartment(){
        return departmentRepository.findAll();
    }

    //GET SINGLE USER
    @GetMapping("/{departmentID}")
    public Department getDepartment(@PathVariable Integer departmentID){
        return departmentRepository.findById(departmentID).orElse(null);
    }

    //POST USER
    @PostMapping("/")
    public Department postDepartment(@RequestBody Department department){
        return departmentRepository.save(department);
    }

    //PUT USER
    @PutMapping("/")
    public Department putDepartment(@RequestBody Department department){
        Department oldDepartment = departmentRepository.findById(department.getDepartmentID()).orElse(null);
        oldDepartment.setDepartmentName(department.getDepartmentName());
        oldDepartment.setDepartmentDean(department.getDepartmentDean());
        return departmentRepository.save(oldDepartment);
    }

    //DELETE USER
    @DeleteMapping("/{departmentID}")
    public Integer deleteDepartment(@PathVariable Integer departmentID){
        departmentRepository.deleteById(departmentID);
        return departmentID;
    }
}
