package io.ims.backend.Controller;

import java.util.List;
import java.util.Optional;


import io.ims.backend.Services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.ims.backend.Models.Department;

@RestController
@RequestMapping(path = "departments")
@CrossOrigin
public class DepartmentController {
    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController (DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    //GET ALL
    @GetMapping()
    public List<Department> getAllDepartments(){
        return departmentService.getDepartments();
    }

    //GET SINGLE USER
    @GetMapping(path = "{departmentID}")
    public Optional<Department> getDepartmentByID(
            @PathVariable("departmentID") Long departmentID){
        return departmentService.getDepartmentByID(departmentID);
    }

    //POST USER
    @PostMapping()
    public void registerNewDepartment(@RequestBody Department department){
        departmentService.addNewDepartment(department);
    }

    //PUT USER
    @PutMapping(path = "{departmentID}")
    public void updateDepartment(
            @PathVariable("departmentID") Long departmentID,
            @RequestParam(required = false) String departmentName,
            @RequestParam(required = false) String departmentDean){
        departmentService.updateDepartment(departmentID, departmentName, departmentDean);
    }

    //DELETE USER
    @DeleteMapping(path = "{departmentID}")
    public void deleteDepartment(
            @PathVariable("departmentID") Long departmentID){
        departmentService.deleteDepartment(departmentID);
    }
}
