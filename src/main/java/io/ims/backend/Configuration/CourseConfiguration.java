package io.ims.backend.Configuration;

import io.ims.backend.Models.Course;
import io.ims.backend.Repository.CourseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CourseConfiguration {
    @Bean
    CommandLineRunner courseLineRunner(CourseRepository courseRepository){
        return args -> {
            Course cpe = new Course(
                    2L,
                    "Computer Engineering",
                    "CpE",
                    "Engr. Niyo Kenn Jimenez",
                    2L
            );
            Course civil = new Course(
                    1L,
                    "Computer Engineering",
                    "CpE",
                    "Engr. Filipina De Guzman",
                    2L
            );
            courseRepository.saveAll(List.of(cpe,civil));
        };
    }
}
