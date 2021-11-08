package io.ims.backend.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "professorID")
public class Professor extends UserDetails{
    @Id
    @SequenceGenerator(
            name = "professor_sequence",
            sequenceName = "professor_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "professor_sequence"
    )
    private Long professorID;
    private Long departmentID;

    public Professor(String email, String password, String userRole, String firstName, String lastName, String gender, Integer age, String birthDate, String homeAddress, Integer contactNumber, String civilStatus, Long departmentID) {
        super(email, password, userRole, firstName, lastName, gender, age, birthDate, homeAddress, contactNumber, civilStatus);
        this.departmentID = departmentID;
    }

    public Long getProfessorID() {
        return professorID;
    }

    public void setProfessorID(Long professorID) {
        this.professorID = professorID;
    }

    public Long getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(Long departmentID) {
        this.departmentID = departmentID;
    }
}
