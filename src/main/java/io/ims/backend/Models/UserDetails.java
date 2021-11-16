package io.ims.backend.Models;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Data
@Table
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "detailsID")
@Inheritance(strategy = InheritanceType.JOINED)
public class UserDetails extends User{
  @SequenceGenerator(
          name = "details_sequence",
          sequenceName = "details_sequence",
          allocationSize = 1
  )
  @GeneratedValue(
          strategy = GenerationType.SEQUENCE,
          generator = "details_sequence"
  )

  private String firstName;
  private String lastName;
  private String gender;
  private LocalDate birthDate;
  private String homeAddress;
  private String contactNumber;
  private String civilStatus;

    public UserDetails(String email, String password, String userRole, String firstName, String lastName, String gender, LocalDate birthDate, String homeAddress, String contactNumber, String civilStatus) {
        super(email, password, userRole);
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.homeAddress = homeAddress;
        this.contactNumber = contactNumber;
        this.civilStatus = civilStatus;
    }

}
