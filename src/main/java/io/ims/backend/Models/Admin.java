package io.ims.backend.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "adminID")
public class Admin extends UserDetails {
    @Id
    @SequenceGenerator(
            name = "admin_sequence",
            sequenceName = "admin_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "admin_sequence"
    )
    private Long adminID;
    private String office;

    public Admin(String email, String password, String userRole, String firstName, String lastName, String gender, Integer age, LocalDate birthDate, String homeAddress, Integer contactNumber, String civilStatus, String office) {
        super(email, password, userRole, firstName, lastName, gender, age, birthDate, homeAddress, contactNumber, civilStatus);
        this.office = office;
    }

    public Long getAdminID() {
        return adminID;
    }

    public void setAdminID(Long adminID) {
        this.adminID = adminID;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }
}
