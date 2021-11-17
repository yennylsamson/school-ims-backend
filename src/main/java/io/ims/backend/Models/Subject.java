package io.ims.backend.Models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
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

    @ManyToMany(targetEntity = Student.class, mappedBy = "joinedStudentSubjects")
    private List<Student> enrolledStudents;

    @ManyToMany(mappedBy = "joinedProfessorSubjects")
    private Set<Professor> teachingProfessors;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

    public Subject(String subjectName, String subjectCode, String units, Integer lectureHours, Integer labHours){
        this.subjectName = subjectName;
        this.subjectCode = subjectCode;
        this.units = units;
        this.lectureHours = lectureHours;
        this.labHours = labHours;
    }
}
