//package io.ims.backend.Configuration;
//
//
//import io.ims.backend.Models.Course;
//import io.ims.backend.Models.Student;
//import io.ims.backend.Repository.CourseRepository;
//import io.ims.backend.Repository.StudentRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.DependsOn;
//import org.springframework.core.annotation.Order;
//
//import java.time.LocalDate;
//import java.time.Month;
//import java.util.List;
//
//@EnableAutoConfiguration
//@ComponentScan("io.ims.backend.*")
//@Configuration
//public class StudentConfiguration {
//    private final CourseRepository courseRepository;
//
//    @Autowired
//    public StudentConfiguration(CourseRepository courseRepository) {
//        this.courseRepository = courseRepository;
//    }
//
//    @Bean
//    CommandLineRunner studentLineRunner(StudentRepository studentRepository) {
//        return args -> {
//            Student ailger = new Student(
//                "ailgermae@student.email.com",
//                    "pass",
//                    "student",
//                    "Ailger Mae",
//                    "Uchiha",
//                    "Male",
//                    LocalDate.of(2000, Month.JANUARY,1),
//                    "Planet Namek",
//                    "09123456789",
//                    "Married",
//                    "4th Year",
//                    "CpE-401"
//
//            );
//            Student glenn = new Student(
//                    "glennmarie@student.email.com",
//                    "pass",
//                    "student",
//                    "Glenn Marie",
//                    "Uzumaki",
//                    "Male",
//                    LocalDate.of(2000, Month.JANUARY,1),
//                    "Planet Konoha",
//                    "09123456789",
//                    "Married",
//                    "4th Year",
//                    "CpE-401"
//            );
//
//            Course CPE = courseRepository.getById(1L);
//            ailger.setCourse(CPE);
//            glenn.setCourse(CPE);
//            studentRepository.saveAll(
//                    List.of(ailger, glenn)
//            );
//        };
//    }
//}
