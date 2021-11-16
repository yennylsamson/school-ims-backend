package io.ims.backend.Models;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
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


}
