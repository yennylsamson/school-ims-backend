package io.ims.backend.Configuration;

import io.ims.backend.Models.*;
import io.ims.backend.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
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
            //ADMIN
            Admin admin = new Admin(
                    "admin@admin.email.com",
                    "adminpass",
                    "admin",
                    "Pekamasanting",
                    "Malagungdili",
                    "Male",
                    LocalDate.of(2000, Month.JANUARY,1),
                    "Planet One Piece",
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
            departmentRepository.saveAll(List.of(sba,sea));

            //COURSE
            Course CPE = new Course(
                    "Computer Engineering",
                    "CpE",
                    "Engr. Niyo Kenn Jimenez"
            );
            Course CE = new Course(
                    "Civil Engineering",
                    "CE",
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
                    "profpass",
                    "professor",
                    "Niyo Kenn",
                    "Jimenez",
                    "Male",
                    LocalDate.of(2000, Month.JANUARY,1),
                    "Angeles City",
                    "09123456789",
                    "Married"
            );
            Professor mitra = new Professor(
                    "mitra@professor.email.com",
                    "profpass",
                    "professor",
                    "Michael",
                    "Mitra",
                    "Male",
                    LocalDate.of(2000, Month.JANUARY,1),
                    "Angeles City",
                    "09123456789",
                    "Single"
            );
            niyo.setDepartment(SEA);
            mitra.setDepartment(SEA);
            professorRepository.saveAll(List.of(niyo, mitra));

            Student ailger = new Student(
                    "ailgermae@student.email.com",
                    "pass",
                    "student",
                    "Ailger Mae",
                    "Uchiha",
                    "Male",
                    LocalDate.of(2000, Month.JANUARY,1),
                    "Planet Namek",
                    "09123456789",
                    "Married",
                    "4th Year",
                    "CpE-401"

            );
            Student glenn = new Student(
                    "glennmarie@student.email.com",
                    "pass",
                    "student",
                    "Glenn Marie",
                    "Uzumaki",
                    "Male",
                    LocalDate.of(2000, Month.JANUARY,1),
                    "Planet Konoha",
                    "09123456789",
                    "Married",
                    "4th Year",
                    "CpE-401"
            );

            ailger.setCourse(CPE);
            glenn.setCourse(CPE);
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

            activity2.setStudent(ailger);
            activity2.setProfessor(mitra);
            activityRepository.saveAll(List.of(activity1,activity2));
        };
    }
}
