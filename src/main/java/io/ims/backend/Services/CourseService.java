package io.ims.backend.Services;

import io.ims.backend.Models.Course;
import io.ims.backend.Models.Department;
import io.ims.backend.Repository.CourseRepository;
import io.ims.backend.Repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CourseService {
    private final CourseRepository courseRepository;
    private final DepartmentRepository departmentRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository, DepartmentRepository departmentRepository) {
        this.courseRepository = courseRepository;
        this.departmentRepository = departmentRepository;
    }

    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

    public Optional<Course> getCourseByID(Long courseID) {
        return courseRepository.findById(courseID);
    }

    public void addNewCourse(Course course, Long departmentID) {
        Department department = departmentRepository.findById(departmentID)
                .orElseThrow(() -> new IllegalStateException(
                        "department with id " + departmentID + " does not exists"
                ));
        course.setDepartment(department);
        courseRepository.save(course);
    }

    public void deleteCourse(Long courseID) {
        boolean exists = courseRepository.existsById(courseID);
        if(!exists) {
            throw new IllegalStateException("course with id " + courseID + " does not exists");
        }
        courseRepository.deleteById(courseID);
    }

    @Transactional
    public void updateCourse(Long courseID,
                             String courseName,
                             String courseCode,
                             String chairperson,
                             Long departmentID) {
        Course course = courseRepository.findById(courseID)
                .orElseThrow(() -> new IllegalStateException(
                        "course with id " + courseID + " does not exists"
                ));

        Department department = departmentRepository.findById(departmentID)
                .orElseThrow(() -> new IllegalStateException(
                        "department with id " + departmentID + " does not exists"
                ));

        if (courseName != null &&
                courseName.length() > 0 &&
                !Objects.equals(course.getCourseName(), course)) {
            course.setCourseName(courseName);
        }

        if (courseCode != null &&
                courseCode.length() > 0 &&
                !Objects.equals(course.getCourseCode(), course)) {
            course.setCourseCode(courseCode);
        }

        if (chairperson != null &&
                chairperson.length() > 0 &&
                !Objects.equals(course.getChairperson(), course)) {
            course.setChairperson(chairperson);
        }

        if (departmentID != null &&
                !Objects.equals(course.getDepartment().getDepartmentID(), course)) {
            course.setDepartment(department);
        }

    }
}
