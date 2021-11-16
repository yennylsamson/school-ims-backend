package io.ims.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.ims.backend.Models.Activity;

import java.util.List;
import java.util.Optional;


@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long>{
    @Query("SELECT a FROM Activity a WHERE a.professor.userID = ?1")
    List<Activity> findActivityByProfessorID(Long professorID);

    @Query("SELECT a FROM Activity a WHERE a.student.userID = ?1")
    List<Activity> findActivityByStudentID(Long studentID);
}