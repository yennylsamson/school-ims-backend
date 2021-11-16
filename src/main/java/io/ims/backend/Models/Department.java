package io.ims.backend.Models;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table
@NoArgsConstructor
@AllArgsConstructor
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

    public Department (String departmentName, String departmentDean) {
        this.departmentName = departmentName;
        this.departmentDean = departmentDean;
    }

}
