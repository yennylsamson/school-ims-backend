package io.ims.backend.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "professorID")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "userID")
public class Professor extends UserDetails{
    @SequenceGenerator(
            name = "professor_sequence",
            sequenceName = "professor_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "professor_sequence"
    )

    @ManyToMany
    @JoinTable(
            name="professor_subjects",
            joinColumns = @JoinColumn(name="professor_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id"))
    private List<Subject> joinedProfessorSubjects;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "professor")
    private List<Activity> activities;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

    public Professor(String email, String password, String userRole, String firstName, String lastName, String gender, LocalDate birthDate, String homeAddress, String contactNumber, String civilStatus) {
        super(email, password, userRole, firstName, lastName, gender, birthDate, homeAddress, contactNumber, civilStatus);
    }

}
