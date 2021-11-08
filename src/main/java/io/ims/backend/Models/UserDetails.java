package io.ims.backend.Models;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "detailsID")
@Inheritance(strategy = InheritanceType.JOINED)
public class UserDetails extends User{
  @Id
  @SequenceGenerator(
          name = "details_sequence",
          sequenceName = "details_sequence",
          allocationSize = 1
  )
  @GeneratedValue(
          strategy = GenerationType.SEQUENCE,
          generator = "details_sequence"
  )
  private Long detailsID;
  private String firstName;
  private String lastName;
  private String gender;
  private Integer age;
  private String birthDate;
  private String homeAddress;
  private Integer contactNumber;
  private String civilStatus;

    public UserDetails(String email, String password, String userRole, String firstName, String lastName, String gender, Integer age, String birthDate, String homeAddress, Integer contactNumber, String civilStatus) {
        super(email, password, userRole);
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.birthDate = birthDate;
        this.homeAddress = homeAddress;
        this.contactNumber = contactNumber;
        this.civilStatus = civilStatus;
    }

    public Long getDetailsID() {
      return this.detailsID;
  }

  public void setDetailsID(Long detailsID) {
      this.detailsID = detailsID;
  }

  public String getFirstName() {
      return this.firstName;
  }

  public void setFirstName(String firstName) {
      this.firstName = firstName;
  }

  public String getLastName() {
      return this.lastName;
  }

  public void setLastName(String lastName) {
      this.lastName = lastName;
  }

  public String getGender() {
      return this.gender;
  }

  public void setGender(String gender) {
      this.gender = gender;
  }

  public Integer getAge() {
      return this.age;
  }

  public void setAge(Integer age) {
      this.age = age;
  }

  public String getBirthDate() {
      return this.birthDate;
  }

  public void setBirthDate(String birthDate) {
      this.birthDate = birthDate;
  }

  public String getHomeAddress() {
      return this.homeAddress;
  }

  public void setHomeAddress(String homeAddress) {
      this.homeAddress = homeAddress;
  }

  public Integer getContactNumber() {
      return this.contactNumber;
  }

  public void setContactNumber(Integer contactNumber) {
      this.contactNumber = contactNumber;
  }

  public String getCivilStatus() {
      return this.civilStatus;
  }

  public void setCivilStatus(String civilStatus) {
      this.civilStatus = civilStatus;
  }
}
