package io.ims.backend.Models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table
@NoArgsConstructor
@AllArgsConstructor
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
    public Long departmentID;

    @JsonManagedReference(value = "course-student")
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "course")
    private List<Student> students;

    public Course (String courseName, String courseCode, String chairperson, Long departmentID) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.chairperson = chairperson;
        this.departmentID = departmentID;
    }
}
