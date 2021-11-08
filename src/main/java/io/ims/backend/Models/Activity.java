package io.ims.backend.Models;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
public class Activity {
   @Id
   @SequenceGenerator(
           name = "activity_sequence",
           sequenceName = "activity_sequence",
           allocationSize = 1
   )
   @GeneratedValue(
           strategy = GenerationType.SEQUENCE,
           generator = "activity_sequence"
   )
   public Long activityID;
   public String activityName;
   public String activityType;
   public Integer studentScore;
   public Integer totalScore;

   public Activity (String activityName, String activityType, Integer studentScore, Integer totalScore) {
       this.activityName = activityName;
       this.activityType = activityType;
       this.studentScore = studentScore;
       this.totalScore = totalScore;
   }

   public Long getActivityID() {
       return this.activityID;
   }

   public void setActivityID(Long activityID) {
       this.activityID = activityID;
   }

   public String getActivityName() {
       return this.activityName;
   }

   public void setActivityName(String activityName) {
       this.activityName = activityName;
   }

   public String getActivityType() {
       return this.activityType;
   }

   public void setActivityType(String activityType) {
       this.activityType = activityType;
   }

   public Integer getStudentScore() {
       return this.studentScore;
   }

   public void setStudentScore(Integer studentScore) {
       this.studentScore = studentScore;
   }

   public Integer getTotalScore() {
       return this.totalScore;
   }

   public void setTotalScore(Integer totalScore) {
       this.totalScore = totalScore;
   }

}
