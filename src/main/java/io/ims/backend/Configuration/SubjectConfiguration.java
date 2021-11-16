package io.ims.backend.Configuration;

import io.ims.backend.Models.Subject;
import io.ims.backend.Repository.SubjectRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SubjectConfiguration {
    @Bean
    CommandLineRunner subjectLineRunner(SubjectRepository subjectRepository){
        return args -> {
          Subject calculus = new Subject(
                  "Calculus 1",
                  "CALC1",
                  "3",
                  1,
                  0,
                  2L
          );
          Subject physicsLab = new Subject(
                    "Physics Lab",
                    "PHYSICSL",
                    "1",
                    0,
                    3,
                    2L
            );
          subjectRepository.saveAll(List.of(calculus,physicsLab));
        };
    }
}
