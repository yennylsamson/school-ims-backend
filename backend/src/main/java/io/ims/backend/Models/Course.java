package io.ims.backend.Models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Course {
    @Id
    private int courseId;
    public String courseName;
    public String courseCode;
    public String chairperson;

    public int getCourseId() {
        return this.courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
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

}
