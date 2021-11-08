package io.ims.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.ims.backend.Models.Subject;
@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer>{
    
}
