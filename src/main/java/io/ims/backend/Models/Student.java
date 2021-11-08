package io.ims.backend.Models;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "studentID")
public class Student extends UserDetails{
   @Id
   @SequenceGenerator(
           name = "student_sequence",
           sequenceName = "student_sequence",
           allocationSize = 1
   )
   @GeneratedValue(
           strategy = GenerationType.SEQUENCE,
           generator = "student_sequence"
   )
   private Long studentID;
   private String yearLevel;
   private Long courseID;
   private String section;

    public Student(String email, String password, String userRole, String firstName, String lastName, String gender, Integer age, String birthDate, String homeAddress, Integer contactNumber, String civilStatus, String yearLevel, Long courseID, String section) {
        super(email, password, userRole, firstName, lastName, gender, age, birthDate, homeAddress, contactNumber, civilStatus);
        this.yearLevel = yearLevel;
        this.courseID = courseID;
        this.section = section;
    }

    public Long getStudentID() {
       return this.studentID;
   }

   public void setStudentID(Long studentID) {
       this.studentID = studentID;
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

   public void setCourse(Long courseID) {
       this.courseID = courseID;
   }

   public String getSection() {
       return this.section;
   }

   public void setSection(String section) {
       this.section = section;
   }

}
