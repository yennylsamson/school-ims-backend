package io.ims.backend.Models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.ims.backend.Serializer.CustomActivitySerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table
@NoArgsConstructor
@AllArgsConstructor
@JsonSerialize(using = CustomActivitySerializer.class)
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id")
    private Subject subject;

   public Activity (String activityName, String activityType, Integer studentScore, Integer totalScore) {
       this.activityName = activityName;
       this.activityType = activityType;
       this.studentScore = studentScore;
       this.totalScore = totalScore;
   }


}
