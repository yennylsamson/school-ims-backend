package io.ims.backend.Models;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_sequence"
    )
    public Long courseID;
    public String courseName;
    public String courseCode;
    public String chairperson;
    public Long departmentID;

    public Course (String courseName, String courseCode, String chairperson, Long departmentID) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.chairperson = chairperson;
        this.departmentID = departmentID;
    }

    public Long getCourseID() {
        return this.courseID;
    }

    public void setCourseID(Long courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return this.courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getChairperson() {
        return this.chairperson;
    }

    public void setChairperson(String chairperson) {
        this.chairperson = chairperson;
    }

    public Long getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(Long departmentID) {
        this.departmentID = departmentID;
    }
}
