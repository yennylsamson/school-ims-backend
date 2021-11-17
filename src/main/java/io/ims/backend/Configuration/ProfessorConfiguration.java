//package io.ims.backend.Configuration;
//
//import io.ims.backend.Models.Department;
//import io.ims.backend.Models.Professor;
//import io.ims.backend.Repository.DepartmentRepository;
//import io.ims.backend.Repository.ProfessorRepository;
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
//import java.time.LocalDate;
//import java.time.Month;
//import java.util.List;
//
//@AutoConfigureAfter(ProfessorConfiguration.class)
//@ComponentScan("io.ims.backend.*")
//@Configuration
//public class ProfessorConfiguration {
//    private final DepartmentRepository departmentRepository;
//
//    @Autowired
//    public ProfessorConfiguration(DepartmentRepository departmentRepository) {
//        this.departmentRepository = departmentRepository;
//    }
//
//    @Bean
//    CommandLineRunner professorLineRunner(ProfessorRepository professorRepository){
//        return args -> {
//            Professor niyo = new Professor(
//                    "niyo@professor.email.com",
//                    "profpass",
//                    "professor",
//                    "Niyo Kenn",
//                    "Jimenez",
//                    "Male",
//                    LocalDate.of(2000, Month.JANUARY,1),
//                    "Angeles City",
//                    "09123456789",
//                    "Married"
//            );
//            Professor mitra = new Professor(
//                    "mitra@professor.email.com",
//                    "profpass",
//                    "professor",
//                    "Michael",
//                    "Mitra",
//                    "Male",
//                    LocalDate.of(2000, Month.JANUARY,1),
//                    "Angeles City",
//                    "09123456789",
//                    "Single"
//            );
//            Department SEA = departmentRepository.getById(1L);
//            niyo.setDepartment(SEA);
//            mitra.setDepartment(SEA);
//            professorRepository.saveAll(List.of(niyo, mitra));
//        };
//    }
//}
