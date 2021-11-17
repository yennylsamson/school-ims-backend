package io.ims.backend.Models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.ims.backend.Serializer.CustomDepartmentSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table
@NoArgsConstructor
@AllArgsConstructor
@JsonSerialize(using = CustomDepartmentSerializer.class)
public class Department {
    @Id
    @SequenceGenerator(
            name = "department_sequence",
            sequenceName = "department_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "department_sequence"
    )
    public Long departmentID;
    public String departmentName;
    public String departmentDean;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "department")
    private List<Professor> professors;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "department")
    private List<Course> courses;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "department")
    private List<Subject> subjects;

    public Department (String departmentName, String departmentDean) {
        this.departmentName = departmentName;
        this.departmentDean = departmentDean;
    }

}
