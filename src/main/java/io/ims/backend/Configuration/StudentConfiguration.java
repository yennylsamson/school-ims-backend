package io.ims.backend.Configuration;


import io.ims.backend.Models.Student;
import io.ims.backend.Repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfiguration {
    @Bean
    CommandLineRunner studentLineRunner(StudentRepository studentRepository) {
        return args -> {
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
                    1L,
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
                    2L,
                    "CpE-401"
            );
            studentRepository.saveAll(
                    List.of(ailger, glenn)
            );
        };
    }
}
