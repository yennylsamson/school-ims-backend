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
   private Integer studentID;
   private String yearLevel;
   private Integer courseID;
   private String section;

   public Integer getStudentID() {
       return this.studentID;
   }

   public void setStudentID(Integer studentID) {
       this.studentID = studentID;
   }

   public String getYearLevel() {
       return this.yearLevel;
   }

   public void setYearLevel(String yearLevel) {
       this.yearLevel = yearLevel;
   }

   public Integer getCourseID() {
       return this.courseID;
   }

   public void setCourse(Integer course) {
       this.courseID = courseID;
   }

   public String getSection() {
       return this.section;
   }

   public void setSection(String section) {
       this.section = section;
   }

}
