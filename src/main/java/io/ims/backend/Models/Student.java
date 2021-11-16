package io.ims.backend.Models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "userID")
@PrimaryKeyJoinColumn(name = "studentID")
public class Student extends UserDetails{
    @SequenceGenerator(
           name = "student_sequence",
           sequenceName = "student_sequence",
           allocationSize = 1
    )
    @GeneratedValue(
           strategy = GenerationType.SEQUENCE,
           generator = "student_sequence"
    )
    private String yearLevel;
    private String section;

    @ManyToMany
           @JoinTable(
                   name="student_subjects",
                   joinColumns = @JoinColumn(name="student_id"),
                   inverseJoinColumns = @JoinColumn(name = "subject_id"))
    private Set<Subject> joinedStudentSubjects;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "student")
    private List<Activity> activities;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;



    public Student(String email, String password, String userRole, String firstName, String lastName, String gender, LocalDate birthDate, String homeAddress, String contactNumber, String civilStatus, String yearLevel, String section) {
        super(email, password, userRole, firstName, lastName, gender, birthDate, homeAddress, contactNumber, civilStatus);
        this.yearLevel = yearLevel;
        this.section = section;
    }


}
