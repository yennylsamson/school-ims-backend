package io.ims.backend.Configuration;

import io.ims.backend.Models.Activity;
import io.ims.backend.Repository.ActivityRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ActivityConfiguration {
    @Bean
    CommandLineRunner activityLineRunner(ActivityRepository activityRepository){
        return args -> {
            Activity activity1 = new Activity(
                    1L,
                    "Activity 1",
                    "Multiple Choice",
                    24,
                    30
            );
            Activity activity2 = new Activity(
                    2L,
                    "Activity 2",
                    "Identification",
                    28,
                    30
            );
            activityRepository.saveAll(List.of(activity1,activity2));
        };
    }
}
