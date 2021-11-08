package io.ims.backend.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetails{
  @Id
  @GeneratedValue
  private int detailsID;
  private String firstName;
  private String lastName;
  private String gender;
  private int age;
  private String birthDate;
  private String homeAddress;
  private int contactNumber;
  private String civilStatus;

  public int getDetailsID() {
      return this.detailsID;
  }

  public void setDetailsID(int detailsID) {
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

  public int getAge() {
      return this.age;
  }

  public void setAge(int age) {
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

  public int getContactNumber() {
      return this.contactNumber;
  }

  public void setContactNumber(int contactNumber) {
      this.contactNumber = contactNumber;
  }

  public String getCivilStatus() {
      return this.civilStatus;
  }

  public void setCivilStatus(String civilStatus) {
      this.civilStatus = civilStatus;
  }
}
