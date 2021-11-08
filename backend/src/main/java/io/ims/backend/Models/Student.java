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
public class Student {
   @Id
   @GeneratedValue
   private int studentID;
   private String yearLevel;
   private String course;
   private String section;

   public int getStudentID() {
       return this.studentID;
   }

   public void setStudentID(int studentID) {
       this.studentID = studentID;
   }

   public String getYearLevel() {
       return this.yearLevel;
   }

   public void setYearLevel(String yearLevel) {
       this.yearLevel = yearLevel;
   }

   public String getCourse() {
       return this.course;
   }

   public void setCourse(String course) {
       this.course = course;
   }

   public String getSection() {
       return this.section;
   }

   public void setSection(String section) {
       this.section = section;
   }

}
