package io.ims.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.ims.backend.Models.Professor;
@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer>{
    
}
