package io.ims.backend.Services;

import io.ims.backend.Models.Activity;
import io.ims.backend.Models.Professor;
import io.ims.backend.Models.Student;
import io.ims.backend.Repository.ActivityRepository;
import io.ims.backend.Repository.ProfessorRepository;
import io.ims.backend.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ActivityService {

    private final ActivityRepository activityRepository;
    private final StudentRepository studentRepository;
    private final ProfessorRepository professorRepository;


    @Autowired
    public  ActivityService(ActivityRepository activityRepository, StudentRepository studentRepository, ProfessorRepository professorRepository) {
        this.activityRepository = activityRepository;
        this.studentRepository = studentRepository;
        this.professorRepository = professorRepository;
    }


    public List<Activity> getActivities() {
        return activityRepository.findAll();
    }

    public Optional<Activity> getActivityByID(Long activityID) {
        return activityRepository.findById(activityID);
    }

    public List<Activity> getActivityByProfessorID(Long professorID) {
        return activityRepository.findActivityByProfessorID(professorID);
    }

    public List<Activity> getActivityByStudentID(Long studentID) {
        return activityRepository.findActivityByStudentID(studentID);
    }

    public void addNewActivity(Activity activity, Long studentID, Long professorID) {
        Student student = studentRepository.findById(studentID)
                .orElseThrow(() -> new IllegalStateException(
                        "student with id " + studentID + " does not exists"
                ));
        Professor professor = professorRepository.findById(professorID)
                .orElseThrow(() -> new IllegalStateException(
                        "professor with id " + professorID + " does not exists"
                ));
        activity.setStudent(student);
        activity.setProfessor(professor);
        activityRepository.save(activity);
    }

    public void deleteActivity(Long activityID) {
        boolean exists = activityRepository.existsById(activityID);
        if(!exists) {
            throw new IllegalStateException("activity with id " + activityID + " does not exists");
        }
        activityRepository.deleteById(activityID);
    }

    @Transactional
    public void updateActivity(Long activityID,
                              String activityName,
                              String activityType,
                              Integer studentScore,
                              Integer totalScore,
                               Long studentID,
                               Long professorID) {
        Activity activity = activityRepository.findById(activityID)
                .orElseThrow(() -> new IllegalStateException(
                        "activity with id " + activityID + " does not exists"
                ));
        Student student = studentRepository.findById(studentID)
                .orElseThrow(() -> new IllegalStateException(
                        "student with id " + studentID + " does not exists"
                ));
        Professor professor = professorRepository.findById(professorID)
                .orElseThrow(() -> new IllegalStateException(
                        "professor with id " + professorID + " does not exists"
                ));

        if (activityName != null &&
                activityName.length() > 0 &&
                !Objects.equals(activity.getActivityName(), activity)) {
            activity.setActivityName(activityName);
        }

        if (activityType != null &&
                activityType.length() > 0 &&
                !Objects.equals(activity.getActivityType(), activity)) {
            activity.setActivityType(activityType);
        }

        if (studentScore != null &&
                !Objects.equals(activity.getStudentScore(), activity)) {
            activity.setStudentScore(studentScore);
        }

        if (totalScore != null &&
                !Objects.equals(activity.getTotalScore(), activity)) {
            activity.setTotalScore(totalScore);
        }

        if (studentID != null &&
                !Objects.equals(activity.getStudent().getUserID(), activity)) {
            activity.setStudent(student);
        }

        if (professorID != null &&
                !Objects.equals(activity.getProfessor().getUserID(), activity)) {
            activity.setProfessor(professor);
        }
    }

}
