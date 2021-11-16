package io.ims.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.ims.backend.Models.Activity;

import java.util.Optional;


@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long>{
    @Query("SELECT a FROM Activity a WHERE a.professor.userID = ?1")
    Optional<Activity> findActivityByProfessorID(Long professorID);

    @Query("SELECT a FROM Activity a WHERE a.student.userID = ?1")
    Optional<Activity> findActivityByStudentID(Long studentID);
}