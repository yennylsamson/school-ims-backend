package io.ims.backend.Services;

import io.ims.backend.Models.Activity;
import io.ims.backend.Repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ActivityService {

    private final ActivityRepository activityRepository;


    @Autowired
    public  ActivityService(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }


    public List<Activity> getActivities() {
        return activityRepository.findAll();
    }

    public Optional<Activity> getActivityByID(Long activityID) {
        return activityRepository.findById(activityID);
    }

    public void addNewActivity(Activity activity) {
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
                              Integer totalScore) {
        Activity activity = activityRepository.findById(activityID)
                .orElseThrow(() -> new IllegalStateException(
                        "activity with id " + activityID + " does not exists"
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
    }
}
