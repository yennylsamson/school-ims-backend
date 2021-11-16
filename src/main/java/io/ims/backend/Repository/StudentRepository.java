package io.ims.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.ims.backend.Models.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
}
