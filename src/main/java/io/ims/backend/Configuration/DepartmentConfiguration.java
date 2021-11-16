//package io.ims.backend.Configuration;
//
//import io.ims.backend.Models.Department;
//import io.ims.backend.Repository.DepartmentRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.List;
//
//@Configuration
//public class DepartmentConfiguration {
//    @Bean
//    CommandLineRunner departmentLineRunner(DepartmentRepository departmentRepository){
//        return args -> {
//            Department sea = new Department(
//                2L,
//                "School of Engineering and Architecture",
//                    "Dr. Filipina I. De Guzman"
//            );
//
//            Department sba = new Department(
//                    1L,
//                    "School of Business and Accountancy",
//                    "Dr. Maria S. Tanquilut"
//            );
//            departmentRepository.saveAll(List.of(sba,sea));
//        };
//    }
//}
