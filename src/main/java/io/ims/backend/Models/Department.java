package io.ims.backend.Models;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
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

    public Department (String departmentName, String departmentDean) {
        this.departmentName = departmentName;
        this.departmentDean = departmentDean;
    }


    public Long getDepartmentID() {
        return this.departmentID;
    }

    public void setDepartmentID(Long departmentID) {
        this.departmentID = departmentID;
    }

    public String getDepartmentName() {
        return this.departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentDean() {
        return this.departmentDean;
    }

    public void setDepartmentDean(String departmentDean) {
        this.departmentDean = departmentDean;
    }

}
