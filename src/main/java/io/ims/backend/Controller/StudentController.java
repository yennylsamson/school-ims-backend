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

import io.ims.backend.Models.Student;
import io.ims.backend.Repository.StudentRepository;

@RestController
@RequestMapping("/students")
@CrossOrigin
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    //GET ALL
    @GetMapping("/")
    public List<Student> getStudent(){
        return studentRepository.findAll();
    }

    //GET SINGLE USER
    @GetMapping("/{studentID}")
    public Student getStudent(@PathVariable Integer studentID){
        return studentRepository.findById(studentID).orElse(null);
    }

    //POST USER
    @PostMapping("/")
    public Student postStudent(@RequestBody Student student){
        return studentRepository.save(student);
    }

    //PUT USER
    @PutMapping("/")
    public Student putStudent(@RequestBody Student student){
        Student oldStudent = studentRepository.findById(student.getStudentID()).orElse(null);
        oldStudent.setYearLevel(student.getYearLevel());
        oldStudent.setCourse(student.getCourse());
        oldStudent.setSection(student.getSection());
        return studentRepository.save(oldStudent);
    }

    //DELETE USER
    @DeleteMapping("/{studentID}")
    public Integer deleteStudent(@PathVariable Integer studentID){
        studentRepository.deleteById(studentID);
        return studentID;
    }
}
