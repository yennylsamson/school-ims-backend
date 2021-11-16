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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "professor_id")
    private Professor professor;

   public Activity (String activityName, String activityType, Integer studentScore, Integer totalScore, Student student, Professor professor) {
       this.activityName = activityName;
       this.activityType = activityType;
       this.studentScore = studentScore;
       this.totalScore = totalScore;
       this.student = student;
       this.professor = professor;
   }


}
