package io.ims.backend.Controller;

import io.ims.backend.Models.Student;
import io.ims.backend.Models.Subject;
import io.ims.backend.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping(path = "students")
@CrossOrigin
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController (StudentService studentService) {
        this.studentService = studentService;
    }

    //GET ALL
    @GetMapping()
    public List<Student> getAllStudents(){
        return studentService.getStudents();
    }

    //GET SINGLE USER
    @GetMapping(path = "{studentID}")
    public Optional<Student> getStudentByID(
            @PathVariable("studentID") Long studentID){
        return studentService.getStudentByID(studentID);
    }

    //GET STUDENT SUBJECTS
    @GetMapping(path = "{studentID}/subject")
    public List<Subject> getStudentSubjectByID(
            @PathVariable("studentID") Long studentID) {
        return studentService.getStudentsSubjects(studentID);
    }
    //POST USER
    @PostMapping()
    public void registerNewStudent(
            @RequestBody Student student,
            @RequestParam Long courseID){
        studentService.addNewStudent(student, courseID);
    }

    //PUT SUBJECT
    @PutMapping(path="{studentID}/subject")
    public void addNewSubject(
            @PathVariable("studentID") Long studentID,
            @RequestParam Long subjectID){
        studentService.addNewSubject(studentID, subjectID);
    }

    //PUT USER
    @PutMapping(path = "{studentID}")
    public void updateSubject(
            @PathVariable("studentID") Long studentID,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String password,
            @RequestParam(required = false) String userRole,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String gender,
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate birthDate,
            @RequestParam(required = false) String homeAddress,
            @RequestParam(required = false) String contactNumber,
            @RequestParam(required = false) String civilStatus,
            @RequestParam(required = false) String yearLevel,
            @RequestParam(required = false) String section,
            @RequestParam(required = false) Long courseID){
        studentService.updateStudent(studentID, email, password, userRole, firstName, lastName, gender, birthDate, homeAddress, contactNumber, civilStatus, yearLevel, section, courseID);
    }

    //DELETE USER
    @DeleteMapping(path = "{studentID}")
    public void deleteSubject(
            @PathVariable("studentID") Long studentID){
        studentService.deleteStudent(studentID);
    }
}
