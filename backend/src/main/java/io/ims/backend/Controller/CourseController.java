package io.ims.backend.Controller;

import java.util.List;


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

import io.ims.backend.Models.Course;
import io.ims.backend.Repository.CourseRepository;

@RestController
@RequestMapping("/courses")
@CrossOrigin
public class CourseController {
    @Autowired
    private CourseRepository courseRepository;

    //GET ALL
    @GetMapping("/")
    public List<Course> getCourse(){
        return courseRepository.findAll();
    }

    //GET SINGLE USER
    @GetMapping("/{courseID}")
    public Course getCourse(@PathVariable Integer id){
        return courseRepository.findById(id).orElse(null);
    }

    //POST USER
    @PostMapping("/")
    public Course postCourse(@RequestBody Course course){
        return courseRepository.save(course);
    }

    //PUT USER
    @PutMapping("/")
    public Course putCourse(@RequestBody Course course){
        Course oldCourse = courseRepository.findById(course.getCourseID()).orElse(null);
        oldCourse.setCourseName(course.getCourseName());
        oldCourse.setCourseCode(course.getCourseCode());
        oldCourse.setChairperson(course.getChairperson());
        return courseRepository.save(oldCourse);
    }

    //DELETE USER
    @DeleteMapping("/{courseID}")
    public Integer deleteCourse(@PathVariable Integer id){
        courseRepository.deleteById(id);
        return id;
    }
}
