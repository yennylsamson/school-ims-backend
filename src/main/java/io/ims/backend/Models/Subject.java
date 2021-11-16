package io.ims.backend.Models;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor

public class Subject {
    @Id
    @SequenceGenerator(
            name = "subject_sequence",
            sequenceName = "subject_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "subject_sequence"
    )
    public Long subjectID;
    public String subjectName;
    public String subjectCode;
    public String units;
    public Integer lectureHours;
    public Integer labHours;
    public Long departmentID;

    @ManyToMany(mappedBy = "joinedSubjects")
    Set<Student> enrolledStudents;

    public Subject(String subjectName, String subjectCode, String units, Integer lectureHours, Integer labHours, Long departmentID){
        this.subjectName = subjectName;
        this.subjectCode = subjectCode;
        this.units = units;
        this.lectureHours = lectureHours;
        this.labHours = labHours;
        this.departmentID = departmentID;
    }

    public Long getSubjectID() {
        return this.subjectID;
    }

    public void setSubjectID(Long subjectID) {
        this.subjectID = subjectID;
    }

    public String getSubjectName() {
        return this.subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectCode() {
        return this.subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getUnits() {
        return this.units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public Integer getLectureHours() {
        return this.lectureHours;
    }

    public void setLectureHours(Integer lectureHours) {
        this.lectureHours = lectureHours;
    }

    public Integer getLabHours() {
        return this.labHours;
    }

    public void setLabHours(Integer labHours) {
        this.labHours = labHours;
    }

    public Long getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(Long departmentID) {
        this.departmentID = departmentID;
    }


}
