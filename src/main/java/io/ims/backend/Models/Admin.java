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
    @SequenceGenerator(
            name = "admin_sequence",
            sequenceName = "admin_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "admin_sequence"
    )
    private String office;

    public Admin(String email, String password, String userRole, String firstName, String lastName, String gender, LocalDate birthDate, String homeAddress, String contactNumber, String civilStatus, String office) {
        super(email, password, userRole, firstName, lastName, gender, birthDate, homeAddress, contactNumber, civilStatus);
        this.office = office;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }
}
