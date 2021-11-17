package io.ims.backend.Controller;

import java.util.List;
import java.util.Optional;


import io.ims.backend.Services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.ims.backend.Models.Course;

@RestController
@RequestMapping(path = "courses")
@CrossOrigin
public class CourseController {
    private final CourseService courseService;

    @Autowired
    public CourseController (CourseService courseService) {
        this.courseService = courseService;
    }

    //GET ALL
    @GetMapping()
    public List<Course> getAllCourses(){
        return courseService.getCourses();
    }

    //GET SINGLE USER
    @GetMapping(path = "{courseID}")
    public Optional<Course> getCourseByID(
            @PathVariable("courseID") Long courseID){
        return courseService.getCourseByID(courseID);
    }

    //POST USER
    @PostMapping()
    public void registerNewCourse(
            @RequestBody Course course,
            @RequestParam(required = false) Long departmentID){
        courseService.addNewCourse(course, departmentID);
    }

    //PUT USER
    @PutMapping(path = "{courseID}")
    public void updateCourse(
            @PathVariable("courseID") Long courseID,
            @RequestParam(required = false) String courseName,
            @RequestParam(required = false) String courseCode,
            @RequestParam(required = false) String chairperson,
            @RequestParam(required = false) Long departmentID){
        courseService.updateCourse(courseID, courseName, courseCode, chairperson, departmentID);
    }

    //DELETE USER
    @DeleteMapping(path = "{courseID}")
    public void deleteCourse(
            @PathVariable("courseID") Long courseID){
        courseService.deleteCourse(courseID);
    }
}
