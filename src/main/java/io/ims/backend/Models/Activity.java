package io.ims.backend.Models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @JsonBackReference(value = "student-activity")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;

    @JsonBackReference(value = "professor-activity")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "professor_id")
    private Professor professor;

   public Activity (String activityName, String activityType, Integer studentScore, Integer totalScore) {
       this.activityName = activityName;
       this.activityType = activityType;
       this.studentScore = studentScore;
       this.totalScore = totalScore;
   }


}
