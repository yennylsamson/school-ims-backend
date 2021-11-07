package io.ims.backend.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Subjects {
    @Id
    @GeneratedValue
    public int subjectID;
    public String subjectName;
    public String subjectCode;
    public String units;
    public int lectureHours;
    public int labHours;
}
