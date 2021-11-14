package io.ims.backend.Controller;

import io.ims.backend.Models.Professor;
import io.ims.backend.Services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "professor")
@CrossOrigin
public class ProfessorController {
    private final ProfessorService professorService;

    @Autowired
    public ProfessorController (ProfessorService professorService) {
        this.professorService = professorService;
    }

    //GET ALL
    @GetMapping()
    public List<Professor> getAllStudents(){
        return professorService.getProfessors();
    }

    //GET SINGLE USER
    @GetMapping(path = "{professorID}")
    public Optional<Professor> getStudentByID(
            @PathVariable("professorID") Long professorID){
        return professorService.getProfessorByID(professorID);
    }

    //POST USER
    @PostMapping()
    public void registerNewProfessor(@RequestBody Professor professor){
        professorService.addNewProfessor(professor);
    }

    //PUT USER
    @PutMapping(path = "{professorID}")
    public void updateSubject(
            @PathVariable("professorID") Long professorID,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String password,
            @RequestParam(required = false) String userRole,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String gender,
            @RequestParam(required = false) LocalDate birthDate,
            @RequestParam(required = false) String homeAddress,
            @RequestParam(required = false) String contactNumber,
            @RequestParam(required = false) String civilStatus,
            @RequestParam(required = false) Long departmentID) {
        professorService.updateProfessor(professorID, email, password, userRole, firstName, lastName, gender, birthDate, homeAddress, contactNumber, civilStatus, departmentID);
    }

    //DELETE USER
    @DeleteMapping(path = "{professorID}")
    public void deleteSubject(
            @PathVariable("professorID") Long professorID){
        professorService.deleteProfessor(professorID);
    }
}
