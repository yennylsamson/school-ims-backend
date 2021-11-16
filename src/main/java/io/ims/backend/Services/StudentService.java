package io.ims.backend.Services;

import io.ims.backend.Models.Student;
import io.ims.backend.Models.Subject;
import io.ims.backend.Repository.StudentRepository;
import io.ims.backend.Repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository, SubjectRepository subjectRepository) {
        this.studentRepository = studentRepository;
        this.subjectRepository = subjectRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentByID(Long studentID) {
        return studentRepository.findById(studentID);
    }

    public void addNewStudent(Student student) {
        studentRepository.save(student);
    }

    public void deleteStudent(Long userID) {
        boolean exists = studentRepository.existsById(userID);
        if (!exists) {
            throw new IllegalStateException("student with id " + userID + " does not exists");
        }
        studentRepository.deleteById(userID);
    }

    @Transactional
    public void updateStudent(Long userID,
                              String email,
                              String password,
                              String userRole,
                              String firstName,
                              String lastName,
                              String gender,
                              LocalDate birthDate,
                              String homeAddress,
                              String contactNumber,
                              String civilStatus,
                              String yearLevel,
                              Long courseID,
                              String section) {
        Student student = studentRepository.findById(userID)
                .orElseThrow(() -> new IllegalStateException(
                        "student with id " + userID + " does not exists"
                ));

        if (email != null &&
                email.length() > 0 &&
                !Objects.equals(student.getEmail(), student)) {
            student.setEmail(email);
        }

        if (password != null &&
                password.length() > 0 &&
                !Objects.equals(student.getPassword(), student)) {
            student.setPassword(password);
        }

        if (userRole != null &&
                userRole.length() > 0 &&
                !Objects.equals(student.getUserRole(), student)) {
            student.setUserRole(userRole);
        }

        if (firstName != null &&
                firstName.length() > 0 &&
                !Objects.equals(student.getFirstName(), student)) {
            student.setFirstName(firstName);
        }

        if (lastName != null &&
                lastName.length() > 0 &&
                !Objects.equals(student.getLastName(), student)) {
            student.setLastName(lastName);
        }

        if (gender != null &&
                gender.length() > 0 &&
                !Objects.equals(student.getGender(), student)) {
            student.setGender(gender);
        }

        if (birthDate != null &&
                !Objects.equals(student.getBirthDate(), student)) {
            student.setBirthDate(birthDate);
        }

        if (homeAddress != null &&
                homeAddress.length() > 0 &&
                !Objects.equals(student.getHomeAddress(), student)) {
            student.setHomeAddress(homeAddress);
        }

        if (contactNumber != null &&
                !Objects.equals(student.getContactNumber(), student)) {
            student.setContactNumber(contactNumber);
        }

        if (civilStatus != null &&
                civilStatus.length() > 0 &&
                !Objects.equals(student.getCivilStatus(), student)) {
            student.setCivilStatus(civilStatus);
        }

        if (yearLevel != null &&
                yearLevel.length() > 0 &&
                !Objects.equals(student.getYearLevel(), student)) {
            student.setYearLevel(yearLevel);
        }

        if (courseID != null &&
                !Objects.equals(student.getCourseID(), student)) {
            student.setCourseID(courseID);
        }

        if (section != null &&
                section.length() > 0 &&
                !Objects.equals(student.getSection(), student)) {
            student.setSection(section);
        }

    }

    @Transactional
    public void addNewSubject(Long userID, Long subjectID) {
        Student student = studentRepository.findById(userID)
                .orElseThrow(() -> new IllegalStateException(
                        "student with id " + userID + " does not exists"
                ));
        Subject subject = subjectRepository.findById(subjectID)
                .orElseThrow(() -> new IllegalStateException(
                        "subject with id " + subjectID + " does not exists"
                ));
        student.getJoinedStudentSubjects().add(subject);
    }

}
