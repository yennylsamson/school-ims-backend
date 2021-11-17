package io.ims.backend.Models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.ims.backend.Serializer.CustomCourseSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table
@NoArgsConstructor
@AllArgsConstructor
@JsonSerialize(using = CustomCourseSerializer.class)
public class Course {
    @Id
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_sequence"
    )
    public Long courseID;
    public String courseName;
    public String courseCode;
    public String chairperson;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "course")
    private List<Student> students;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

    public Course (String courseName, String courseCode, String chairperson) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.chairperson = chairperson;
    }
}
