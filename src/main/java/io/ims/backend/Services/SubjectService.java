package io.ims.backend.Services;

import io.ims.backend.Models.Subject;
import io.ims.backend.Repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class SubjectService {
    private final SubjectRepository subjectRepository;

    @Autowired
    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public List<Subject> getSubjects() {
        return subjectRepository.findAll();
    }

    public Optional<Subject> getSubjectByID(Long subjectID) {
        return subjectRepository.findById(subjectID);
    }

    public void addNewSubject(Subject subject) {
        subjectRepository.save(subject);
    }

    public void deleteSubject(Long subjectID) {
        boolean exists = subjectRepository.existsById(subjectID);
        if(!exists) {
            throw new IllegalStateException("subject with id " + subjectID + " does not exists");
        }
        subjectRepository.deleteById(subjectID);
    }

    @Transactional
    public void updateSubject(Long subjectID,
                             String subjectName,
                             String subjectCode,
                             String units,
                             Integer labHours,
                             Integer lectureHours,
                              Long departmentID) {
        Subject subject = subjectRepository.findById(subjectID)
                .orElseThrow(() -> new IllegalStateException(
                        "subject with id " + subjectID + " does not exists"
                ));

        if (subjectName != null &&
                subjectName.length() > 0 &&
                !Objects.equals(subject.getSubjectName(), subject)) {
            subject.setSubjectName(subjectName);
        }
        if (subjectCode != null &&
                subjectCode.length() > 0 &&
                !Objects.equals(subject.getSubjectCode(), subject)) {
            subject.setSubjectCode(subjectCode);
        }
        if (units != null &&
                units.length() > 0 &&
                !Objects.equals(subject.getUnits(), subject)) {
            subject.setUnits(units);
        }
        if (labHours != null &&
                !Objects.equals(subject.getLabHours(), subject)) {
            subject.setLabHours(labHours);
        }
        if (lectureHours != null &&
                !Objects.equals(subject.getLectureHours(), subject)) {
            subject.setLectureHours(lectureHours);
        }
        if (departmentID != null &&
                !Objects.equals(subject.getDepartmentID(), subject)) {
            subject.setDepartmentID(departmentID);
        }

    }
}
