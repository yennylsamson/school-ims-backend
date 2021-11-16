package io.ims.backend.Models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "subjectID")
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

    @ManyToMany(mappedBy = "joinedStudentSubjects")
    private Set<Student> enrolledStudents;

    @ManyToMany(mappedBy = "joinedProfessorSubjects")
    private Set<Professor> teachingProfessors;

    public Subject(String subjectName, String subjectCode, String units, Integer lectureHours, Integer labHours, Long departmentID){
        this.subjectName = subjectName;
        this.subjectCode = subjectCode;
        this.units = units;
        this.lectureHours = lectureHours;
        this.labHours = labHours;
        this.departmentID = departmentID;
    }
}
