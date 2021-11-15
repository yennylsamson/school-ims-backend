package io.ims.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.ims.backend.Models.Department;
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{
    
}
