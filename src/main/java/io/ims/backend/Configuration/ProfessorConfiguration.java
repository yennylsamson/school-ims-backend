//package io.ims.backend.Configuration;
//
//import io.ims.backend.Models.Admin;
//import io.ims.backend.Models.Professor;
//import io.ims.backend.Repository.ProfessorRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.time.LocalDate;
//import java.time.Month;
//import java.util.List;
//
//@Configuration
//public class ProfessorConfiguration {
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
//                    "Married",
//                    1L
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
//                    "Single",
//                    2L
//            );
//            professorRepository.saveAll(List.of(niyo, mitra));
//        };
//    }
//}
