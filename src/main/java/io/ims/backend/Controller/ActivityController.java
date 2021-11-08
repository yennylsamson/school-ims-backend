package io.ims.backend.Controller;

import java.util.List;
import java.util.Optional;


import io.ims.backend.Services.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.ims.backend.Models.Activity;

@RestController
@RequestMapping("/activities")
@CrossOrigin
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    //GET ALL
    @GetMapping("/")
    public List<Activity> getActivity(){
        return activityService.getActivities();
    }

    //GET SINGLE USER
    @GetMapping("/{activityID}")
    public Optional<Activity> getActivity(@PathVariable Long activityID){
        return activityService.getActivityByID(activityID);
    }

    //POST USER
    @PostMapping("/")
    public void postActivity(@RequestBody Activity activity){
        activityService.addNewActivity(activity);
    }

    //PUT USER
    @PutMapping("/{activityID}")
    public Activity putActivity(@RequestBody Activity activity){
        Activity oldActivity = activityRepository.findById(activity.getActivityID()).orElse(null);
        oldActivity.setActivityName(activity.getActivityName());
        oldActivity.setActivityType(activity.getActivityType());
        oldActivity.setStudentScore(activity.getStudentScore());
        oldActivity.setTotalScore(activity.getTotalScore());
        return activityRepository.save(oldActivity);
    }

    //DELETE USER
    @DeleteMapping("/{activityID}")
    public Integer deleteActivity(@PathVariable Integer activityID){
        activityRepository.deleteById(activityID);
        return activityID;
    }
}
