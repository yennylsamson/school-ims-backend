package io.ims.backend.Controller;

import java.util.List;
import java.util.Optional;


import io.ims.backend.Services.ActivityService;
import io.ims.backend.Services.ProfessorService;
import io.ims.backend.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.ims.backend.Models.Activity;

@RestController
@RequestMapping(path ="activities")
@CrossOrigin
public class ActivityController {

    private final ActivityService activityService;

    @Autowired
    public ActivityController (ActivityService activityService) {
        this.activityService = activityService;
    }

    //GET ALL
    @GetMapping()
    public List<Activity> getAllActivities(){
        return activityService.getActivities();
    }

    //GET SINGLE USER
    @GetMapping(path = "{activityID}")
    public Optional<Activity> getActivityByID(
            @PathVariable("activityID") Long activityID){
        return activityService.getActivityByID(activityID);
    }

    //POST USER
    @PostMapping()
    public void registerNewActivity(
            @RequestBody Activity activity,
            @RequestParam(required = false) Long studentID,
            @RequestParam(required = false) Long professorID){
        activityService.addNewActivity(activity, studentID, professorID);
    }

    //PUT USER
    @PutMapping(path = "{activityID}")
    public void updateActivity(
            @PathVariable("activityID") Long activityID,
            @RequestParam(required = false) String activityName,
            @RequestParam(required = false) String activityType,
            @RequestParam(required = false) Integer studentScore,
            @RequestParam(required = false) Integer totalScore
    ){
        activityService.updateActivity(activityID, activityName, activityType, studentScore, totalScore);
    }

    //DELETE USER
    @DeleteMapping(path = "{activityID}")
    public void deleteActivity(
            @PathVariable("activityID") Long activityID){
        activityService.deleteActivity(activityID);
    }
}
