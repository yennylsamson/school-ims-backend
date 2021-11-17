//package io.ims.backend.Configuration;
//
//import io.ims.backend.Models.Activity;
//import io.ims.backend.Models.Student;
//import io.ims.backend.Repository.ActivityRepository;
//import io.ims.backend.Repository.StudentRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.DependsOn;
//
//import java.util.List;
//
//@DependsOn("StudentConfiguration")
//@Configuration
//public class ActivityConfiguration {
//    private final StudentRepository studentRepository;
//
//    @Autowired
//    public ActivityConfiguration(StudentRepository studentRepository) {
//        this.studentRepository = studentRepository;
//    }
//
//    @Bean
//    CommandLineRunner activityLineRunner(ActivityRepository activityRepository){
//        return args -> {
//            Activity activity1 = new Activity(
//                    "Activity 1",
//                    "Assignment",
//                    24,
//                    30
//            );
//            Activity activity2 = new Activity(
//                    "Activity 2",
//                    "Assignment",
//                    28,
//                    30
//            );
//            Student ailger = studentRepository.getById()
//            activityRepository.saveAll(List.of(activity1,activity2));
//        };
//    }
//}
