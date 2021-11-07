package io.ims.backend.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Professor extends UserDetails{
    @Id
    @GeneratedValue
    private int professorID;

    public int getProfessorID() {
        return this.professorID;
    }

    public void setProfessorID(int professorID) {
        this.professorID = professorID;
    }
}
