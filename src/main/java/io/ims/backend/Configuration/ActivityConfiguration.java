package io.ims.backend.Configuration;

import io.ims.backend.Models.Activity;
import io.ims.backend.Models.Professor;
import io.ims.backend.Models.Student;
import io.ims.backend.Repository.ActivityRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

//@Configuration
//public class ActivityConfiguration {
//    @Bean
//    CommandLineRunner activityLineRunner(ActivityRepository activityRepository){
//        return args -> {
//            Activity activity1 = new Activity(
//                    "Activity 1",
//                    "Assignment",
//                    24,
//                    30,
//                    ailger,
//                    niyo
//            );
//            Activity activity2 = new Activity(
//                    "Activity 2",
//                    "Assignment",
//                    28,
//                    30,
//                    ailger,
//                    niyo
//            );
//            activityRepository.saveAll(List.of(activity1,activity2));
//        };
//    }
//}
