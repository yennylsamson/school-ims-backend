package io.ims.backend.Services;

import io.ims.backend.Models.Department;
import io.ims.backend.Repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    public Optional<Department> getDepartmentByID(Long departmentID) {
        return departmentRepository.findById(departmentID);
    }

    public void addNewDepartment(Department department) {
        departmentRepository.save(department);
    }

    public void deleteDepartment(Long departmentID) {
        boolean exists = departmentRepository.existsById(departmentID);
        if(!exists) {
            throw new IllegalStateException("department with id " + departmentID + " does not exists");
        }
        departmentRepository.deleteById(departmentID);
    }

    @Transactional
    public void updateDepartment(Long departmentID,
                             String departmentName,
                             String departmentDean) {
        Department department = departmentRepository.findById(departmentID)
                .orElseThrow(() -> new IllegalStateException(
                        "department with id " + departmentID + " does not exists"
                ));

        if (departmentName != null &&
                departmentName.length() > 0 &&
                !Objects.equals(department.getDepartmentName(), department)) {
            department.setDepartmentName(departmentName);
        }

        if (departmentDean != null &&
                departmentDean.length() > 0 &&
                !Objects.equals(department.getDepartmentDean(), department)) {
            department.setDepartmentDean(departmentDean);
        }


    }
}
