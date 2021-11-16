package io.ims.backend.Services;

import io.ims.backend.Models.Professor;
import io.ims.backend.Models.Subject;
import io.ims.backend.Repository.ProfessorRepository;
import io.ims.backend.Repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProfessorService {
    private final ProfessorRepository professorRepository;
    private final SubjectRepository subjectRepository;

    @Autowired
    public ProfessorService(ProfessorRepository professorRepository, SubjectRepository subjectRepository) {
        this.professorRepository = professorRepository;
        this.subjectRepository = subjectRepository;
    }

    public List<Professor> getProfessors() {
        return professorRepository.findAll();
    }

    public Optional<Professor> getProfessorByID(Long professorID) {
        return professorRepository.findById(professorID);
    }

    public void addNewProfessor(Professor professor) {
        professorRepository.save(professor);
    }

    public void deleteProfessor(Long userID) {
        boolean exists = professorRepository.existsById(userID);
        if (!exists) {
            throw new IllegalStateException("professor with id " + userID + " does not exists");
        }
        professorRepository.deleteById(userID);
    }

    @Transactional
    public void updateProfessor(Long userID,
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
                              Long departmentID) {
        Professor professor = professorRepository.findById(userID)
                .orElseThrow(() -> new IllegalStateException(
                        "professor with id " + userID + " does not exists"
                ));

        if (email != null &&
                email.length() > 0 &&
                !Objects.equals(professor.getEmail(), professor)) {
            professor.setEmail(email);
        }

        if (password != null &&
                password.length() > 0 &&
                !Objects.equals(professor.getPassword(), professor)) {
            professor.setPassword(password);
        }

        if (userRole != null &&
                userRole.length() > 0 &&
                !Objects.equals(professor.getUserRole(), professor)) {
            professor.setUserRole(userRole);
        }

        if (firstName != null &&
                firstName.length() > 0 &&
                !Objects.equals(professor.getFirstName(), professor)) {
            professor.setFirstName(firstName);
        }

        if (lastName != null &&
                lastName.length() > 0 &&
                !Objects.equals(professor.getLastName(), professor)) {
            professor.setLastName(lastName);
        }

        if (gender != null &&
                gender.length() > 0 &&
                !Objects.equals(professor.getGender(), professor)) {
            professor.setGender(gender);
        }

        if (birthDate != null &&
                !Objects.equals(professor.getBirthDate(), professor)) {
            professor.setBirthDate(birthDate);
        }

        if (homeAddress != null &&
                homeAddress.length() > 0 &&
                !Objects.equals(professor.getHomeAddress(), professor)) {
            professor.setHomeAddress(homeAddress);
        }

        if (contactNumber != null &&
                !Objects.equals(professor.getContactNumber(), professor)) {
            professor.setContactNumber(contactNumber);
        }

        if (civilStatus != null &&
                civilStatus.length() > 0 &&
                !Objects.equals(professor.getCivilStatus(), professor)) {
            professor.setCivilStatus(civilStatus);
        }

        if (departmentID != null &&
                !Objects.equals(professor.getDepartmentID(), professor)) {
            professor.setDepartmentID(departmentID);
        }

    }

    @Transactional
    public void addNewSubject(Long userID, Long subjectID) {
        Professor professor = professorRepository.findById(userID)
                .orElseThrow(() -> new IllegalStateException(
                        "professor with id " + userID + " does not exists"
                ));
        Subject subject = subjectRepository.findById(subjectID)
                .orElseThrow(() -> new IllegalStateException(
                        "subject with id " + subjectID + " does not exists"
                ));
        professor.getJoinedProfessorSubjects().add(subject);
    }

}
