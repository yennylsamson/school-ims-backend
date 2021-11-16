package io.ims.backend.Configuration;

import io.ims.backend.Models.Admin;
import io.ims.backend.Repository.AdminRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class AdminConfiguration {
    @Bean
    CommandLineRunner adminLineRunner(AdminRepository adminRepository){
        return args -> {
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
        };
    }
}
