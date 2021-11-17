//package io.ims.backend.Configuration;
//
//import io.ims.backend.Models.Department;
//import io.ims.backend.Repository.DepartmentRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.autoconfigure.AutoConfigureBefore;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
//@AutoConfigureBefore({CourseConfiguration.class, SubjectConfiguration.class, ProfessorConfiguration.class})
//@ComponentScan("io.ims.backend.*")
//@Configuration
//public class DepartmentConfiguration {
//    @Bean
//    CommandLineRunner departmentLineRunner(DepartmentRepository departmentRepository){
//        return args -> {
//            Department sea = new Department(
//                "School of Engineering and Architecture",
//                "Dr. Filipina I. De Guzman"
//            );
//
//            Department sba = new Department(
//                    "School of Business and Accountancy",
//                    "Dr. Maria S. Tanquilut"
//            );
//            departmentRepository.saveAll(List.of(sba,sea));
//        };
//    }
//}
