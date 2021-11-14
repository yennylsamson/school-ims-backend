package io.ims.backend.Models;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
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
   private Long courseID;
   private String section;

    public Student(String email, String password, String userRole, String firstName, String lastName, String gender, LocalDate birthDate, String homeAddress, String contactNumber, String civilStatus, String yearLevel, Long courseID, String section) {
        super(email, password, userRole, firstName, lastName, gender, birthDate, homeAddress, contactNumber, civilStatus);
        this.yearLevel = yearLevel;
        this.courseID = courseID;
        this.section = section;
    }

   public String getYearLevel() {
       return this.yearLevel;
   }

   public void setYearLevel(String yearLevel) {
       this.yearLevel = yearLevel;
   }

   public Long getCourseID() {
       return this.courseID;
   }

   public void setCourseID(Long courseID) {
       this.courseID = courseID;
   }

   public String getSection() {
       return this.section;
   }

   public void setSection(String section) {
       this.section = section;
   }

}
