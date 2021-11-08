package io.ims.backend.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Activity {
   @Id
   @GeneratedValue
   public int activityID;
   public String activityName;
   public String activityType;
   public int studentScore;
   public int totalScore;

   public int getActivityID() {
       return this.activityID;
   }

   public void setActivityID(int activityID) {
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

   public int getStudentScore() {
       return this.studentScore;
   }

   public void setStudentScore(int studentScore) {
       this.studentScore = studentScore;
   }

   public int getTotalScore() {
       return this.totalScore;
   }

   public void setTotalScore(int totalScore) {
       this.totalScore = totalScore;
   }

}
