package io.ims.backend.Controller;

import java.util.List;
import java.util.Optional;


import io.ims.backend.Services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.ims.backend.Models.Subject;

@RestController
@RequestMapping(path = "subjects")
@CrossOrigin
public class SubjectController {
    private final SubjectService subjectService;

    @Autowired
    public SubjectController (SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    //GET ALL
    @GetMapping()
    public List<Subject> getAllSubjects(){
        return subjectService.getSubjects();
    }

    //GET SINGLE USER
    @GetMapping(path = "{subjectID}")
    public Optional<Subject> getSubjectByID(
            @PathVariable("subjectID") Long subjectID){
        return subjectService.getSubjectByID(subjectID);
    }

    //POST USER
    @PostMapping()
    public void registerNewSubject(@RequestBody Subject subject){
        subjectService.addNewSubject(subject);
    }

    //PUT USER
    @PutMapping(path = "{subjectID}")
    public void updateSubject(
            @PathVariable("subjectID") Long subjectID,
            @RequestParam(required = false) String subjectName,
            @RequestParam(required = false) String subjectCode,
            @RequestParam(required = false) String units,
            @RequestParam(required = false) Integer labHours,
            @RequestParam(required = false) Integer lectureHours,
            @RequestParam(required = false) Long departmentID){
        subjectService.updateSubject(subjectID, subjectName,subjectCode, units, labHours, lectureHours, departmentID);
    }

    //DELETE USER
    @DeleteMapping(path = "{subjectID}")
    public void deleteSubject(
            @PathVariable("subjectID") Long subjectID){
        subjectService.deleteSubject(subjectID);
    }
}
