package io.ims.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.ims.backend.Models.Subjects;
@Repository
public interface SubjectsRepository extends JpaRepository<Subjects, Integer>{
    
}
