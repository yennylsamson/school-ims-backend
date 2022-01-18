package io.ims.backend.Configuration;

import io.ims.backend.Models.*;
import io.ims.backend.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@ComponentScan("io.ims.backend.*")

@Configuration
public class ApplicationConfiguration {
    private final DepartmentRepository departmentRepository;
    private final CourseRepository courseRepository;
    private final SubjectRepository subjectRepository;
    private  final StudentRepository studentRepository;
    private  final ProfessorRepository professorRepository;
    private final AdminRepository adminRepository;
    private final ActivityRepository activityRepository;

    @Autowired
    public ApplicationConfiguration(DepartmentRepository departmentRepository, CourseRepository courseRepository, SubjectRepository subjectRepository, StudentRepository studentRepository, ProfessorRepository professorRepository, AdminRepository adminRepository, ActivityRepository activityRepository) {
        this.departmentRepository = departmentRepository;
        this.courseRepository = courseRepository;
        this.subjectRepository = subjectRepository;
        this.studentRepository = studentRepository;
        this.professorRepository = professorRepository;
        this.adminRepository = adminRepository;
        this.activityRepository = activityRepository;
    }





    @Bean
    CommandLineRunner departmentLineRunner(DepartmentRepository departmentRepository){
        return args -> {
            MessageDigest md = MessageDigest.getInstance("MD5");
            String adminpass = "adminpass";
            String profpass = "profpass";
            String pass = "pass";
            md.update(adminpass.getBytes());
            byte[] digest = md.digest();
            String adminHash = DatatypeConverter.printHexBinary(digest).toUpperCase();

            md.update(profpass.getBytes());
            digest = md.digest();
            String profHash = DatatypeConverter.printHexBinary(digest).toUpperCase();

            md.update(pass.getBytes());
            digest = md.digest();
            String studHash = DatatypeConverter.printHexBinary(digest).toUpperCase();
            //ADMIN
            Admin admin = new Admin(
                    "admin@admin.email.com",
                    adminHash,
                    "admin",
                    "Juan",
                    "Dela Cruz",
                    "Male",
                    LocalDate.of(2000, Month.JANUARY,1),
                    "Angeles, Pampanga",
                    "09123456789",
                    "Single",
                    "Admin Office"
            );
            adminRepository.saveAll(List.of(admin));
            //DEPT
            Department sea = new Department(
                    "School of Engineering and Architecture",
                    "Dr. Filipina I. De Guzman"
            );

            Department sba = new Department(
                    "School of Business and Accountancy",
                    "Dr. Maria S. Tanquilut"
            );
            departmentRepository.saveAll(List.of(sea,sba));

            //COURSE
            Course CPE = new Course(
                    "Computer Engineering",
                    "CpE",
                    "Engr. Niyo Kenn Jimenez"
            );
            Course CE = new Course(
                    "Civil Engineering",
                    "ChE",
                    "Engr. Filipina De Guzman"
            );
            Department SEA = departmentRepository.getById(1L);
            CPE.setDepartment(SEA);
            CE.setDepartment(SEA);
            courseRepository.saveAll(List.of(CPE,CE));

            Subject calculus = new Subject(
                    "Calculus 1",
                    "CALC1",
                    "3",
                    1,
                    0
            );
            Subject physicsLab = new Subject(
                    "Physics Lab",
                    "PHYSICSL",
                    "1",
                    0,
                    3
            );
            calculus.setDepartment(SEA);
            physicsLab.setDepartment(SEA);
            subjectRepository.saveAll(List.of(calculus,physicsLab));

            Professor niyo = new Professor(
                    "niyo@professor.email.com",
                    profHash,
                    "professor",
                    "Niyo Kenn",
                    "Jimenez",
                    "Male",
                    LocalDate.of(2000, Month.JANUARY,1),
                    "Angeles, Pampanga",
                    "09123456789",
                    "Married"
            );
            Professor mitra = new Professor(
                    "mitra@professor.email.com",
                    profHash,
                    "professor",
                    "Michael",
                    "Mitra",
                    "Male",
                    LocalDate.of(2000, Month.JANUARY,1),
                    "Angeles, Pampanga",
                    "09123456789",
                    "Single"
            );
            List<Subject> subjects = new ArrayList<Subject>();
            subjects.add(calculus);
            subjects.add(physicsLab);

            niyo.setDepartment(SEA);
            mitra.setDepartment(SEA);
            niyo.setJoinedProfessorSubjects(subjects);
            mitra.setJoinedProfessorSubjects(subjects);
            professorRepository.saveAll(List.of(niyo, mitra));

            Student ailger = new Student(
                    "ailgermae@student.email.com",
                    studHash,
                    "student",
                    "Ailger",
                    "Mendoza",
                    "Male",
                    LocalDate.of(2000, Month.JANUARY,1),
                    "Angeles, Pampanga",
                    "09123456789",
                    "Married",
                    "4th Year",
                    "CpE-401"

            );
            Student glenn = new Student(
                    "glennmarie@student.email.com",
                    studHash,
                    "student",
                    "Glenn",
                    "Uy Cana",
                    "Male",
                    LocalDate.of(2000, Month.JANUARY,1),
                    "Angeles, Pampanga",
                    "09123456789",
                    "Married",
                    "4th Year",
                    "CpE-401"
            );

            ailger.setCourse(CPE);
            glenn.setCourse(CPE);
            ailger.setJoinedStudentSubjects(subjects);
            glenn.setJoinedStudentSubjects(subjects);
            studentRepository.saveAll(
                    List.of(ailger, glenn)
            );

            Activity activity1 = new Activity(
                    "Activity 1",
                    "Assignment",
                    24,
                    30
            );
            Activity activity2 = new Activity(
                    "Activity 2",
                    "Assignment",
                    28,
                    30
            );
            activity1.setStudent(ailger);
            activity1.setProfessor(niyo);
            activity1.setSubject(calculus);
            activity2.setStudent(ailger);
            activity2.setProfessor(mitra);
            activity2.setSubject(physicsLab);
            activityRepository.saveAll(List.of(activity1,activity2));
        };
    }
}
