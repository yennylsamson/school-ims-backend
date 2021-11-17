//package io.ims.backend.Configuration;
//
//import io.ims.backend.Models.Course;
//import io.ims.backend.Models.Department;
//import io.ims.backend.Repository.CourseRepository;
//import io.ims.backend.Repository.DepartmentRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.autoconfigure.AutoConfigureAfter;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.DependsOn;
//import org.springframework.core.annotation.Order;
//
//import java.util.List;
//
//@AutoConfigureAfter(ProfessorConfiguration.class)
//@ComponentScan("io.ims.backend.*")
//@Configuration
//public class CourseConfiguration {
//    private final DepartmentRepository departmentRepository;
//
//    @Autowired
//    public CourseConfiguration(DepartmentRepository departmentRepository) {
//        this.departmentRepository = departmentRepository;
//    }
//
//    @Bean
//    CommandLineRunner courseLineRunner(CourseRepository courseRepository){
//        return args -> {
//            Course CPE = new Course(
//                    "Computer Engineering",
//                    "CpE",
//                    "Engr. Niyo Kenn Jimenez"
//            );
//            Course CE = new Course(
//                    "Civil Engineering",
//                    "CE",
//                    "Engr. Filipina De Guzman"
//            );
//            Department SEA = departmentRepository.getById(1L);
//            CPE.setDepartment(SEA);
//            CE.setDepartment(SEA);
//            courseRepository.saveAll(List.of(CPE,CE));
//        };
//    }
//}
