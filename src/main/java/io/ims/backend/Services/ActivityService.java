package io.ims.backend.Services;

import io.ims.backend.Models.Activity;
import io.ims.backend.Repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public void addNewActivity(Activity activity) {
        Optional<Activity> activityOptional = activityRepository.findById(activity.getActivityID());
    }
}
