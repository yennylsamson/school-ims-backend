package io.ims.backend.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.ims.backend.Models.Subject;
import io.ims.backend.Repository.SubjectRepository;

@RestController
@RequestMapping("/subjects")
@CrossOrigin
public class SubjectController {
    @Autowired
    private SubjectRepository subjectRepository;

    //GET ALL
    @GetMapping("/")
    public List<Subject> getSubject(){
        return subjectRepository.findAll();
    }

    //GET SINGLE USER
    @GetMapping("/{subjectID}")
    public Subject getSubject(@PathVariable Integer subjectID){
        return subjectRepository.findById(subjectID).orElse(null);
    }

    //POST USER
    @PostMapping("/")
    public Subject postSubject(@RequestBody Subject subject){
        return subjectRepository.save(subject);
    }

    //PUT USER
    @PutMapping("/")
    public Subject putSubject(@RequestBody Subject subject){
        Subject oldSubject = subjectRepository.findById(subject.getSubjectID()).orElse(null);
        oldSubject.setSubjectName(subject.getSubjectName());
        oldSubject.setSubjectCode(subject.getSubjectCode());
        oldSubject.setLectureHours(subject.getLectureHours());
        oldSubject.setLabHours(subject.getLabHours());
        oldSubject.setUnits(subject.getUnits());
        return subjectRepository.save(oldSubject);
    }

    //DELETE USER
    @DeleteMapping("/{subjectID}")
    public Integer deleteSubject(@PathVariable Integer subjectID){
        subjectRepository.deleteById(subjectID);
        return subjectID;
    }
}
