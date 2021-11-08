package io.ims.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.ims.backend.Models.Course;


@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>{
    
}
