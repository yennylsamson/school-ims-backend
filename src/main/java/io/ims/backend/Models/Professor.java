package io.ims.backend.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    private Long departmentID;

    @ManyToMany
    @JoinTable(
            name="professor_subjects",
            joinColumns = @JoinColumn(name="professor_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id"))
    private Set<Subject> joinedProfessorSubjects;

    @JsonManagedReference(value = "professor-activity")
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "professor")
    private List<Activity> activities;

    @JsonBackReference(value = "department-professor")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

    public Professor(String email, String password, String userRole, String firstName, String lastName, String gender, LocalDate birthDate, String homeAddress, String contactNumber, String civilStatus, Long departmentID) {
        super(email, password, userRole, firstName, lastName, gender, birthDate, homeAddress, contactNumber, civilStatus);
        this.departmentID = departmentID;
    }

}
