//package io.ims.backend.Configuration;
//
//import io.ims.backend.Models.Department;
//import io.ims.backend.Models.Subject;
//import io.ims.backend.Repository.DepartmentRepository;
//import io.ims.backend.Repository.SubjectRepository;
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
//import java.util.List;
//
//@AutoConfigureAfter(ProfessorConfiguration.class)
//@ComponentScan("io.ims.backend.*")
//@Configuration
//public class SubjectConfiguration {
//    private final DepartmentRepository departmentRepository;
//
//    @Autowired
//    public SubjectConfiguration(DepartmentRepository departmentRepository) {
//        this.departmentRepository = departmentRepository;
//    }
//
//    @Bean
//    CommandLineRunner subjectLineRunner(SubjectRepository subjectRepository){
//        return args -> {
//          Subject calculus = new Subject(
//                  "Calculus 1",
//                  "CALC1",
//                  "3",
//                  1,
//                  0
//          );
//          Subject physicsLab = new Subject(
//                    "Physics Lab",
//                    "PHYSICSL",
//                    "1",
//                    0,
//                    3
//          );
//          Department SEA = departmentRepository.getById(1L);
//          calculus.setDepartment(SEA);
//          physicsLab.setDepartment(SEA);
//          subjectRepository.saveAll(List.of(calculus,physicsLab));
//        };
//    }
//}
